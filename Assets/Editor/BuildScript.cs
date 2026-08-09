#if UNITY_EDITOR
using UnityEditor;
using UnityEngine;
using UnityEngine.SceneManagement;

public class BuildScript
{
    [MenuItem("Build/Build Android APK")]
    public static void BuildAndroid()
    {
        Debug.Log("=== Heroes Lore: Unity Build Started ===");

        // Create scene programmatically
        var scene = EditorSceneManager.NewScene(NewSceneSetup.EmptyScene, NewSceneMode.Single);

        // Main Camera
        var camObj = new GameObject("Main Camera");
        camObj.tag = "MainCamera";
        var cam = camObj.AddComponent<Camera>();
        cam.clearFlags = CameraClearFlags.SolidColor;
        cam.backgroundColor = Color.black;
        cam.orthographic = true;
        cam.orthographicSize = 240f;
        cam.nearClipPlane = 0.1f;
        cam.farClipPlane = 500f;
        camObj.AddComponent<AudioListener>();
        camObj.transform.position = new Vector3(0, 0, -100f);

        // Directional Light (needed for rendering)
        var lightObj = new GameObject("Dir Light");
        var light = lightObj.AddComponent<Light>();
        light.type = LightType.Directional;
        light.intensity = 1f;
        lightObj.transform.rotation = Quaternion.Euler(50f, -30f, 0f);

        // Game Bootstrap
        var bootstrapObj = new GameObject("GameBootstrap");
        bootstrapObj.AddComponent<HeroesLore.GameBootstrap>();

        // UI Canvas
        var canvasObj = new GameObject("UICanvas");
        var canvas = canvasObj.AddComponent<Canvas>();
        canvas.renderMode = RenderMode.ScreenSpaceOverlay;
        canvas.sortingOrder = 100;
        canvasObj.AddComponent<CanvasScaler>().uiScaleMode = CanvasScaler.ScaleMode.ConstantPixelSize;
        canvasObj.AddComponent<GraphicRaycaster>();

        // Event System (needed for UI)
        var esObj = new GameObject("EventSystem");
        esObj.AddComponent<UnityEngine.EventSystems.EventSystem>();
        esObj.AddComponent<UnityEngine.EventSystems.StandaloneInputModule>();

        // Save scene
        string scenePath = "Assets/Scenes/Main.unity";
        if (!System.IO.Directory.Exists("Assets/Scenes"))
            System.IO.Directory.CreateDirectory("Assets/Scenes");
        EditorSceneManager.SaveScene(scene, scenePath);
        Debug.Log("Scene saved to " + scenePath);

        // Configure Android settings
        PlayerSettings.SetApplicationIdentifier(BuildTargetGroup.Android, "com.heroeslore.unity");
        PlayerSettings.productName = "Heroes Lore: Zero";
        PlayerSettings.companyName = "HeroesLore";
        PlayerSettings.defaultScreenWidth = 800;
        PlayerSettings.defaultScreenHeight = 480;

        // Android-specific
#if UNITY_2022_3_OR_NEWER
        PlayerSettings.Android.minSdkVersion = AndroidSdkVersions.AndroidApiLevel22;
        PlayerSettings.Android.targetSdkVersion = AndroidSdkVersions.AndroidApiLevel34;
#else
        PlayerSettings.Android.minSdkVersion = AndroidSdkVersion.AndroidApiLevel22;
        PlayerSettings.Android.targetSdkVersion = AndroidSdkVersion.AndroidApiLevel34;
#endif
        PlayerSettings.Android.targetArchitectures = AndroidArchitecture.ARM64;
        PlayerSettings.bundleVersion = "2.0.0";
        PlayerSettings.Android.useCustomKeystore = false;
        PlayerSettings.Android.androidTVCompatibility = false;

        // Graphics
        PlayerSettings.colorSpace = ColorSpace.Linear;

        // Scripting backend
        PlayerSettings.SetScriptingBackend(BuildTargetGroup.Android, ScriptingImplementation.IL2CPP);
        PlayerSettings.SetManagedStrippingLevel(BuildTargetGroup.Android, ManagedStrippingLevel.Low);

        // Resolution
        PlayerSettings.defaultScreenWidth = 800;
        PlayerSettings.defaultScreenHeight = 480;

        // Build
        string buildPath = "build/HeroesLoreZero-Unity.apk";
        if (!System.IO.Directory.Exists("build"))
            System.IO.Directory.CreateDirectory("build");

        BuildPlayerOptions opts = new BuildPlayerOptions
        {
            scenes = new[] { scenePath },
            locationPathName = buildPath,
            target = BuildTarget.Android,
            options = BuildOptions.None
        };

        Debug.Log("Starting Android build...");
        var result = BuildPipeline.BuildPlayer(opts);

        if (result.summary.result == UnityEditor.BuildReporting.BuildResult.Succeeded)
        {
            Debug.Log("BUILD SUCCEEDED! APK: " + buildPath);
            Debug.Log("Size: " + (new System.IO.FileInfo(buildPath).Length / 1024f / 1024f).ToString("F2") + " MB");
        }
        else
        {
            Debug.LogError("BUILD FAILED: " + result.summary.totalErrors + " errors");
            foreach (var step in result.steps)
                foreach (var msg in step.messages)
                    if (msg.type == LogType.Error)
                        Debug.LogError("  " + msg.content);
        }
    }
}
#endif