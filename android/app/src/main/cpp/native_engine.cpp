#include <android/log.h>
#include <jni.h>

#include <algorithm>
#include <cstdint>
#include <climits>
#include <memory>
#include <stdexcept>
#include <sstream>
#include <string>
#include <vector>

#include "chat.h"
#include "common.h"
#include "llama.h"
#include "sampling.h"

namespace {

constexpr const char * TAG = "LocalAI";
constexpr int BATCH_SIZE = 256;
constexpr int CONTEXT_HEADROOM = 4;
constexpr int MIN_REPLY_TOKENS = 48;

llama_model * g_model = nullptr;
llama_context * g_context = nullptr;
llama_batch g_batch{};
bool g_batch_ready = false;
common_chat_templates_ptr g_templates;
common_sampler * g_sampler = nullptr;
std::vector<common_chat_msg> g_messages;

bool g_backend_ready = false;
bool g_generation_active = false;
bool g_has_template = false;
llama_pos g_system_position = 0;
llama_pos g_position = 0;
int g_reply_limit = 0;
int g_generated = 0;
std::string g_pending_utf8;
std::string g_assistant;
std::string g_last_error;

void set_error(const std::string & message) {
    g_last_error = message;
    __android_log_print(ANDROID_LOG_ERROR, TAG, "%s", message.c_str());
}

void log_callback(enum ggml_log_level level, const char * text, void *) {
    int priority = ANDROID_LOG_INFO;
    if (level == GGML_LOG_LEVEL_ERROR) priority = ANDROID_LOG_ERROR;
    if (level == GGML_LOG_LEVEL_WARN) priority = ANDROID_LOG_WARN;
    if (level == GGML_LOG_LEVEL_DEBUG || level == GGML_LOG_LEVEL_CONT) priority = ANDROID_LOG_DEBUG;
    __android_log_write(priority, TAG, text);
}

std::string from_java(JNIEnv * env, jstring value) {
    if (value == nullptr) return {};
    const jchar * chars = env->GetStringChars(value, nullptr);
    if (chars == nullptr) return {};
    const jsize length = env->GetStringLength(value);
    std::string out;
    out.reserve(static_cast<size_t>(length) * 2);
    for (jsize i = 0; i < length; ++i) {
        uint32_t cp = chars[i];
        if (cp >= 0xD800 && cp <= 0xDBFF && i + 1 < length) {
            const uint32_t low = chars[i + 1];
            if (low >= 0xDC00 && low <= 0xDFFF) {
                cp = 0x10000 + ((cp - 0xD800) << 10) + (low - 0xDC00);
                ++i;
            }
        }
        if (cp <= 0x7F) {
            out.push_back(static_cast<char>(cp));
        } else if (cp <= 0x7FF) {
            out.push_back(static_cast<char>(0xC0 | (cp >> 6)));
            out.push_back(static_cast<char>(0x80 | (cp & 0x3F)));
        } else if (cp <= 0xFFFF) {
            out.push_back(static_cast<char>(0xE0 | (cp >> 12)));
            out.push_back(static_cast<char>(0x80 | ((cp >> 6) & 0x3F)));
            out.push_back(static_cast<char>(0x80 | (cp & 0x3F)));
        } else {
            out.push_back(static_cast<char>(0xF0 | (cp >> 18)));
            out.push_back(static_cast<char>(0x80 | ((cp >> 12) & 0x3F)));
            out.push_back(static_cast<char>(0x80 | ((cp >> 6) & 0x3F)));
            out.push_back(static_cast<char>(0x80 | (cp & 0x3F)));
        }
    }
    env->ReleaseStringChars(value, chars);
    return out;
}

jstring to_java(JNIEnv * env, const std::string & utf8) {
    jbyteArray bytes = env->NewByteArray(static_cast<jsize>(utf8.size()));
    if (bytes == nullptr) return nullptr;
    if (!utf8.empty()) {
        env->SetByteArrayRegion(bytes, 0, static_cast<jsize>(utf8.size()),
                                reinterpret_cast<const jbyte *>(utf8.data()));
    }
    jclass string_class = env->FindClass("java/lang/String");
    jmethodID ctor = env->GetMethodID(string_class, "<init>", "([BLjava/lang/String;)V");
    jstring charset = env->NewStringUTF("UTF-8");
    auto result = static_cast<jstring>(env->NewObject(string_class, ctor, bytes, charset));
    env->DeleteLocalRef(charset);
    env->DeleteLocalRef(string_class);
    env->DeleteLocalRef(bytes);
    return result;
}

bool complete_utf8(const std::string & value) {
    size_t i = 0;
    while (i < value.size()) {
        const unsigned char first = static_cast<unsigned char>(value[i]);
        size_t width = 0;
        if ((first & 0x80) == 0) width = 1;
        else if ((first & 0xE0) == 0xC0) width = 2;
        else if ((first & 0xF0) == 0xE0) width = 3;
        else if ((first & 0xF8) == 0xF0) width = 4;
        else return false;
        if (i + width > value.size()) return false;
        for (size_t n = 1; n < width; ++n) {
            if ((static_cast<unsigned char>(value[i + n]) & 0xC0) != 0x80) return false;
        }
        i += width;
    }
    return true;
}

void free_sampler() {
    if (g_sampler != nullptr) common_sampler_free(g_sampler);
    g_sampler = nullptr;
}

void unload_internal() {
    free_sampler();
    g_templates.reset();
    g_messages.clear();
    if (g_batch_ready) llama_batch_free(g_batch);
    g_batch = {};
    g_batch_ready = false;
    if (g_context != nullptr) llama_free(g_context);
    if (g_model != nullptr) llama_model_free(g_model);
    g_context = nullptr;
    g_model = nullptr;
    g_generation_active = false;
    g_system_position = 0;
    g_position = 0;
    g_pending_utf8.clear();
    g_assistant.clear();
}

void reset_generation() {
    g_generation_active = false;
    g_reply_limit = 0;
    g_generated = 0;
    g_pending_utf8.clear();
    g_assistant.clear();
}

std::vector<llama_token> tokenize(const std::string & text, bool add_special, bool parse_special) {
    const llama_vocab * vocab = llama_model_get_vocab(g_model);
    int32_t count = llama_tokenize(vocab, text.data(), static_cast<int32_t>(text.size()),
                                   nullptr, 0, add_special, parse_special);
    if (count == INT32_MIN) throw std::runtime_error("Слишком большой текст для токенизации");
    if (count < 0) count = -count;
    std::vector<llama_token> tokens(static_cast<size_t>(count));
    if (count == 0) return tokens;
    int32_t actual = llama_tokenize(vocab, text.data(), static_cast<int32_t>(text.size()),
                                    tokens.data(), count, add_special, parse_special);
    if (actual < 0) throw std::runtime_error("Токенизация завершилась ошибкой");
    tokens.resize(static_cast<size_t>(actual));
    return tokens;
}

bool decode(const std::vector<llama_token> & tokens, bool logits_on_last) {
    for (size_t offset = 0; offset < tokens.size(); offset += BATCH_SIZE) {
        const int count = static_cast<int>(std::min<size_t>(BATCH_SIZE, tokens.size() - offset));
        common_batch_clear(g_batch);
        for (int i = 0; i < count; ++i) {
            const bool logits = logits_on_last && offset + static_cast<size_t>(i) == tokens.size() - 1;
            common_batch_add(g_batch, tokens[offset + static_cast<size_t>(i)],
                             g_position + i, {0}, logits);
        }
        if (llama_decode(g_context, g_batch) != 0) {
            set_error("llama_decode не смог обработать токены");
            return false;
        }
        g_position += count;
    }
    return true;
}

void shift_context_until(int tokens_needed) {
    const int n_ctx = static_cast<int>(llama_n_ctx(g_context));
    while (g_position + tokens_needed >= n_ctx - CONTEXT_HEADROOM) {
        const int available_history = g_position - g_system_position;
        const int discard = available_history / 2;
        if (discard <= 0) break;
        llama_memory_t memory = llama_get_memory(g_context);
        llama_memory_seq_rm(memory, 0, g_system_position, g_system_position + discard);
        llama_memory_seq_add(memory, 0, g_system_position + discard, g_position, -discard);
        g_position -= discard;
    }
}

std::string format_and_add(const std::string & role, const std::string & content, bool add_assistant) {
    common_chat_msg message;
    message.role = role;
    message.content = content;
    std::string formatted;
    if (g_has_template) {
        formatted = common_chat_format_single(g_templates.get(), g_messages, message,
                                               add_assistant, false);
    } else if (role == "system") {
        formatted = "System: " + content + "\n";
    } else if (role == "user") {
        formatted = "\nUser: " + content + "\nAssistant:";
    } else {
        formatted = content;
    }
    g_messages.push_back(std::move(message));
    return formatted;
}

void commit_assistant(bool append_template_closure) {
    if (!g_generation_active) return;

    if (append_template_closure && g_has_template && !g_assistant.empty()) {
        common_chat_msg message;
        message.role = "assistant";
        message.content = g_assistant;
        const std::string formatted = common_chat_format_single(
            g_templates.get(), g_messages, message, false, false);
        const size_t content_at = formatted.rfind(g_assistant);
        if (content_at != std::string::npos) {
            const std::string closure = formatted.substr(content_at + g_assistant.size());
            if (!closure.empty()) {
                auto tokens = tokenize(closure, false, true);
                shift_context_until(static_cast<int>(tokens.size()));
                decode(tokens, false);
            }
        }
        g_messages.push_back(std::move(message));
    } else {
        common_chat_msg message;
        message.role = "assistant";
        message.content = g_assistant;
        g_messages.push_back(std::move(message));
    }
    g_generation_active = false;
}

int fail_if_unloaded() {
    if (g_model != nullptr && g_context != nullptr) return 0;
    set_error("Сначала загрузите GGUF-модель");
    return 1;
}

} // namespace

