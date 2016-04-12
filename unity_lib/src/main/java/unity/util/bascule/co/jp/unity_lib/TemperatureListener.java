package unity.util.bascule.co.jp.unity_lib;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.util.Log;

public class TemperatureListener implements SensorEventListener {
    private SensorManager manager;
    private static Sensor temperatureSensor;

    public float value;

    public TemperatureListener(SensorManager manager) {
        this.manager = manager;
        value = 0f;
        temperatureSensor = manager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        manager.registerListener(this, temperatureSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void onSensorChanged(SensorEvent event) {
        Log.v("Activity","Android Temperature :" + String.valueOf(event.values[0]) );
        value = event.values[0];
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // 自動生成されたメソッド・スタブ
        //Log.v("Activity","Sensor.TYPE_LIGHT accuracy:" + String.valueOf(accuracy) );

    }



}
