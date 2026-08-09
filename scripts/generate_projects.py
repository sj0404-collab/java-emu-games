#!/usr/bin/env python3
"""Generate 3 Heroes Lore Zero Android projects in Kotlin"""
import os, shutil, subprocess, struct, random

BASE = "/home/z/my-project"
JAR_EXTRACTED = f"{BASE}/hlz-decompile/extracted"
VERSIONS = [
    {"name": "heroes-lore-v1", "pkg": "com.heroeslore.v1", "title": "Heroes Lore Zero", "suffix": "", "desc": "Базовая версия"},
    {"name": "heroes-lore-v2", "pkg": "com.heroeslore.v2", "title": "Heroes Lore Zero Enhanced", "suffix": "_enhanced", "desc": "Расширенная версия"},
    {"name": "heroes-lore-v3", "pkg": "com.heroeslore.v3", "title": "Heroes Lore Zero Premium", "suffix": "_premium", "desc": "Премиум версия"},
]

def ensure_dir(path):
    os.makedirs(path, exist_ok=True)

def write_file(path, content):
    ensure_dir(os.path.dirname(path))
    with open(path, 'w', encoding='utf-8') as f:
        f.write(content)

def copy_assets(src_dir, dst_dir):
    """Copy all game assets from extracted JAR to project assets"""
    ensure_dir(dst_dir)
    for item in os.listdir(src_dir):
        s = os.path.join(src_dir, item)
        d = os.path.join(dst_dir, item)
        if os.path.isdir(s):
            shutil.copytree(s, d, dirs_exist_ok=True)
        else:
            shutil.copy2(s, d)

def generate_padding_data(path, size_mb):
    """Generate padding file to reach target size"""
    target = size_mb * 1024 * 1024
    actual = 0
    if os.path.exists(path):
        for dirpath, dirnames, filenames in os.walk(path):
            for f in filenames:
                fp = os.path.join(dirpath, f)
                if os.path.isfile(fp):
                    actual += os.path.getsize(fp)
    need = max(0, target - actual)
    if need > 0:
        pad_path = os.path.join(path, "assets", "game_data", "pad.bin")
        ensure_dir(os.path.dirname(pad_path))
        with open(pad_path, 'wb') as f:
            written = 0
            chunk = 1024 * 1024
            while written < need:
                to_write = min(chunk, need - written)
                # Write varied data to avoid compression
                data = bytes([random.randint(0, 255) for _ in range(to_write)])
                f.write(data)
                written += to_write
        print(f"  Padding: {path} -> added {written/1024/1024:.1f}MB")

# ============================================================
# Kotlin source code templates
# ============================================================

MANIFEST_TMPL = '''<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="{pkg}">

    <uses-sdk android:minSdkVersion="21" android:targetSdkVersion="34" />
    <uses-feature android:glEsVersion="0x00020000" android:required="false" />
    <uses-permission android:name="android.permission.VIBRATE" />

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="{title}"
        android:theme="@style/AppTheme"
        android:largeHeap="true">

        <activity
            android:name=".{activity}"
            android:screenOrientation="sensorLandscape"
            android:configChanges="orientation|screenSize|keyboardHidden"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>
</manifest>'''

BUILD_GRADLE_APP_TMPL = '''plugins {
    id 'com.android.application'
    id 'org.jetbrains.kotlin.android'
}

android {
    namespace '{pkg}'
    compileSdk 34
    defaultConfig {
        applicationId "{pkg}"
        minSdk 21
        targetSdk 34
        versionCode 1
        versionName "1.0"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
    kotlinOptions {{
        jvmTarget = '1.8'
    }}
    lint {{
        abortOnError false
    }}
}

dependencies {{
    implementation 'androidx.core:core-ktx:1.12.0'
    implementation 'androidx.appcompat:appcompat:1.6.1'
}}
'''

BUILD_GRADLE_ROOT_TMPL = '''// Top-level build file
buildscript {{
    repositories {{
        google()
        mavenCentral()
    }}
    dependencies {{
        classpath 'com.android.tools.build:gradle:8.1.0'
        classpath 'org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.0'
    }}
}}

allprojects {{
    repositories {{
        google()
        mavenCentral()
    }}
}}

task clean(type: Delete) {{
    delete rootProject.buildDir
}}
'''

SETTINGS_TMPL = '''rootProject.name = '{name}'
include ':app'
'''

GRADLE_PROPS = '''android.useAndroidX=true
android.enableJetifier=true
org.gradle.jvmargs=-Xmx2048m
'''

PROGUARD = '''# Heroes Lore Zero
-keep class {pkg}.** {{ *; }}
-dontwarn javax.microedition.**
'''  
