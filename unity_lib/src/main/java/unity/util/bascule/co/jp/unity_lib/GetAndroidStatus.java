package unity.util.bascule.co.jp.unity_lib;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.BatteryManager;
import android.app.Activity;
import android.content.IntentFilter;
import com.unity3d.player.UnityPlayer;

import android.hardware.SensorManager;
import android.util.Log;

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

    public static int SetMaxVolume() {
        final Activity activity = UnityPlayer.currentActivity;
        final Context context = activity.getApplicationContext();

        AudioManager am = (AudioManager)activity.getSystemService(Context.AUDIO_SERVICE);

        int ringMaxVolume = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

        am.setStreamVolume(AudioManager.STREAM_MUSIC, ringMaxVolume, 0);

//        int ringVolume = am.getStreamVolume(AudioManager.STREAM_MUSIC);
//        Log.d("SetMaxVolume", "volume:" + ringVolume + ", max: " + ringMaxVolume);
        return ringMaxVolume;
    }

}
