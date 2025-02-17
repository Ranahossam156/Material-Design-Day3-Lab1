package com.example.floatingactionbutton;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton mAddAlarmFab, mAddPersonFab;
    ExtendedFloatingActionButton mAddFab;
    private Animation fabOpen, fabClose;
    private boolean isFabOpen = false;
    TextView addAlarmActionText, addPersonActionText;
    Boolean isAllFabsVisible;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAddFab = findViewById(R.id.add_fab);
        fabOpen= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation);
        fabClose = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.closing);
        mAddFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isFabOpen) {
                    mAddFab.startAnimation(fabClose);
                    isFabOpen = false;
                } else {
                    mAddFab.startAnimation(fabOpen);
                    isFabOpen = true;
                }
            }
        });
        mAddAlarmFab = findViewById(R.id.add_alarm_fab);
        mAddPersonFab = findViewById(R.id.add_person_fab);
        addAlarmActionText =
                findViewById(R.id.add_alarm_action_text);
        addPersonActionText =
                findViewById(R.id.add_person_action_text);
        mAddAlarmFab.setVisibility(View.GONE);
        mAddPersonFab.setVisibility(View.GONE);
        addAlarmActionText.setVisibility(View.GONE);
        addPersonActionText.setVisibility(View.GONE);
        isAllFabsVisible = false;

        mAddFab.shrink();

        mAddFab.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!isAllFabsVisible) {
                            mAddFab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#B22222")));
//                            mAddFab.
                            //mAddFab.set
                            mAddAlarmFab.show();
                            mAddPersonFab.show();
                            addAlarmActionText
                                    .setVisibility(View.VISIBLE);
                            addPersonActionText
                                    .setVisibility(View.VISIBLE);
                            isAllFabsVisible = true;
                        } else {
                            mAddAlarmFab.hide();
                            mAddPersonFab.hide();
                            addAlarmActionText
                                    .setVisibility(View.GONE);
                            addPersonActionText.setVisibility(View.GONE);
                            isAllFabsVisible = false;
                        }
                    }
                });
        mAddPersonFab.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText
                                (MainActivity
                                                .this, "Person Added",
                                        Toast.LENGTH_SHORT).show();
                    }
                });
        mAddAlarmFab.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText

                                (MainActivity
                                                .this, "Alarm Added",
                                        Toast.LENGTH_SHORT).show();
                    }
                });
    }
}