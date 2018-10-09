package com.example.joshi.flashcardapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean isShowingAnswers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView fc_q = findViewById(R.id.flashcard_question);
        final TextView fc_a = findViewById(R.id.flashcard_answer);
        final ImageView icon = findViewById(R.id.toggle_choices_visibility);
        final TextView[] choice = {findViewById(R.id.choice1), findViewById(R.id.choice2), findViewById(R.id.choice3)};
        final TextView answer = choice[2];
        final RelativeLayout background = findViewById(R.id.background);
        final int red = getResources().getColor(R.color.pastel_red);
        final int blue = getResources().getColor(R.color.pastel_blue);
        final int green = getResources().getColor(R.color.pastel_green);
        final int layoutHeight = fc_a.getHeight();
        fc_q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fc_a.setVisibility(View.VISIBLE);
                fc_q.setVisibility(View.GONE);
            }
        });

        fc_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fc_a.setVisibility(View.GONE);
                fc_q.setVisibility(View.VISIBLE);
            }
        });

        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isShowingAnswers) {
                    icon.setImageResource(R.drawable.hide_icon);
                    for (TextView i : choice)
                        i.setVisibility(View.VISIBLE);
                    isShowingAnswers = !isShowingAnswers;
                } else {
                    icon.setImageResource(R.drawable.show_icon);
                    for (TextView i : choice)
                        i.setVisibility(View.GONE);
                    isShowingAnswers = !isShowingAnswers;
                }
            }
        });

        //choice: Bill Clinton
        choice[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice[0].setBackgroundColor(red);
                answer.setBackgroundColor(green);
            }
        });

        //choice: George H. W. Bush
        choice[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice[1].setBackgroundColor(red);
                answer.setBackgroundColor(green);
            }
        });

        //choice: Barack Obama
        choice[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.setBackgroundColor(green);
            }
        });

        background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (TextView i : choice)
                    i.setBackgroundColor(blue);
            }
        });
    }
}
