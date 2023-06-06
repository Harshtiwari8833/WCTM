package com.example.wctm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
 private BottomNavigationView bottomNavigationView;
 private NavController navController;
 private DrawerLayout drawerLayout;
 private ActionBarDrawerToggle toggel;
 private NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        navController = Navigation.findNavController(this,R.id.frame_layout);
        drawerLayout =findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigation_view);


        toggel = new ActionBarDrawerToggle(this, drawerLayout,R.string.start,R.string.close );

        drawerLayout.addDrawerListener(toggel);
        toggel.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(this);



        NavigationUI.setupWithNavController(bottomNavigationView,navController);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggel.onOptionsItemSelected(item)){
            return true;
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.navigation_developer:
                Toast.makeText(this, "developer", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_ebook:
                startActivity(new Intent(this, EbookActivity.class));

                break;
            case R.id.navigation_youtube:

                gotoUrl("https://www.youtube.com/@worldcollegeoftechnologyma3160/featured");

                break;
            case R.id.navigation_website:
                   gotoUrl("https://www.wctmgurgaon.com/");
                break;
            case R.id.navigation_rate:
                Toast.makeText(this, "rate us", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_checkresult:
                 gotoUrl("http://result.mdurtk.in/postexam/result.aspx");
                break;

        }
        return true;
    }

    private void gotoUrl(String s) {
      Uri uri = Uri.parse(s);
      startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}