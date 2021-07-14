package ru.sber.android.viewtask;

import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextInputLayout textInputLayoutRu = findViewById(R.id.text_input_layout_ru);
        TextInputLayout textInputLayoutEn = findViewById(R.id.text_input_layout_en);
        Button translitBtn = findViewById(R.id.cyrillic_to_translit_btn);
        Button cyrillicBtn = findViewById(R.id.translit_to_cyrillic_btn);

        EditText editTextRu = findViewById(R.id.edit_text_ru);
        EditText editTextEn = findViewById(R.id.edit_text_en);

        editTextRu.setFilters(new InputFilter[]{
                (charSequence, i, i1, spanned, i2, i3) -> {
                    if (charSequence.equals("")) {
                        return charSequence;
                    }

                    if (charSequence.toString().matches("[а-яА-я]+")) {
                        return charSequence;
                    }

                    return "";
                }
        });

        editTextEn.setFilters(new InputFilter[]{
                (charSequence, i, i1, spanned, i2, i3) -> {
                    if (charSequence.equals("")) {
                        return charSequence;
                    }

                    if (charSequence.toString().matches("[a-zA-Zq]+")) {
                        return charSequence;
                    }

                    return "";
                }
        });


        translitBtn.setOnClickListener(v -> {
            String text = textInputLayoutRu.getEditText().getText().toString();
            textInputLayoutEn.getEditText().setText(Transliteration.toTranslit(text.toUpperCase()));
        });

        cyrillicBtn.setOnClickListener(v -> {
            String text = textInputLayoutEn.getEditText().getText().toString();
            textInputLayoutRu.getEditText().setText(Transliteration.toCyrillic(text.toUpperCase()));
        });
    }
}