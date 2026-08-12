package com.localai.phone;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.provider.OpenableColumns;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public final class MainActivity extends Activity implements TextToSpeech.OnInitListener {
    private static final int PICK_MODEL = 40;
    private static final int PICK_TEXT = 41;
    private static final int SPEECH = 42;
    private static final long MIB = 1024L * 1024L;
    private static final long MAX_MODEL_FILE = 2048L * MIB;
    private static final long MAX_ESTIMATED_NATIVE = 1900L * MIB;
    private static final long MAX_ATTACHMENT = 1L * MIB;

    private final ExecutorService worker = Executors.newSingleThreadExecutor();
    private final Handler main = new Handler(Looper.getMainLooper());
    private final AtomicBoolean cancelled = new AtomicBoolean();
    private final LlamaEngine engine = new LlamaEngine();
    private final StringBuilder transcript = new StringBuilder();

    private TextView status;
    private TextView chat;
    private ScrollView chatScroll;
    private EditText input;
    private Spinner profile;
    private Spinner context;
    private Button modelButton;
    private Button sendButton;
    private Button attachButton;
    private Button micButton;
    private Button clearButton;
    private CheckBox speakAnswers;
    private TextToSpeech tts;

    private boolean modelReady;
    private boolean generating;
    private int appliedProfile = -1;
    private String attachmentText;
    private String attachmentName;

    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);
        getWindow().setStatusBarColor(Color.rgb(17, 24, 39));
        getWindow().setNavigationBarColor(Color.rgb(11, 16, 32));
        setContentView(createUi());
        bindActions();

        tts = new TextToSpeech(this, this);
        setBusy(true, "Запуск локального движка…");
        worker.execute(() -> {
            try {
                engine.initialize();
                main.post(() -> {
                    setBusy(false, "Выберите одиночный файл .gguf (он не копируется в APK)");
                    SharedPreferences prefs = getPreferences(MODE_PRIVATE);
                    String last = prefs.getString("last_model_name", "");
                    if (!last.isEmpty()) status.setText("Последняя модель: " + last + ". Выберите её снова для загрузки.");
                });
            } catch (Throwable error) {
                main.post(() -> showError("Не удалось запустить llama.cpp", error));
            }
        });
    }

    private View createUi() {
        int pad = dp(16);
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(pad, dp(12), pad, dp(10));
        root.setBackgroundColor(Color.rgb(11, 16, 32));

        TextView title = text("Локальный AI", 25, Color.WHITE);
        title.setTypeface(title.getTypeface(), 1);
        root.addView(title);
        TextView subtitle = text("GGUF · llama.cpp · данные остаются на телефоне", 12, Color.rgb(156, 163, 175));
        root.addView(subtitle, margins(-1, -2, 0, 8));

        status = text("Инициализация…", 13, Color.rgb(191, 205, 255));
        status.setPadding(dp(10), dp(9), dp(10), dp(9));
        status.setBackgroundColor(Color.rgb(25, 35, 61));
        root.addView(status, margins(-1, -2, 0, 8));

        LinearLayout modelRow = row();
        modelButton = button("Импорт GGUF");
        attachButton = button("Файл");
        micButton = button("🎙 Голос");
        modelRow.addView(modelButton, weighted());
        modelRow.addView(attachButton, weighted());
        modelRow.addView(micButton, weighted());
        root.addView(modelRow, margins(-1, -2, 0, 6));

        LinearLayout options = row();
        profile = spinner(PromptProfiles.LABELS);
        context = spinner(new String[] { "Контекст 1024", "Контекст 2048", "Контекст 4096" });
        context.setSelection(1);
        options.addView(profile, weighted());
        options.addView(context, weighted());
        root.addView(options, margins(-1, -2, 0, 4));

        LinearLayout voiceRow = row();
        speakAnswers = new CheckBox(this);
        speakAnswers.setText("Озвучивать ответы локальным Android TTS");
        speakAnswers.setTextColor(Color.rgb(220, 226, 240));
        clearButton = button("Очистить диалог");
        voiceRow.addView(speakAnswers, weighted());
        voiceRow.addView(clearButton);
        root.addView(voiceRow, margins(-1, -2, 0, 4));

        chat = text("Импортируйте instruct/chat GGUF. Рекомендуется Qwen3 0.6B Q4_K_M (~484 МБ).\n", 15, Color.rgb(229, 231, 235));
        chat.setTextIsSelectable(true);
        chat.setPadding(dp(12), dp(10), dp(12), dp(12));
        chat.setBackgroundColor(Color.rgb(17, 24, 39));
        chatScroll = new ScrollView(this);
        chatScroll.addView(chat, new ScrollView.LayoutParams(-1, -2));
        root.addView(chatScroll, new LinearLayout.LayoutParams(-1, 0, 1f));

        input = new EditText(this);
        input.setHint("Сначала импортируйте GGUF…");
        input.setTextColor(Color.WHITE);
        input.setHintTextColor(Color.rgb(107, 114, 128));
        input.setBackgroundColor(Color.rgb(31, 41, 55));
        input.setPadding(dp(12), dp(10), dp(12), dp(10));
        input.setMinLines(2);
        input.setMaxLines(5);
        input.setEnabled(false);
        root.addView(input, margins(-1, -2, 0, 6));

        sendButton = button("Отправить");
        sendButton.setEnabled(false);
        root.addView(sendButton, new LinearLayout.LayoutParams(-1, dp(48)));

        TextView note = text("Лимит приложения: одиночный GGUF до 2 ГБ, оценочный пик <1,9 ГБ. Фото/музыка требуют отдельных модулей и не имитируются текстовой моделью.", 11, Color.rgb(125, 135, 155));
        note.setGravity(Gravity.CENTER);
        root.addView(note, margins(-1, -2, 0, 4));
        return root;
    }

    private void bindActions() {
        modelButton.setOnClickListener(v -> pickModel());
        attachButton.setOnClickListener(v -> pickTextFile());
        micButton.setOnClickListener(v -> recognizeSpeech());
        clearButton.setOnClickListener(v -> clearConversation());
        sendButton.setOnClickListener(v -> {
            if (generating) {
                cancelled.set(true);
                status.setText("Останавливаю генерацию…");
            } else {
                sendPrompt();
            }
        });
    }

    private void pickModel() {
        if (generating) return;
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT)
            .addCategory(Intent.CATEGORY_OPENABLE)
            .setType("application/octet-stream")
            .addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);
        startActivityForResult(intent, PICK_MODEL);
    }

    private void pickTextFile() {
        if (generating) return;
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT)
            .addCategory(Intent.CATEGORY_OPENABLE)
            .setType("text/*")
            .addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        startActivityForResult(intent, PICK_TEXT);
    }

    private void recognizeSpeech() {
        if (!modelReady || generating) return;
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault().toLanguageTag());
        intent.putExtra(RecognizerIntent.EXTRA_PREFER_OFFLINE, true);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Говорите…");
        try {
            startActivityForResult(intent, SPEECH);
        } catch (ActivityNotFoundException error) {
            toast("На устройстве нет службы распознавания речи");
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK || data == null) return;
        if (requestCode == SPEECH) {
            ArrayList<String> results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            if (results != null && !results.isEmpty()) input.setText(results.get(0));
            return;
        }
        Uri uri = data.getData();
        if (uri == null) return;
        if (requestCode == PICK_MODEL) loadSelectedModel(uri, data.getFlags());
        if (requestCode == PICK_TEXT) loadTextAttachment(uri);
    }

    private void loadSelectedModel(Uri uri, int resultFlags) {
        String name = displayName(uri);
        if (name.toLowerCase(Locale.ROOT).endsWith(".tar.xz")) {
            toast("tar.xz нужно распаковать один раз: движок запускает GGUF напрямую");
            return;
        }
        if (!name.toLowerCase(Locale.ROOT).endsWith(".gguf")) {
            toast("Выберите одиночный файл с расширением .gguf");
            return;
        }
        long size = fileSize(uri);
        if (size <= 0 || size > MAX_MODEL_FILE) {
            toast("Нужен читаемый GGUF не больше 2 ГБ");
            return;
        }

        int contextSize = selectedContext();
        long reserve = 260L * MIB + (contextSize / 1024L) * 130L * MIB;
        long estimate = size + reserve;
        if (estimate > MAX_ESTIMATED_NATIVE) {
            toast("Эта модель с выбранным контекстом может превысить 1,9 ГБ RAM. Выберите Q4/Q3 или меньший контекст.");
            return;
        }

        try {
            int flags = resultFlags & (Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            getContentResolver().takePersistableUriPermission(uri, flags);
        } catch (SecurityException ignored) {
            // The model remains usable for this app session even if a provider cannot persist access.
        }

        setBusy(true, "Загрузка " + name + " без копирования… оценка RAM " + humanSize(estimate));
        worker.execute(() -> {
            try (ParcelFileDescriptor descriptor = getContentResolver().openFileDescriptor(uri, "r")) {
                if (descriptor == null) throw new IllegalStateException("Провайдер не открыл файл");
                String fdPath = "/proc/self/fd/" + descriptor.getFd();
                int threads = Math.max(2, Math.min(4, Runtime.getRuntime().availableProcessors() - 1));
                engine.loadModel(fdPath, contextSize, threads);
                appliedProfile = -1;
                getPreferences(MODE_PRIVATE).edit()
                    .putString("last_model_uri", uri.toString())
                    .putString("last_model_name", name)
                    .apply();
                main.post(() -> {
                    modelReady = true;
                    context.setEnabled(false);
                    setBusy(false, name + " · " + humanSize(size) + " · контекст " + contextSize);
                    input.setEnabled(true);
                    input.setHint("Введите запрос; если он неоднозначен, AI уточнит детали…");
                    sendButton.setEnabled(true);
                    input.requestFocus();
                });
            } catch (Throwable error) {
                main.post(() -> showError("Модель не загрузилась", error));
            }
        });
    }

    private void loadTextAttachment(Uri uri) {
        String name = displayName(uri);
        long size = fileSize(uri);
        if (size < 0 || size > MAX_ATTACHMENT) {
            toast("Текстовое вложение должно быть не больше 1 МБ");
            return;
        }
        worker.execute(() -> {
            try (InputStream stream = getContentResolver().openInputStream(uri)) {
                if (stream == null) throw new IllegalStateException("Файл не открылся");
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                byte[] buffer = new byte[8192];
                int read;
                while ((read = stream.read(buffer)) >= 0) {
                    if (bytes.size() + read > MAX_ATTACHMENT) throw new IllegalStateException("Файл больше 1 МБ");
                    bytes.write(buffer, 0, read);
                }
                attachmentText = bytes.toString(StandardCharsets.UTF_8);
                attachmentName = name;
                main.post(() -> status.setText("Прикреплён текст: " + name + ". Он будет добавлен к следующему запросу."));
            } catch (Throwable error) {
                main.post(() -> showError("Не удалось прочитать файл", error));
            }
        });
    }

    private void sendPrompt() {
        String visiblePrompt = input.getText().toString().trim();
        if (!modelReady || visiblePrompt.isEmpty()) return;
        input.setText("");

        String actualPrompt = visiblePrompt;
        if (attachmentText != null) {
            actualPrompt += "\n\n--- НАЧАЛО ФАЙЛА " + attachmentName + " ---\n" + attachmentText
                + "\n--- КОНЕЦ ФАЙЛА ---";
            attachmentText = null;
            attachmentName = null;
        }

        int selectedProfile = profile.getSelectedItemPosition();
        int routedProfile = PromptProfiles.resolve(selectedProfile, visiblePrompt);
        int systemProfile = selectedProfile == 0 ? 0 : routedProfile;
        appendMessage("Вы", visiblePrompt);
        appendMessage("AI", "");
        cancelled.set(false);
        generating = true;
        setGenerationUi(true);
        String promptForWorker = actualPrompt;

        worker.execute(() -> {
            try {
                if (appliedProfile != systemProfile) {
                    engine.setSystemPrompt(PromptProfiles.systemPrompt(systemProfile));
                    appliedProfile = systemProfile;
                }
                StringBuilder answerUi = new StringBuilder();
                String answer = engine.generate(
                    promptForWorker,
                    384,
                    PromptProfiles.temperature(routedProfile),
                    cancelled,
                    token -> {
                        answerUi.append(token);
                        main.post(() -> replaceLastAssistant(answerUi.toString()));
                    }
                );
                main.post(() -> {
                    if (answer.isEmpty()) replaceLastAssistant(cancelled.get() ? "[остановлено]" : "[пустой ответ]");
                    finishGeneration(answer);
                });
            } catch (Throwable error) {
                main.post(() -> {
                    replaceLastAssistant("[ошибка генерации]");
                    finishGeneration("");
                    showError("Ошибка модели", error);
                });
            }
        });
    }

    private void clearConversation() {
        if (generating) return;
        transcript.setLength(0);
        chat.setText("Диалог очищен. Контекст модели сбросится перед следующим запросом.\n");
        appliedProfile = -1;
        status.setText(modelReady ? "Готово к новому диалогу" : "Выберите GGUF-модель");
    }

    private void finishGeneration(String answer) {
        generating = false;
        setGenerationUi(false);
        status.setText(cancelled.get() ? "Генерация остановлена" : "Ответ готов · локально");
        if (!cancelled.get() && speakAnswers.isChecked() && !answer.trim().isEmpty()) speak(answer);
    }

    private void setGenerationUi(boolean busy) {
        sendButton.setText(busy ? "Стоп" : "Отправить");
        modelButton.setEnabled(!busy);
        attachButton.setEnabled(!busy);
        micButton.setEnabled(!busy && modelReady);
        clearButton.setEnabled(!busy);
        input.setEnabled(!busy && modelReady);
    }

    private void setBusy(boolean busy, String message) {
        status.setText(message);
        modelButton.setEnabled(!busy);
        attachButton.setEnabled(!busy && modelReady);
        micButton.setEnabled(!busy && modelReady);
        sendButton.setEnabled(!busy && modelReady);
    }

    private void appendMessage(String role, String body) {
        transcript.append("\n").append(role).append(" › ").append(body);
        chat.setText(transcript);
        scrollToBottom();
    }

    private void replaceLastAssistant(String body) {
        int marker = transcript.lastIndexOf("\nAI › ");
        if (marker >= 0) transcript.setLength(marker);
        transcript.append("\nAI › ").append(body);
        chat.setText(transcript);
        scrollToBottom();
    }

    private void scrollToBottom() {
        chatScroll.post(() -> chatScroll.fullScroll(View.FOCUS_DOWN));
    }

    private void speak(String text) {
        if (tts == null) return;
        tts.stop();
        int max = TextToSpeech.getMaxSpeechInputLength();
        int offset = 0;
        int part = 0;
        while (offset < text.length()) {
            int end = Math.min(text.length(), offset + max - 16);
            if (end < text.length()) {
                int sentence = text.lastIndexOf('.', end);
                if (sentence > offset + 200) end = sentence + 1;
            }
            String chunk = text.substring(offset, end);
            tts.speak(chunk, part == 0 ? TextToSpeech.QUEUE_FLUSH : TextToSpeech.QUEUE_ADD, null, "local-ai-" + part);
            offset = end;
            part++;
        }
    }

    @Override
    public void onInit(int result) {
        if (result == TextToSpeech.SUCCESS && tts != null) tts.setLanguage(Locale.getDefault());
    }

    private int selectedContext() {
        return switch (context.getSelectedItemPosition()) {
            case 0 -> 1024;
            case 2 -> 4096;
            default -> 2048;
        };
    }

    private String displayName(Uri uri) {
        try (Cursor cursor = getContentResolver().query(uri, null, null, null, null)) {
            if (cursor != null && cursor.moveToFirst()) {
                int index = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME);
                if (index >= 0) return cursor.getString(index);
            }
        }
        return uri.getLastPathSegment() == null ? "model.gguf" : uri.getLastPathSegment();
    }

    private long fileSize(Uri uri) {
        try (Cursor cursor = getContentResolver().query(uri, new String[] { OpenableColumns.SIZE }, null, null, null)) {
            if (cursor != null && cursor.moveToFirst() && !cursor.isNull(0)) {
                long size = cursor.getLong(0);
                if (size >= 0) return size;
            }
        } catch (RuntimeException ignored) {
            // Some USB/document providers do not expose metadata; try fstat below.
        }
        try (ParcelFileDescriptor descriptor = getContentResolver().openFileDescriptor(uri, "r")) {
            return descriptor == null ? -1 : descriptor.getStatSize();
        } catch (Exception ignored) {
            return -1;
        }
    }

    private void showError(String title, Throwable error) {
        modelReady = engine.isLoaded();
        generating = false;
        setGenerationUi(false);
        status.setText(title + ": " + (error.getMessage() == null ? error.getClass().getSimpleName() : error.getMessage()));
        toast(title);
    }

    private void toast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private TextView text(String value, float size, int color) {
        TextView view = new TextView(this);
        view.setText(value);
        view.setTextSize(size);
        view.setTextColor(color);
        return view;
    }

    private Button button(String value) {
        Button button = new Button(this);
        button.setText(value);
        button.setTextSize(12);
        button.setAllCaps(false);
        return button;
    }

    private Spinner spinner(String[] values) {
        Spinner spinner = new Spinner(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        return spinner;
    }

    private LinearLayout row() {
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.setGravity(Gravity.CENTER_VERTICAL);
        return layout;
    }

    private LinearLayout.LayoutParams weighted() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, -2, 1f);
        params.setMarginEnd(dp(4));
        return params;
    }

    private LinearLayout.LayoutParams margins(int width, int height, int top, int bottom) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, height);
        params.topMargin = dp(top);
        params.bottomMargin = dp(bottom);
        return params;
    }

    private int dp(int value) {
        return Math.round(value * getResources().getDisplayMetrics().density);
    }

    private String humanSize(long bytes) {
        return String.format(Locale.ROOT, "%.0f МБ", bytes / (double) MIB);
    }

    @Override
    protected void onDestroy() {
        cancelled.set(true);
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        worker.execute(engine::close);
        worker.shutdown();
        super.onDestroy();
    }
}
