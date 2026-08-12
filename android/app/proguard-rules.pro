# JNI entry points are resolved by their Java names.
-keepclasseswithmembernames class * {
    native <methods>;
}
