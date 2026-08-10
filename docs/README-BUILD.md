# Build valid APK via GitHub

1. Через GitHub Web UI: скопируйте docs/github-workflow-build.yml -> .github/workflows/build.yml (кнопка Add file)
2. Или переподключите Arena GitHub с галочкой workflow и выполните: git push origin arena/019feb6d-java-emu-games
3. Затем Actions -> Build APK -> Run workflow -> arena/019feb6d-java-emu-games

Валидный APK: heroes-lore-v1/debug-apk/app-debug.apk 2.0M, нативный Kotlin, без MIDlet, debug-ключ
