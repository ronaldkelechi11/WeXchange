package com.wehub.wexchange;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Messages extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);

        initializeBottomNavigationView();
    }

    private void initializeBottomNavigationView() {
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.navbarMessages);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.navbarHome){
                    Intent home = new Intent(getApplicationContext(), Home.class);
                    startActivity(home);
                    overridePendingTransition(0, 0);
                    return true;
                }
                if(item.getItemId() == R.id.navbarMessages) {
                    return true;
                }
                if(item.getItemId() == R.id.navbarStarred) {
                    Intent star = new Intent(getApplicationContext(), Starred.class);
                    startActivity(star);
                    overridePendingTransition(0, 0);
                    return true;
                }
                if(item.getItemId() == R.id.navbarDashboard ){
                    Intent dashboard = new Intent(getApplicationContext(), Dashboard.class);
                    startActivity(dashboard);
                    overridePendingTransition(0, 0);
                    return true;
                }
                return false;
            }
        });
    }
}