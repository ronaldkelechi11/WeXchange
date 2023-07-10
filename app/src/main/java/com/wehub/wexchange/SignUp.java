package com.wehub.wexchange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.regex.Matcher;

public class SignUp extends AppCompatActivity {

    EditText nameEditText, telephoneEditText, passwordEditText, addressEditText, aboutEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //Initializing EditTexts
        nameEditText = findViewById(R.id.signupEdittextName);
        telephoneEditText = findViewById(R.id.signupEdittextTelephone);
        passwordEditText = findViewById(R.id.signupEdittextPassword);
        addressEditText = findViewById(R.id.signupEdittextAddress);
        aboutEditText = findViewById(R.id.signupEdittextAbout);

        telephoneEditText.addTextChangedListener(new PhoneNumberFormattingTextWatcher("NG"));
        passwordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
               if(s.length() == 1){
                   Toast.makeText(SignUp.this, R.string.password_remembrance_text, Toast.LENGTH_SHORT).show();
               }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void signup(View view) {
        //Creating String from the edittext
        String name = nameEditText.getText().toString().trim();
        String telephone = telephoneEditText.getText().toString();
        String password = passwordEditText.getText().toString().trim();
        String address = addressEditText.getText().toString();
        String about = aboutEditText.getText().toString();

        //FrontEnd Validation
        if(name.isEmpty()){
            nameEditText.setError("Cannot be blank");
            nameEditText.requestFocus();
            return;
        }
        if(telephone.isEmpty()){
            telephoneEditText.setError("Cannot be blank");
            telephoneEditText.requestFocus();
            return;
        }
        if(password.isEmpty()){
            passwordEditText.setError("Cannot be blank");
            passwordEditText.requestFocus();
            return;
        }
        if(password.length() < 8 ){
            passwordEditText.setError("Should be greater than 8 characters");
            passwordEditText.requestFocus();
            return;
        }
        if(address.isEmpty()){
            addressEditText.setError("Cannot be blank");
            addressEditText.requestFocus();
            return;
        }
        if(about.isEmpty()){
            aboutEditText.setError("Cannot be blank");
            aboutEditText.requestFocus();
            return;
        }


        HashMap<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("telephone", telephone);
        map.put("password", password);
        map.put("address", address);
        map.put("about", about);

        successfulSignup(); // :) Modularizing your App
    }

    private void successfulSignup() {
        Intent ti = new Intent(getApplicationContext(), Home.class);
        startActivity(ti);
        finish();
    }
}