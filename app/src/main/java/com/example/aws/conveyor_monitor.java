package com.example.aws;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class conveyor_monitor extends AppCompatActivity {

    Button buttonA,buttonB;
    Boolean flag=true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conveyor_monitor);
        buttonA = (Button) findViewById(R.id.buttonA);
        buttonB = (Button) findViewById(R.id.buttonB);

        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonA.setVisibility(View.GONE);
                buttonB.setVisibility(View.VISIBLE);

            }
        });
        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonB.setVisibility(View.GONE);
                buttonA.setVisibility(View.VISIBLE);

            }
        });
    }

}
