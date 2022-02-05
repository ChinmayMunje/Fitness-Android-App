package com.gtappdevelopers.fitnessapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExerciseActivity extends AppCompatActivity implements ExerciseRVAdapter.ExerciseClickInterface {

    private RecyclerView exerciseRV;
    private ArrayList<ExerciseRVModal> exerciseRVModalArrayList;
    private ExerciseRVAdapter exerciseRVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        exerciseRV = findViewById(R.id.idRVExercise);
        exerciseRVModalArrayList = new ArrayList<>();
        exerciseRVAdapter = new ExerciseRVAdapter(exerciseRVModalArrayList, this, this::onExerciseClick);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        exerciseRV.setLayoutManager(linearLayoutManager);
        exerciseRV.setAdapter(exerciseRVAdapter);
        addData();

    }

    private void addData() {
        exerciseRVModalArrayList.add(new ExerciseRVModal("Side Plank", getResources().getString(R.string.plank_benifits), "https://assets1.lottiefiles.com/packages/lf20_EOXjkv.json", 20, 10));
        exerciseRVModalArrayList.add(new ExerciseRVModal("Lunges", getResources().getString(R.string.lunges_benifits), "https://assets1.lottiefiles.com/packages/lf20_XbVCR4.json", 30, 10));
        exerciseRVModalArrayList.add(new ExerciseRVModal("High Stepping", getResources().getString(R.string.stepping_benifits), "https://assets1.lottiefiles.com/packages/lf20_igizh2.json", 40, 10));
        exerciseRVModalArrayList.add(new ExerciseRVModal("Abs Crunches", getResources().getString(R.string.crunches_benifits), "https://assets1.lottiefiles.com/packages/lf20_Ajcy3F.json", 30, 20));
        exerciseRVModalArrayList.add(new ExerciseRVModal("Push Ups", getResources().getString(R.string.pushups_benifits), "https://assets1.lottiefiles.com/packages/lf20_cswADz.json", 10, 5));
        exerciseRVAdapter.notifyDataSetChanged();
    }

    @Override
    public void onExerciseClick(int position, ArrayList<ExerciseRVModal> exerciseRVModals) {
        Intent i = new Intent(ExerciseActivity.this, ExerciseDetailActivity.class);
        i.putExtra("exerciseName", exerciseRVModalArrayList.get(position).getExerciseName());
        i.putExtra("exerciseCalories", exerciseRVModalArrayList.get(position).getCalories());
        i.putExtra("exerciseTime", exerciseRVModalArrayList.get(position).getTime());
        i.putExtra("exerciseImg", exerciseRVModalArrayList.get(position).getImageUrl());
        i.putExtra("exerciseDesc", exerciseRVModalArrayList.get(position).getExerciseDescription());
        startActivity(i);
    }
}