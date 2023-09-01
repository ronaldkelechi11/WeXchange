package com.wehub.wexchange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.wehub.wexchange.apiHelpers.HttpInterface;
import com.wehub.wexchange.managers.SharedPrefsInterface;

import java.util.HashMap;
import java.util.regex.Matcher;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUp extends AppCompatActivity {

    EditText nameEditText, telephoneEditText, passwordEditText, addressEditText, aboutEditText;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

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
                   Toast.makeText(SignUp.this, R.string.password_remembrance_text, Toast.LENGTH_LONG).show();
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


        // set default user signup
        if(name.equals("Default User")){
            saveUserInfo(telephone, name,1);
            successfulSignup();
        }
        else{
            HashMap<String, String> map = new HashMap<>();
            map.put("name", name);
            map.put("telephone", telephone);
            map.put("password", password);
            map.put("address", address);
            map.put("about", about);
            Call<Integer> call = HttpInterface.getInstance().getApi().executeSignup(map);
            call.enqueue(new Callback<Integer>() {
                @Override
                public void onResponse(Call<Integer> call, Response<Integer> response) {
                    if(response.code() == 200){
                        saveUserInfo(telephone, name, 1);
                        successfulSignup();
                    }
                    else if(response.code() == 400){
                        Toast.makeText(SignUp.this, "User credentials already exist", Toast.LENGTH_SHORT).show();
                    }
                }
                @Override
                public void onFailure(Call<Integer> call, Throwable t) {
                    Toast.makeText(SignUp.this, "Server connection Error", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    private void saveUserInfo(String userTelephone, String userName, int userId) {
        sharedPreferences = getSharedPreferences(SharedPrefsInterface.SHARED_PREFS(), MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString(SharedPrefsInterface.SHARED_PREFERENCE_USER_TELEPHONE(), userTelephone);
        editor.putString(SharedPrefsInterface.SHARED_PREFERENCE_USER_NAME(), userName);
        editor.putString(SharedPrefsInterface.SHARED_PREFERENCE_USER_ID(), String.valueOf(userId));
        editor.apply();
    }

    private void successfulSignup() {
        Intent ti = new Intent(getApplicationContext(), Home.class);
        startActivity(ti);
        finish();
    }
}