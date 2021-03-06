package com.example.beaverlog.ui.account;

import android.content.Context;
import android.util.Patterns;
import android.widget.EditText;
import android.widget.Toast;

public class ValidateInput {

    private Context context;
    private EditText email, password, repeatPassword, username;

    String emailInput, passwordInput, repeatPasswordInput, usernameInput;

    ValidateInput(Context myContext, EditText myEmail, EditText myPassword) {
        context = myContext;
        email = myEmail;
        password = myPassword;
    }

    public ValidateInput(Context myContext, EditText myEmail, EditText myPassword, EditText myRepeatPassword, EditText myUsername) {
        context = myContext;
        email = myEmail;
        password = myPassword;
        repeatPassword = myRepeatPassword;
        username = myUsername;
    }

    public boolean validateEmail() {
        emailInput = email.getText().toString().trim();

        if(emailInput.isEmpty()) {
            Toast.makeText(context, "Please enter your Email Address.", Toast.LENGTH_SHORT).show();
            return false;
        }else if(!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            Toast.makeText(context, "Invalid Email Address.", Toast.LENGTH_SHORT).show();
            return false;
        }else {
            return true;
        }
    }

    public boolean validatePassword() {
        passwordInput = password.getText().toString().trim();

        if(passwordInput.isEmpty()) {
            Toast.makeText(context, "Please enter your Password.", Toast.LENGTH_SHORT).show();
            return false;
        }else if(passwordInput.length() < 8) {
            Toast.makeText(context, "Password too short.", Toast.LENGTH_SHORT).show();
            return false;
        }else {
            return true;
        }
    }

    public boolean validateRepeatPassword() {
        repeatPasswordInput = repeatPassword.getText().toString().trim();

        if(repeatPasswordInput.isEmpty()) {
            Toast.makeText(context, "Please fill all fields.", Toast.LENGTH_SHORT).show();
            return false;
        }else if(!repeatPasswordInput.equals(passwordInput)) {
            Toast.makeText(context, "Passwords don't match.", Toast.LENGTH_SHORT).show();
            return false;
        }else {
            return true;
        }

    }

    public boolean validateUsername() {
        usernameInput = username.getText().toString().trim();

        if(usernameInput.isEmpty()) {
            Toast.makeText(context, "Please fill all fields.", Toast.LENGTH_SHORT).show();
            return false;
        }else {
            return true;
        }

    }
}
