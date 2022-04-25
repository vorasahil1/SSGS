package com.example.ssgs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import static com.example.ssgs.R.string.*;

public class Schemes extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView naviview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schemes);
        naviview = (NavigationView) findViewById(R.id.navigation_view); setUpToolbar();
        naviview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        Toast.makeText(Schemes.this, "Clicked Home", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.notification:
                        Toast.makeText(Schemes.this, "Clicked Notificaton", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.helpfb:
                        Toast.makeText(Schemes.this, "Clicked Help Fb", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.about:
                        Toast.makeText(Schemes.this, "Clicked About", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.setting:
                        Toast.makeText(Schemes.this, "Clicked Setting", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.logout:
                        Toast.makeText(Schemes.this, "Clicked Log Out", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });

    }

    private void setUpToolbar() {
        drawerLayout = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!= null)
        Toast.makeText(this, getSupportActionBar().getTitle(),Toast.LENGTH_SHORT).show();
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, app_name, app_name/*drawerLayout, this, toolbar, R.string.app_name, R.string.app_name*/);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        /*     ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, toolbar, drawerLayout, toolbar, app_name, app_name);
            drawerLayout.addDrawerListener(toggle);
        toggle.syncState();*/
        //  navigationView.setNavigationItemSelectedListener(this);

    }

    public void setSupportActionBar(Toolbar toolbar) {
    }
}