extern "C" JNIEXPORT jint JNICALL
Java_com_localai_phone_LlamaEngine_nativeInit(JNIEnv *, jclass) {
    try {
        g_last_error.clear();
        if (!g_backend_ready) {
            llama_log_set(log_callback, nullptr);
            llama_backend_init();
            g_backend_ready = true;
        }
        return 0;
    } catch (const std::exception & error) {
        set_error(error.what());
        return 1;
    }
}

extern "C" JNIEXPORT jint JNICALL
Java_com_localai_phone_LlamaEngine_nativeLoad(
        JNIEnv * env, jclass, jstring model_path, jint context_size, jint threads) {
    try {
        g_last_error.clear();
        unload_internal();
        llama_model_params model_params = llama_model_default_params();
        model_params.n_gpu_layers = 0;
        const std::string path = from_java(env, model_path);
        g_model = llama_model_load_from_file(path.c_str(), model_params);
        if (g_model == nullptr) {
            set_error("llama.cpp не распознал файл как поддерживаемый GGUF");
            return 1;
        }

        llama_context_params params = llama_context_default_params();
        params.n_ctx = static_cast<uint32_t>(std::clamp<int>(context_size, 512, 4096));
        params.n_batch = BATCH_SIZE;
        params.n_ubatch = 128;
        params.n_threads = std::clamp<int>(threads, 1, 4);
        params.n_threads_batch = params.n_threads;
        params.offload_kqv = false;
        g_context = llama_init_from_model(g_model, params);
        if (g_context == nullptr) {
            set_error("Недостаточно памяти для контекста модели");
            unload_internal();
            return 2;
        }

        g_batch = llama_batch_init(BATCH_SIZE, 0, 1);
        g_batch_ready = true;
        g_templates = common_chat_templates_init(g_model, "");
        g_has_template = g_templates && common_chat_templates_was_explicit(g_templates.get());
        g_messages.clear();
        g_position = 0;
        g_system_position = 0;
        reset_generation();
        return 0;
    } catch (const std::exception & error) {
        set_error(error.what());
        unload_internal();
        return 3;
    }
}

