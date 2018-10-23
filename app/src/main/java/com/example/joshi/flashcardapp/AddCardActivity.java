package com.example.joshi.flashcardapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_flashcard);
        ImageView back = findViewById(R.id.back);
        final ImageView saveIcon = findViewById(R.id.saveFlashcard);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
//                AddCardActivity.this.startActivity(new Intent(AddCardActivity.this, MainActivity.class));
            }
        });

//        configureBackButton();
//        onSavePressed();
        saveIcon.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN)
                    saveIcon.setImageResource(R.drawable.downsave_icon);
                else if (event.getAction() == MotionEvent.ACTION_UP)
                    saveIcon.setImageResource(R.drawable.save_icon);
                return false;
            }
        });

        saveIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                EditText answer_field = findViewById(R.id.addAnswer_field);
                EditText question_field = findViewById(R.id.addQuestion_field);
                data.putExtra("question", question_field.getText().toString());
                data.putExtra("answer", answer_field.getText().toString());
                setResult(RESULT_OK, data);
                finish();
            }
        });

    }

    private void configureBackButton() {
        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
//                startActivity(new Intent(AddCardActivity.this, MainActivity.class));
            }
        });
    }

    private void onSavePressed() {
        final ImageView saveIcon = findViewById(R.id.saveFlashcard);
        saveIcon.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN)
                    saveIcon.setImageResource(R.drawable.downsave_icon);
                else if (event.getAction() == MotionEvent.ACTION_UP)
                    saveIcon.setImageResource(R.drawable.save_icon);
                return false;
            }
        });
    }
}
