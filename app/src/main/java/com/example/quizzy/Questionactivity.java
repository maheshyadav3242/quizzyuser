package com.example.quizzy;

import android.animation.Animator;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Questionactivity extends AppCompatActivity {
    private TextView questiontext, numtext;
    private LinearLayout buttonlayout;
    private Button sharebtn, nextbtn;
    private FloatingActionButton floatingActionButton;
    private int count = 0;
    private List<Questionmodel> arraylist;
    private int position = 0;
    private int score=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionactivity);
        Toolbar toolbar = findViewById(R.id.tool3);
        setSupportActionBar(toolbar);
        questiontext = findViewById(R.id.question);
        numtext = findViewById(R.id.numberindicatiors);
        buttonlayout = findViewById(R.id.buttonlinear);
        sharebtn = findViewById(R.id.sharebtn);
        nextbtn = findViewById(R.id.nextbtn1);
        floatingActionButton = findViewById(R.id.floatingActionButton);
        arraylist = new ArrayList<>();
        arraylist.add(new Questionmodel("Question1", "a", "b", "c", "d", "a"));
        arraylist.add(new Questionmodel("Question2", "a", "b", "c", "d", "b"));
        arraylist.add(new Questionmodel("Question3", "a", "b", "c", "d", "c"));
        arraylist.add(new Questionmodel("Question4", "a", "b", "c", "d", "c"));
        arraylist.add(new Questionmodel("Question5", "a", "b", "c", "d", "a"));
        arraylist.add(new Questionmodel("Question6", "a", "b", "c", "d", "d"));


        for (int i = 0; i < 4; i++) {
            buttonlayout.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkedanswer((Button) v);
                }
            });

        }

        playanim(questiontext,0,arraylist.get(position).getQuestion());
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextbtn.setEnabled(false);
                nextbtn.setAlpha(0.7f);
                enableoption(true);
                position++;
                if(position==arraylist.size()){
                    return;
                }
                count = 0;
                playanim(questiontext, 0, arraylist.get(position).getQuestion());
            }
        });


    }

    private void playanim(final View view, final int value, final String data) {
        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500)
                .setStartDelay(100).setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                if (value == 0&&count<4) {
                    String option = " ";
                    if (count == 0) {
                        option = arraylist.get(position).getOptiona();

                    } else if (count == 1) {
                        option = arraylist.get(position).getOptionb();

                    } else if (count == 2) {
                        option = arraylist.get(position).getOptionc();

                    } else if (count == 3) {
                        option = arraylist.get(position).getOptiond();

                    }
                    playanim(buttonlayout.getChildAt(count), 0, option);
                    count++;
                }

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (value == 0) {
                    try{
                        numtext.setText(position+1+"/"+arraylist.size());
                        ((TextView) view).setText(data);

                    }catch (ClassCastException ex){
                        ((Button) view).setText(data);
                    }
                   view.setTag(data);
                    playanim(view, 1, data);
                }

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });


    }

    private void checkedanswer(Button selectedoption) {
        enableoption(false);
        nextbtn.setEnabled(true);
        nextbtn.setAlpha(1);
        if(selectedoption.getText().toString().equals(arraylist.get(position).getCoorectans())){
            score++;
            selectedoption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#4CAF50")));
        }else {

            selectedoption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff0000")));
      Button correctanswer= (Button)buttonlayout.findViewWithTag(arraylist.get(position).getCoorectans());
            correctanswer.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff0000")));
        }


    }

    private void enableoption(boolean enable) {

        for (int i = 0; i < 4; i++) {
            buttonlayout.getChildAt(i).setEnabled(enable);
            if(enable){
                buttonlayout.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#989898")));

            }
        }

    }
}


