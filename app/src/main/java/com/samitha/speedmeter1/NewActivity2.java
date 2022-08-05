package com.samitha.speedmeter1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewActivity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new2);

        //ActionBar title
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("First Activity");

        //EditText
        final EditText txt_Display = findViewById(R.id.txt_Display);
        //Button
        Button Enterbtn = findViewById(R.id.Enterbtn);

        Enterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String process = txt_Display.getText().toString();

                Intent intent = new Intent(NewActivity2.this, MainActivity.class);
                intent.putExtra("PROCESS",process);
                startActivity(intent);
            }
        });
    }
}