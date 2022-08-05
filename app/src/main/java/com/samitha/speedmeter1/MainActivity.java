package com.samitha.speedmeter1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SpeedometerView Speed;
    public Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ActionBar title
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("First Activity");

        //intent to get data
        Intent intent = getIntent();
        String name = intent.getStringExtra("PROCESS");

        TextView mProsess = findViewById(R.id.txt_process);
        mProsess.setText("Value: "+name);

        button = (Button) findViewById(R.id.Backbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this,NewActivity2.class);
                startActivity(intent1);
            }
        });


        Speed = (SpeedometerView)findViewById(R.id.speedometer);
        Speed.setLabelConverter(new SpeedometerView.LabelConverter() {
            @Override
            public String getLabelFor(double progress, double maxProgress) {
                return String.valueOf((int) Math.round(progress));
            }
        });

// configure value range and ticks
        Speed.setMaxSpeed(200);
        Speed.setMajorTickStep(25);
        Speed.setMinorTicks(0);

// Configure value range colors
        Speed.addColoredRange(0, 60, Color.BLUE);
        Speed.addColoredRange(60, 80, Color.GREEN);
        Speed.addColoredRange(80, 100, Color.YELLOW);
        Speed.addColoredRange(100, 140, Color.RED);


        Speed.setSpeed(100, 2000, 500);
    }
}