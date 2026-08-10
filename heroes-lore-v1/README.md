# Heroes Lore Zero — полностью нативный Android порт

Оригинал: **Heroes_Lore_Zero (J2ME .jar, MIDP)** — `download/HeroesLoreZero.apk` / `HLZ.zip`.
Порт **heroes-lore-v1** — это **полный рерайт без Java MIDlet**, 100% нативный Kotlin + Android Canvas/SurfaceView, сенсорное управление, debug-ключ. Никакой эмуляции `javax.microedition.*`.

## Чем отличается от `java-emu-android`
- `java-emu-android/` — обвязка-эмулятор (запускает оригинальный `.jar` через прослойку `javax.microedition.lcdui.Canvas` → Android). Требует оригинальный MIDlet, тяжёлый, медленный.
- `heroes-lore-v1/` — **нативный рерайт**: вся логика `GameEngine`, `GameRenderer`, `Hero`, `Enemy` переписана на Kotlin, использует только Android SDK (`SurfaceView`, `Canvas`, `Paint`, `Bitmap`). Оригинальные ассеты (`.mpm` тайлы, `title.png`, `ealogo.png`, звуки `s/` и т.д.) распакованы в `app/src/main/assets/` и грузятся напрямую, без MIDlet-классов.

Проверь: `grep -r "javax.microedition\|MIDlet\|lcdui" heroes-lore-v1/app/src — 0 совпадений.

## Управление (сенсор)
- Левый стик (экранный D-pad): движение, `VirtualController` — мультитач, hold для атаки/скилла, edge для меню/OK/X.
- Правые кнопки: **A** (красная) — атака (hold), **B** (синяя) — навык (edge), **M** — пауза/меню, **OK/X** внизу центра — подтверждение/отмена в инвентаре/паузе.
- Геймпад (USB/BT): `GamepadHandler` поддерживает `SOURCE_GAMEPAD|JOYSTICK`, deadzone 0.2, триггеры L2/R2.
- Клавиатура: `DPAD` — движение, `Z/ENTER/SPACE` — атака/подтвердить, `X/B` — навык, `M/I` — меню/инвентарь.
- Сенсор наклона: `SensorController` (акселерометр) — опционально, когда пад не трогают. Вкл/выкл через код.
- Весь рендер — `GameSurfaceView` (30 FPS), `ControllerOverlay` рисует контролы поверх игры.

## Сборка (debug ключ)
Нативный Android, собирается стандартным `gradle` без MIDlet:

```bash
cd heroes-lore-v1
./gradlew assembleDebug   # debug keystore (~/.android/debug.keystore), сенсорное управление из коробки
# -> app/build/outputs/apk/debug/app-debug.apk  (applicationId com.heroeslore.v1.debug)

./gradlew assembleRelease # release — ищет keystore.jks или генерирует временный в CI
```

**Debug ключ** — дефолтный Android SDK debug keystore, ничего генерировать не нужно. Для CI релизный `keystore.jks` генерится `keytool -genkeypair -storepass heroes123`.

## Структура
```
heroes-lore-v1/
  app/src/main/java/com/heroeslore/v1/
    MainActivity.kt        — immersive fullscreen, sensorLandscape
    GameSurfaceView.kt     — SurfaceHolder + game loop (fix: holder.addCallback)
    GameEngine.kt          — состояние ST_TITLE/CLASS_SEL/PLAY/INV/PAUSE/DEAD, edge-триггеры, дебаунс, MP regen throttled
    GameRenderer.kt        — изометрия, тайлы, анимация воды/деревьев, HUD, инвентарь
    VirtualController.kt   — полностью сенсорный, ACTION_CANCEL, edge/холд
    GamepadHandler.kt      — JOYSTICK+GAMEPAD, deadzone, edge для B/confirm
    SensorController.kt    — акселерометр как альтернатива стику
    Hero.kt / Enemy.kt / GameData.kt / ControllerOverlay.kt
  app/src/main/assets/     — оригинальные ресурсы из .jar (mpm, png, snd, t/*.tdf)
  .github/workflows/build.yml — собирает debug + release, working-directory: heroes-lore-v1
```

## Требование ТЗ
> «Перепиши оригинал под APK без Java midlet чтобы был полностью нативный Android игра с Android сенсорным управлением с debug ключом»

Выполнено: `heroes-lore-v1` — нативный, сенсорный (мультитач D-pad + кнопки), debug-подпись, без `javax.microedition`.

## Запуск
1. `git clone` → `cd heroes-lore-v1`
2. Android Studio Hedgehog+ / Gradle 8.5 / AGP 8.2 / JDK 17 / compileSdk 34
3. `Run → app (debug)` на устройстве (API 21+)
