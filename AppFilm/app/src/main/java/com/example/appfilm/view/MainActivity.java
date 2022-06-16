package com.example.appfilm.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.appfilm.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity{
    BottomNavigationView bottomNavigationView;
    DrawerLayout drawerLayout;
    private static final int FRAGMENT_HOME = 0;
    private static final int FRAGMENT_BYTICKET = 1;
    private static final int FRAGMENT_ACCOUNT = 2;
    private static final int FRAGMENT_MYTICKER = 3;
    private int currentFragment = FRAGMENT_HOME;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
// nút 3 gạch để mở navigation view
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,
//                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
//        drawerLayout.addDrawerListener(toggle);
//        toggle.syncState();

        replaceFragment(new HomeFragment());
        currentFragment = FRAGMENT_HOME;
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
                        if (currentFragment != FRAGMENT_HOME) {
                            replaceFragment(new HomeFragment());
                            currentFragment = FRAGMENT_HOME;
                        }
                        return true;
                    case R.id.action_byticket:
                        if (currentFragment != FRAGMENT_BYTICKET) {
                            replaceFragment(new HomeFragment());
                            currentFragment = FRAGMENT_BYTICKET;
                        }
                        return true;
                    case R.id.action_account:
                        if (currentFragment != FRAGMENT_ACCOUNT) {
                            replaceFragment(new UserFragment());
                            currentFragment = FRAGMENT_ACCOUNT;
                        }
                        return true;
                    case R.id.action_ticket:
                        if (currentFragment != FRAGMENT_MYTICKER) {
                            replaceFragment(new HomeFragment());
                            currentFragment = FRAGMENT_MYTICKER;
                        }
                        return true;
                }
                return true;
            }
        });
        //fragmentReturn();
    }



    private void mapping() {
        drawerLayout = findViewById(R.id.drawerLayout);
        bottomNavigationView = findViewById(R.id.bottom_nav);
    }

    public  void replaceFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame,fragment);
        transaction.commit();
    }

    private void fragmentReturn(){
        Intent intent = getIntent();
        int fragmentReturn = intent.getIntExtra("fragmentReturn",0);
        if (fragmentReturn == FRAGMENT_HOME){
            replaceFragment(new HomeFragment());
            currentFragment = FRAGMENT_HOME;
        }else if (fragmentReturn == FRAGMENT_ACCOUNT){
            replaceFragment(new ProfileUser());
            currentFragment = FRAGMENT_ACCOUNT;
        }else if (fragmentReturn == FRAGMENT_BYTICKET){
            replaceFragment(new HomeFragment());
            currentFragment = FRAGMENT_BYTICKET;
        }else{
            replaceFragment(new HomeFragment());
            currentFragment = FRAGMENT_MYTICKER;
        }
    }

}