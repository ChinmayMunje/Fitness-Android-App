package com.gtappdevelopers.fitnessapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;

public class ExerciseDetailActivity extends AppCompatActivity {

    int time, calories;
    private String exerciseName, exerciseDesc, exerciseImg;
    private TextView exerciseNameTV, exerciseCalTV, exerciseTimeTV, exerciseDescTV;
    private LottieAnimationView exerciseLAV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_detail);
        time = getIntent().getIntExtra("exerciseTime", 0);
        calories = getIntent().getIntExtra("exerciseCalories", 0);
        exerciseName = getIntent().getStringExtra("exerciseName");
        exerciseDesc = getIntent().getStringExtra("exerciseDesc");
        exerciseImg = getIntent().getStringExtra("exerciseImg");
        exerciseNameTV = findViewById(R.id.idTVExerciseName);
        exerciseTimeTV = findViewById(R.id.idTVExerciseTime);
        exerciseCalTV = findViewById(R.id.idTVExerciseCalories);
        exerciseLAV = findViewById(R.id.idExerciseLAV);
        exerciseDescTV = findViewById(R.id.idTVExerciseDescription);
        exerciseNameTV.setText(exerciseName);
        exerciseDescTV.setText(exerciseDesc);
        exerciseCalTV.setText("Calories : " + calories);
        exerciseTimeTV.setText("Time : " + time + "Min");
        exerciseLAV.setAnimationFromUrl(exerciseImg);

    }
}