extern "C" JNIEXPORT jint JNICALL
Java_com_localai_phone_LlamaEngine_nativeSetSystemPrompt(
        JNIEnv * env, jclass, jstring system_prompt) {
    try {
        g_last_error.clear();
        if (fail_if_unloaded()) return 1;
        free_sampler();
        reset_generation();
        g_messages.clear();
        g_position = 0;
        llama_memory_clear(llama_get_memory(g_context), false);

        const std::string prompt = from_java(env, system_prompt);
        const std::string formatted = format_and_add("system", prompt, false);
        const auto tokens = tokenize(formatted, g_has_template, g_has_template);
        const int max_tokens = static_cast<int>(llama_n_ctx(g_context)) - CONTEXT_HEADROOM - MIN_REPLY_TOKENS;
        if (static_cast<int>(tokens.size()) > max_tokens) {
            set_error("Системная инструкция не помещается в выбранный контекст");
            return 2;
        }
        if (!decode(tokens, false)) return 3;
        g_system_position = g_position;
        return 0;
    } catch (const std::exception & error) {
        set_error(error.what());
        return 4;
    }
}

extern "C" JNIEXPORT jint JNICALL
Java_com_localai_phone_LlamaEngine_nativeStartPrompt(
        JNIEnv * env, jclass, jstring user_prompt, jint max_tokens, jfloat temperature) {
    try {
        g_last_error.clear();
        if (fail_if_unloaded()) return 1;
        if (g_generation_active) commit_assistant(true);
        reset_generation();

        const std::string prompt = from_java(env, user_prompt);
        const std::string formatted = format_and_add("user", prompt, true);
        auto tokens = tokenize(formatted, g_has_template, g_has_template);
        const int capacity = static_cast<int>(llama_n_ctx(g_context)) - CONTEXT_HEADROOM;
        const int max_user_tokens = capacity - g_system_position - MIN_REPLY_TOKENS;
        if (static_cast<int>(tokens.size()) > max_user_tokens) {
            g_messages.pop_back();
            set_error("Запрос/файл слишком длинный для контекста; сократите его или выберите больший контекст");
            return 2;
        }

        const int requested_reply = std::clamp<int>(max_tokens, 1, 1024);
        shift_context_until(static_cast<int>(tokens.size()) + std::min(requested_reply, MIN_REPLY_TOKENS));
        const int reply_room = capacity - g_position - static_cast<int>(tokens.size());
        if (reply_room <= 0) {
            g_messages.pop_back();
            set_error("Контекст заполнен и не может быть сдвинут");
            return 3;
        }
        if (!decode(tokens, true)) {
            g_messages.pop_back();
            return 4;
        }

        free_sampler();
        common_params_sampling sampling;
        sampling.temp = std::clamp<float>(temperature, 0.0f, 2.0f);
        sampling.top_k = 40;
        sampling.top_p = 0.92f;
        sampling.min_p = 0.05f;
        sampling.penalty_repeat = 1.08f;
        g_sampler = common_sampler_init(g_model, sampling);
        if (g_sampler == nullptr) {
            set_error("Не удалось создать sampler");
            return 5;
        }

        g_reply_limit = std::min(requested_reply, reply_room);
        g_generated = 0;
        g_pending_utf8.clear();
        g_assistant.clear();
        g_generation_active = true;
        return 0;
    } catch (const std::exception & error) {
        set_error(error.what());
        return 6;
    }
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_localai_phone_LlamaEngine_nativeNextToken(JNIEnv * env, jclass) {
    try {
        if (!g_generation_active || g_generated >= g_reply_limit) {
            if (g_generation_active) commit_assistant(true);
            return nullptr;
        }
        if (g_sampler == nullptr) {
            set_error("Sampler не инициализирован");
            g_generation_active = false;
            return nullptr;
        }

        const llama_token token = common_sampler_sample(g_sampler, g_context, -1);
        common_sampler_accept(g_sampler, token, true);
        common_batch_clear(g_batch);
        common_batch_add(g_batch, token, g_position, {0}, true);
        if (llama_decode(g_context, g_batch) != 0) {
            set_error("llama_decode завершился ошибкой при генерации");
            g_generation_active = false;
            return nullptr;
        }
        ++g_position;
        ++g_generated;

        if (llama_vocab_is_eog(llama_model_get_vocab(g_model), token)) {
            commit_assistant(false);
            return nullptr;
        }

        char stack_buffer[256];
        int32_t length = llama_token_to_piece(llama_model_get_vocab(g_model), token,
                                              stack_buffer, sizeof(stack_buffer), 0, false);
        std::string piece;
        if (length < 0) {
            piece.resize(static_cast<size_t>(-length));
            length = llama_token_to_piece(llama_model_get_vocab(g_model), token,
                                          piece.data(), static_cast<int32_t>(piece.size()), 0, false);
            if (length < 0) throw std::runtime_error("Не удалось преобразовать токен в текст");
            piece.resize(static_cast<size_t>(length));
        } else {
            piece.assign(stack_buffer, static_cast<size_t>(length));
        }

        g_pending_utf8 += piece;
        if (!complete_utf8(g_pending_utf8)) return to_java(env, "");
        std::string ready = std::move(g_pending_utf8);
        g_pending_utf8.clear();
        g_assistant += ready;
        return to_java(env, ready);
    } catch (const std::exception & error) {
        set_error(error.what());
        g_generation_active = false;
        return nullptr;
    }
}

extern "C" JNIEXPORT void JNICALL
Java_com_localai_phone_LlamaEngine_nativeFinishGeneration(JNIEnv *, jclass) {
    try {
        if (!g_pending_utf8.empty()) {
            g_assistant += g_pending_utf8;
            g_pending_utf8.clear();
        }
        commit_assistant(true);
    } catch (const std::exception & error) {
        set_error(error.what());
        g_generation_active = false;
    }
}

extern "C" JNIEXPORT void JNICALL
Java_com_localai_phone_LlamaEngine_nativeUnload(JNIEnv *, jclass) {
    unload_internal();
}

extern "C" JNIEXPORT void JNICALL
Java_com_localai_phone_LlamaEngine_nativeShutdown(JNIEnv *, jclass) {
    unload_internal();
    if (g_backend_ready) llama_backend_free();
    g_backend_ready = false;
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_localai_phone_LlamaEngine_nativeLastError(JNIEnv * env, jclass) {
    return to_java(env, g_last_error);
}
