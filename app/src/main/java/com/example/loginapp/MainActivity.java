/**
 * Filename:    MainActivity.java
 * Author:      Charlie Nguyen
 * Hw:          WK02HW01 : Android Login and Landing Page
 */
package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText usernameEditText;
    EditText passwordEditText;
    Button loginButton;

    User aUser = new User("din", "djarin",
                 "din_djarin", "baby_yoda_ftw");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateLogin(usernameEditText, passwordEditText);
            }
        });
    }

    /**
     * This method validates data input by a user. This will check if the fields are empty
     * and will check to make sure both password and username are valid
     * @param usernameEditText - EditText where users will enter their username
     * @param passwordEditText - EditText where users will enter their password
     */
    public void validateLogin(EditText usernameEditText, EditText passwordEditText) {
        // Checks to see if fields are empty
        if(usernameEditText.getText().toString().isEmpty() &&
                passwordEditText.getText().toString().isEmpty()) {
            usernameEditText.setError("Username cannot be empty");
            passwordEditText.setError("Password cannot be empty");
        } else if (usernameEditText.getText().toString().isEmpty()) {
            usernameEditText.setError("Password cannot be empty");
        }
        else if (passwordEditText.getText().toString().isEmpty()) {
            passwordEditText.setError("Password cannot be empty");
        // If fields are not empty
        } else {
            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            // checks if the username exists in database
            if(username.equals(aUser.getUsername())) {
                // check if the password is correct
                if(password.equals(aUser.getPassword())) {
                    // password matches we need to send the user to landing page
                    Intent intent = LandingPage.getIntent(getApplicationContext(), username);
                    startActivity(intent);
                } else {
                    // password does not match
                    passwordEditText.setError("Password incorrect");
                }
            } else {
                //Username does not exists
                usernameEditText.setError("Username does not exists");
            }
        }
    }
}