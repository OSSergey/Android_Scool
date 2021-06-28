package ru.sber.android.android_school.task_by_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import ru.sber.android.android_school.R;

public class ActivitySingleTop extends AppCompatActivity {
    private static int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buttons);

        TextView textView = findViewById(R.id.textView);
        textView.setText("ActivitySingleTop number: " + String.valueOf(++count));
        findViewById(R.id.button_standard).setOnClickListener(v -> startStandard());
        findViewById(R.id.button_single_task).setOnClickListener(v -> startSingleTask());
        findViewById(R.id.button_single_top).setOnClickListener(v -> startSingleTop());
        findViewById(R.id.button_single_instance).setOnClickListener(v -> startSingleInstance());
    }

    private void startStandard() {
        startActivity(new Intent(this, ActivityStandard.class));
    }

    private void startSingleTask() {
        startActivity(new Intent(this, ActivitySingleTask.class));
    }

    private void startSingleTop() {
        startActivity(new Intent(this, ActivitySingleTop.class));
    }

    private void startSingleInstance() {
        startActivity(new Intent(this, ActivitySingleInstance.class));
    }
}