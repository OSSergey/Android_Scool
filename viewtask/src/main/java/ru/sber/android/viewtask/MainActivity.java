package ru.sber.android.viewtask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextInputLayout textInputLayout1 = findViewById(R.id.text_input_layout_1);
        TextInputLayout textInputLayout2 = findViewById(R.id.text_input_layout_2);

        Button translitBtn = findViewById(R.id.translit_to_cyrillic_btn);
        Button cyrillicBtn = findViewById(R.id.cyrillic_to_translit_btn);

        translitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        cyrillicBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}