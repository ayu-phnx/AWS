package com.example.aws;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class PanelScreen extends AppCompatActivity {

    // Alert Dialog Manager
    AlertDialogManager alert = new AlertDialogManager();

    // Session Manager Class
    SessionManagement session;

    // Button Logout
    Button btnLogout;
    ImageButton wet,metal,plastic,conveyor;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel_screen);

        // Session class instance
        session = new SessionManagement(getApplicationContext());

       // TextView lblName = (TextView) findViewById(R.id.lblName);
       // TextView lblEmail = (TextView) findViewById(R.id.lblEmail);

        // Button logout
        btnLogout = (Button) findViewById(R.id.btnLogout);
        wet=(ImageButton) findViewById(R.id.wet_monitor);
        metal=(ImageButton) findViewById(R.id.metal_monitor);
        plastic=(ImageButton) findViewById(R.id.plastic_monitor);
        conveyor=(ImageButton) findViewById(R.id.conveyor_monitor);

        Toast.makeText(getApplicationContext(), "User Login Status: " + session.isLoggedIn(), Toast.LENGTH_LONG).show();


        /**
         * Call this function whenever you want to check user login
         * This will redirect user to LoginActivity is he is not
         * logged in
         * */
        session.checkLogin();

        // get user data from session
        HashMap<String, String> user = session.getUserDetails();

        // name
        String name = user.get(SessionManagement.KEY_NAME);

        // email
        String email = user.get(SessionManagement.KEY_EMAIL);

        // displaying user data
       // lblName.setText(Html.fromHtml("Name: <b>" + name + "</b>"));
       // lblEmail.setText(Html.fromHtml("Email: <b>" + email + "</b>"));

        wet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PanelScreen.this, wet_monitor.class);
                startActivity(intent);


            }
        });
        metal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PanelScreen.this, metal_monitor.class);
                startActivity(intent);


            }
        });

        plastic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PanelScreen.this, plastic_monitor.class);
                startActivity(intent);


            }
        });

        conveyor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PanelScreen.this, conveyor_monitor.class);
                startActivity(intent);

            }
        });
        /**
         * Logout button click event
         * */
        btnLogout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Clear the session data
                // This will clear all session data and
                // redirect user to LoginActivity
                session.logoutUser();
            }
        });
    }

}