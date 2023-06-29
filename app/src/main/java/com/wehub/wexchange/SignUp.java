package com.wehub.wexchange;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {

    EditText nameEditText, telephoneEditText, passwordEditText, addressEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

    }

    public void signup(View view) {
        nameEditText = findViewById(R.id.signupEdittextName);
        telephoneEditText = findViewById(R.id.signupEdittextTelephone);
        passwordEditText = findViewById(R.id.signupEdittextPassword);
        addressEditText = findViewById(R.id.signupEdittextAddress);


    }
}