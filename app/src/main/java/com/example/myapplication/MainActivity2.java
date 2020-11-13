package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import me.gujun.android.taggroup.TagGroup;

public class MainActivity2 extends AppCompatActivity {
    BottomNavigationView navView;
    boolean status=false;
    MenuItem menuItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        navView = findViewById(R.id.nav_view);

        EditText searchView = findViewById(R.id.search_vew);
      //  hideSoftKeyboard(searchView);

        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        loadFragment(new HomeFragment());
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navView.setSelectedItemId(R.id.navigation_home);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener
            mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_dashboard:
//                    getSupportActionBar().setTitle("Dashboard");
                    fragment = new DashboardFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_home:
//                    getSupportActionBar().setTitle("Home");
                    fragment = new HomeFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_notifications:
//                    getSupportActionBar().setTitle("Notification");
                    fragment = new NotificationsFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_account:
//                    getSupportActionBar().setTitle("Account");
                    fragment = new AccountFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };
    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction =
                getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.nav_host_fragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void hideSoftKeyboard(View view){
        InputMethodManager imm =(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}