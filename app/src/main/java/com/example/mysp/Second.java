package com.example.mysp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class Second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d("second", "onCreate: ");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("second", "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("second", "onResume: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("second", "onStop: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("second", "onPause: ");
    }
}