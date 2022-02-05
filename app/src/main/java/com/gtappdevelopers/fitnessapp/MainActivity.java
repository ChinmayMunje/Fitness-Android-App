package com.gtappdevelopers.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout exerciseLL, stepsLL;
    private LottieAnimationView stepsLAV, exerciseLAV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stepsLAV = findViewById(R.id.idLAVStepsCounter);
        exerciseLAV = findViewById(R.id.idLAVExercise);
        exerciseLL = findViewById(R.id.idLLExercise);
        stepsLL = findViewById(R.id.idLLSteps);
        exerciseLAV.setAnimationFromUrl("https://assets2.lottiefiles.com/packages/lf20_vxnelydc.json");
        stepsLAV.setAnimationFromUrl("https://assets5.lottiefiles.com/packages/lf20_mzbdc0qk.json");

        stepsLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, StepsCounterActivity.class);
                startActivity(i);
            }
        });
        exerciseLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ExerciseActivity.class);
                startActivity(i);
            }
        });

    }
}