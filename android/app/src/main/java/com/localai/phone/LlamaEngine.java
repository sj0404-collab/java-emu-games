package com.localai.phone;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

final class LlamaEngine implements AutoCloseable {
    static {
        System.loadLibrary("local-ai");
    }

    private boolean initialized;
    private boolean loaded;

    synchronized void initialize() {
        if (initialized) return;
        int result = nativeInit();
        if (result != 0) throw failure("Не удалось запустить llama.cpp");
        initialized = true;
    }

    synchronized void loadModel(String path, int contextSize, int threads) {
        initialize();
        if (loaded) nativeUnload();
        loaded = false;
        int result = nativeLoad(path, contextSize, threads);
        if (result != 0) throw failure("GGUF не загрузился");
        loaded = true;
    }

    synchronized void setSystemPrompt(String prompt) {
        ensureLoaded();
        int result = nativeSetSystemPrompt(prompt);
        if (result != 0) throw failure("Не удалось применить профиль");
    }

    synchronized String generate(
        String prompt,
        int maxTokens,
        float temperature,
        AtomicBoolean cancelled,
        Consumer<String> onToken
    ) {
        ensureLoaded();
        int result = nativeStartPrompt(prompt, maxTokens, temperature);
        if (result != 0) throw failure("Не удалось обработать запрос");

        StringBuilder answer = new StringBuilder();
        try {
            while (!cancelled.get()) {
                String token = nativeNextToken();
                if (token == null) break;
                if (!token.isEmpty()) {
                    answer.append(token);
                    onToken.accept(token);
                }
            }
        } finally {
            nativeFinishGeneration();
        }
        String error = nativeLastError();
        if (error != null && !error.trim().isEmpty()) throw new IllegalStateException(error);
        return answer.toString().trim();
    }

    synchronized void unload() {
        if (loaded) nativeUnload();
        loaded = false;
    }

    boolean isLoaded() {
        return loaded;
    }

    @Override
    public synchronized void close() {
        unload();
        if (initialized) nativeShutdown();
        initialized = false;
    }

    private void ensureLoaded() {
        if (!loaded) throw new IllegalStateException("Сначала импортируйте GGUF-модель");
    }

    private IllegalStateException failure(String prefix) {
        String detail = nativeLastError();
        return new IllegalStateException(detail == null || detail.isBlank() ? prefix : prefix + ": " + detail);
    }

    private static native int nativeInit();
    private static native int nativeLoad(String path, int contextSize, int threads);
    private static native int nativeSetSystemPrompt(String prompt);
    private static native int nativeStartPrompt(String prompt, int maxTokens, float temperature);
    private static native String nativeNextToken();
    private static native void nativeFinishGeneration();
    private static native void nativeUnload();
    private static native void nativeShutdown();
    private static native String nativeLastError();
}
