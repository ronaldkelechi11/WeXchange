package com.wehub.wexchange;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.wehub.wexchange.managers.SharedPrefsInterface;

public class Welcome extends AppCompatActivity {
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


    }

    public void checkForFirstLaunch(View view) {
        sharedPreferences = getSharedPreferences(SharedPrefsInterface.SHARED_PREFS(), MODE_PRIVATE);
        String userNameTest = sharedPreferences.getString(SharedPrefsInterface.SHARED_PREFERENCE_USER_NAME(), "default");
        Log.d(TAG, "checkForFirstLaunch: "+ userNameTest);
        if(!userNameTest.isEmpty()){
            goToHomeScreen();
        }
        else{
            goToSignUp();
        }
    }

    public void goToSignUp() {
      Intent signup = new Intent(getApplicationContext(), SignUp.class);
      startActivity(signup);
    }
    public void goToHomeScreen() {
        Intent home = new Intent(getApplicationContext(), Home.class);
        startActivity(home);
    }

}