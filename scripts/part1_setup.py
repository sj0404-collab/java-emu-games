#!/usr/bin/env python3
"""Part 1: Create project structure and build files for all 3 versions"""
import os, shutil

BASE = "/home/z/my-project"
JAR_EXTRACTED = f"{BASE}/hlz-decompile/extracted"

VERSIONS = [
    {"name": "heroes-lore-v1", "pkg": "com.heroeslore.v1", "title": "Heroes Lore Zero", "activity": "MainActivity", "size_mb": 25},
    {"name": "heroes-lore-v2", "pkg": "com.heroeslore.v2", "title": "Heroes Lore Zero Enhanced", "activity": "MainActivity", "size_mb": 50},
    {"name": "heroes-lore-v3", "pkg": "com.heroeslore.v3", "title": "Heroes Lore Zero Premium", "activity": "MainActivity", "size_mb": 80},
]

def ensure(path):
    os.makedirs(path, exist_ok=True)

def w(path, content):
    ensure(os.path.dirname(path))
    with open(path, 'w', encoding='utf-8') as f:
        f.write(content)

for ver in VERSIONS:
    name = ver["name"]
    pkg = ver["pkg"]
    pkg_path = pkg.replace('.', '/')
    proj = f"{BASE}/{name}"
    print(f"\n=== Creating {name} ===")
    
    # Root build.gradle
    w(f"{proj}/build.gradle", f"""buildscript {{
    repositories {{ google(); mavenCentral() }}
    dependencies {{
        classpath 'com.android.tools.build:gradle:8.1.0'
        classpath 'org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.0'
    }}
}}
allprojects {{ repositories {{ google(); mavenCentral() }} }}
""")
    
    # settings.gradle
    w(f"{proj}/settings.gradle", f"rootProject.name = '{name}'\ninclude ':app'\n")
    
    # gradle.properties
    w(f"{proj}/gradle.properties", "android.useAndroidX=true\nandroid.enableJetifier=true\norg.gradle.jvmargs=-Xmx2048m\n")
    
    # gradle wrapper
    ensure(f"{proj}/gradle/wrapper")
    w(f"{proj}/gradle/wrapper/gradle-wrapper.properties", """distributionBase=GRADLE_USER_HOME
distributionPath=wrapper/dists
distributionUrl=https\\://services.gradle.org/distributions/gradle-8.0-bin.zip
zipStoreBase=GRADLE_USER_HOME
zipStorePath=wrapper/dists
""")
    
    # App build.gradle
    w(f"{proj}/app/build.gradle", f"""plugins {{
    id 'com.android.application'
    id 'org.jetbrains.kotlin.android'
}}
android {{
    namespace '{pkg}'
    compileSdk 34
    defaultConfig {{
        applicationId '{pkg}'
        minSdk 21
        targetSdk 34
        versionCode 1
        versionName "1.0"
    }}
    buildTypes {{
        release {{
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }}
    }}
    compileOptions {{ sourceCompatibility JavaVersion.VERSION_1_8; targetCompatibility JavaVersion.VERSION_1_8 }}
    kotlinOptions {{ jvmTarget = '1.8' }}
    lint {{ abortOnError false }}
}}
dependencies {{
    implementation 'androidx.core:core-ktx:1.12.0'
    implementation 'androidx.appcompat:appcompat:1.6.1'
}}
""")
    
    # proguard
    w(f"{proj}/app/proguard-rules.pro", f"""-keep class {pkg}.** {{ *; }}
-dontwarn javax.microedition.**
""")
    
    # AndroidManifest.xml
    w(f"{proj}/app/src/main/AndroidManifest.xml", f"""<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android" package="{pkg}">
    <uses-permission android:name="android.permission.VIBRATE" />
    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="{ver['title']}"
        android:theme="@style/AppTheme"
        android:largeHeap="true">
        <activity
            android:name=".{ver['activity']}"
            android:screenOrientation="sensorLandscape"
            android:configChanges="orientation|screenSize|keyboardHidden"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>
</manifest>
""")
    
    # Resources
    w(f"{proj}/app/src/main/res/values/styles.xml", """<?xml version="1.0" encoding="utf-8"?>
<resources>
    <style name="AppTheme" parent="android:Theme.Material.NoActionBar">
        <item name="android:windowFullscreen">true</item>
        <item name="android:windowNoTitle">true</item>
        <item name="android:windowBackground">@android:color/black</item>
    </style>
</resources>
""")
    
    w(f"{proj}/app/src/main/res/values/strings.xml", f"""<?xml version="1.0" encoding="utf-8"?>
<resources>
    <string name="app_name">{ver['title']}</string>
</resources>
""")
    
    # Launcher icon (copy from extracted)
    ensure(f"{proj}/app/src/main/res/mipmap-hdpi")
    if os.path.exists(f"{JAR_EXTRACTED}/icon.png"):
        shutil.copy2(f"{JAR_EXTRACTED}/icon.png", f"{proj}/app/src/main/res/mipmap-hdpi/ic_launcher.png")
    else:
        # Generate a simple icon
        pass
    
    # Copy all game assets
    assets_dir = f"{proj}/app/src/main/assets"
    ensure(assets_dir)
    for item in os.listdir(JAR_EXTRACTED):
        s = os.path.join(JAR_EXTRACTED, item)
        d = os.path.join(assets_dir, item)
        if os.path.isdir(s):
            shutil.copytree(s, d, dirs_exist_ok=True)
        else:
            shutil.copy2(s, d)
    
    print(f"  Assets copied: {len(os.listdir(assets_dir))} items")
    print(f"  Project structure created")

print("\n=== Part 1 complete: Project structures created ===")
