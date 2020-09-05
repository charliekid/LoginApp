/**
 * Filename:    LandingPage.java
 * Author:      Charlie Nguyen
 * Hw:          WK02HW01 : Android Login and Landing Page
 */
package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class LandingPage extends AppCompatActivity {

    TextView landingPageTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        landingPageTextView = findViewById(R.id.landingPageTextView);
        String username = getIntent().getStringExtra("USERNAME");
        landingPageTextView.setText("Welcome " + username);
    }

    /**
     * This methods is used when switching from one page to this page.
     * The username will be stored in the Intent's putExtra()
     * @param context - context of the page we are on
     * @param username - String that contains the username
     * @return Intent for this page
     */
    public static Intent getIntent(Context context, String username) {
        Intent intent = new Intent(context, LandingPage.class);
        intent.putExtra("USERNAME", username);
        return intent;
    }
}