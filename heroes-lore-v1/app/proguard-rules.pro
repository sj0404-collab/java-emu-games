# 2 MB target — aggressive shrinking
-keep class com.heroeslore.v1.MainActivity { *; }
-keep class com.heroeslore.v1.GameSurfaceView { *; }
-keep class com.heroeslore.v1.GameRenderer { *; }
-keep class com.heroeslore.v1.GameEngine { *; }
-keep class com.heroeslore.v1.GameData { *; }
-keep class com.heroeslore.v1.** { *; }
-dontwarn javax.microedition.**
-dontwarn org.xmlpull.v1.**
-dontwarn kotlin.**
# strip logs
-assumenosideeffects class android.util.Log { *; }
# keep only needed
-keepattributes *Annotation*,Signature,InnerClasses
-dontpreverify
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*
-optimizationpasses 2
-allowaccessmodification
-repackageclasses ''
