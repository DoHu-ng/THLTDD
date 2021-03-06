package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SearchView;


import com.google.android.material.bottomnavigation.BottomNavigationView;

import me.gujun.android.taggroup.TagGroup;

public class MainActivity2 extends AppCompatActivity {
    BottomNavigationView navView;
    boolean status=false;
    MenuItem menuItem;
    EditText searchView;
    LinearLayout linearLayout;
    Toolbar toolbar;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        navView = findViewById(R.id.nav_view);

        dbHelper = new DBHelper(getApplicationContext());
        dbHelper.createTable();

        linearLayout = findViewById(R.id.linear);
        toolbar =findViewById(R.id.toolbar);

        searchView = findViewById(R.id.search_vew);
        //  hideSoftKeyboard(searchView);

        loadFragment(new HomeFragment());
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navView.setSelectedItemId(R.id.navigation_home);
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, SearchActivity.class);
                startActivity(intent);
            }
        });
    }
    private BottomNavigationView.OnNavigationItemSelectedListener
            mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_dashboard:
//                  getSupportActionBar().setTitle("Dashboard");
                    linearLayout.setVisibility(View.VISIBLE);
                    toolbar.setVisibility(View.GONE);
                    fragment = new DashboardFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_home:
//                    getSupportActionBar().setTitle("Home");
                    linearLayout.setVisibility(View.VISIBLE);
                    toolbar.setVisibility(View.GONE);
                    fragment = new HomeFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_notifications:
//                    getSupportActionBar().setTitle("Notification");
                    linearLayout.setVisibility(View.VISIBLE);
                    toolbar.setVisibility(View.GONE);
                    fragment = new NotificationsFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_account:
//                  getSupportActionBar().setTitle("Account");
                    linearLayout.setVisibility(View.GONE);
                    toolbar.setVisibility(View.VISIBLE);
                    setSupportActionBar(toolbar);
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