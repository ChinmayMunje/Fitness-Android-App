package com.gtappdevelopers.fitnessapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class StepsCounterActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private boolean running = false;
    private TextView stepsTV;
    private FloatingActionButton fab;
    float steps = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps_counter);
        stepsTV = findViewById(R.id.idTVSTeps);
        stepsTV.setText(String.valueOf(steps));
        fab = findViewById(R.id.idFAB);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (running) {
                    running = false;
                    fab.setImageResource(R.drawable.ic_play);
                    Toast.makeText(StepsCounterActivity.this, "Counter Paused..", Toast.LENGTH_SHORT).show();
                } else {
                    running = true;
                    fab.setImageResource(R.drawable.ic_pause);
                    Toast.makeText(StepsCounterActivity.this, "Counter Started..", Toast.LENGTH_SHORT).show();
                    startCounting();
                }

            }
        });
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (running) {
            steps = steps + sensorEvent.values[0];
            stepsTV.setText(String.valueOf(steps));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    private void startCounting() {
        running = true;
        Sensor stepSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if (stepSensor != null) {
            sensorManager.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_UI);
        } else {
            Toast.makeText(this, "Sensor Not Found..", Toast.LENGTH_SHORT).show();
        }
    }
}