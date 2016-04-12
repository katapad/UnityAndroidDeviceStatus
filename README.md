# Getting Started

make it.

    $ ./gradlew assembleRelease
    # ./unity_lib/build/outputs/aar/unity_lib-release.aar ← use it.

and use it.

add unity folder

`/Assets/Plugins/Android/unity_lib-release.aar`


## Unity code


``` device.cs
void Start() {
    AndroidJavaObject androidJavaObject = new AndroidJavaObject( "unity.util.bascule.co.jp.unity_lib.GetAndroidStatus" );
    int batteryLevel = androidJavaObject.CallStatic<int> ("BatteryLevel");
    int temperature = androidJavaObject.CallStatic<int> ("BatteryTemperature");
    Debug.Log ("batteryLevel: " + batteryLevel);
    Debug.Log ("temperature: " + temperature);
}
```