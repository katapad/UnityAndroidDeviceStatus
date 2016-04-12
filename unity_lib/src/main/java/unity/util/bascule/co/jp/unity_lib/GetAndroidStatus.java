package unity.util.bascule.co.jp.unity_lib;

import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.app.Activity;
import android.content.IntentFilter;
import com.unity3d.player.UnityPlayer;

import android.hardware.SensorManager;

public class GetAndroidStatus {
    private static SensorManager manager;
    private static TemperatureListener listener;

    public static int BatteryLevel(){
        final Activity activity = UnityPlayer.currentActivity;
        final Context context = activity.getApplicationContext();

        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = context.registerReceiver(null, ifilter);

        int nowLevel = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        return nowLevel;
    }

    public static int BatteryTemperature(){
        final Activity activity = UnityPlayer.currentActivity;
        final Context context = activity.getApplicationContext();

        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = context.registerReceiver(null, ifilter);

        int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, -1);
        return level;
    }


//    public static float GetTemperature() {
//        final Activity activity = UnityPlayer.currentActivity;
//        final Context context = activity.getApplicationContext();
//
//        if (manager == null) {
//            initSensor(activity);
//        }
//        float temperature = getTemperature();
//        return temperature;
//    }
//
//    private static float getTemperature() {
//        if (listener == null)
//            return 0f;
//
//        return listener.value;
//    }
//
//    private static void initSensor(Activity activity) {
//        manager = (SensorManager)activity.getSystemService(Context.SENSOR_SERVICE);
//        listener = new TemperatureListener(manager);
//    }

}
