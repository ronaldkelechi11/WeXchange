package com.wehub.wexchange;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;

public class SignUp extends AppCompatActivity {

    EditText nameEditText, telephoneEditText, passwordEditText, addressEditText, aboutEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        telephoneEditText.addTextChangedListener(new PhoneNumberFormattingTextWatcher("NG"));

    }

    public void signup(View view) {
        //Initializing EditTexts
        nameEditText = findViewById(R.id.signupEdittextName);
        telephoneEditText = findViewById(R.id.signupEdittextTelephone);
        passwordEditText = findViewById(R.id.signupEdittextPassword);
        addressEditText = findViewById(R.id.signupEdittextAddress);
        aboutEditText = findViewById(R.id.signupEdittextAbout);

        //Creating String from the edittext
        String name = nameEditText.getText().toString().trim();
        String telephone = telephoneEditText.getText().toString();
        String password = passwordEditText.getText().toString().trim();
        String address = addressEditText.getText().toString();
        String about = aboutEditText.getText().toString();

        HashMap<String, String> map = new HashMap<>();
    }
}