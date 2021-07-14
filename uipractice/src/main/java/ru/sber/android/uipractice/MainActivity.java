package ru.sber.android.uipractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startLinearLayoutActivityBtn = findViewById(R.id.start_linear_layout_activity);
        startLinearLayoutActivityBtn.setOnClickListener(v -> startLinearLayoutActivity());
    }

    private void startLinearLayoutActivity() {
        Intent intent = new Intent(this, LinearLayoutActivity.class);
        startActivity(intent);
    }
}