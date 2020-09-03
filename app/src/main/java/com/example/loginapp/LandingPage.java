package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class LandingPage extends AppCompatActivity {

    TextView landingPageTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        landingPageTextView = findViewById(R.id.landingPageTextView);
        String username = getIntent().getStringExtra("username");
        landingPageTextView.setText("Welcome " + username);

    }
}