package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

import me.gujun.android.taggroup.TagGroup;

public class SearchActivity extends AppCompatActivity {
    SearchView searchView;
    ArrayList<Furniture> arrayList;
    Utils utils;
    ListView listView;
    FurnitureAdapter furnitureAdapter;
    TagGroup mTagGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mTagGroup = findViewById(R.id.tag_group);
        mTagGroup.setTags(new String[]{"Bed", "Living", "Accessories", "Sealy", "Christopher"});

        utils = new Utils(SearchActivity.this);
        arrayList =new ArrayList<>();
        listView = findViewById(R.id.listView);
        furnitureAdapter = new FurnitureAdapter(SearchActivity.this, arrayList);
        listView.setAdapter(furnitureAdapter);
//        Log.d("FurnitureApp", utils.LoadFileInternal().size()+"");

        searchView = findViewById(R.id.search_vew);
        searchView.setIconifiedByDefault(true);
        searchView.setFocusable(true);
        searchView.setIconified(false);
        searchView.requestFocusFromTouch();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                searchFurniture(newText);
                return false;
            }
        });


    }

    private void searchFurniture(String newText) {
        ArrayList<Furniture> tmp = new ArrayList<>();
        for(Furniture furniture : utils.LoadFileInternal()){
            if(furniture.getName().toLowerCase().contains(newText.toLowerCase())){
                tmp.add(furniture);
            }
        }
        Toast.makeText(this, tmp.size()+"", Toast.LENGTH_SHORT).show();
        if(tmp.size() > 0){
            furnitureAdapter.clear();
            furnitureAdapter.addAll(tmp);
            furnitureAdapter.notifyDataSetChanged();
            listView.setVisibility(View.VISIBLE);
        }
        if(newText.isEmpty()){
            listView.setVisibility(View.GONE);
        }
    }
    public void hideSoftKeyboard(View view){
        InputMethodManager imm=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}