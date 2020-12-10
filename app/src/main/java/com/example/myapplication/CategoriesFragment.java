package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class CategoriesFragment extends Fragment {
    ListView listView;
    ArrayList<Furniture> arrayList;
    FurnitureAdapter furnitureAdapter;
    Utils utils;
    DBHelper dbHelper;

    public CategoriesFragment() {
        // Required empty public constructor
    }

    public static CategoriesFragment newInstance(int pos) {
        // Required empty public constructor
        Bundle bundle = new Bundle();
        bundle.putInt("category", pos);
        CategoriesFragment categoriesFragment = new CategoriesFragment();
        categoriesFragment.setArguments(bundle);
        return categoriesFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        utils = new Utils(getContext());
        dbHelper = new DBHelper(getContext());
        return inflater.inflate(R.layout.fragment_categories, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();
        listView = view.findViewById(R.id.listView);
        arrayList = new ArrayList<>();
        //dbHelper.insertFurniture();
//        arrayList = utils.getFurnitureFromCategories(bundle.getInt("category"));
        //arrayList=dbHelper.addFurnitureToCategories(bundle.getInt("category"));
        arrayList = dbHelper.getFurnitureFromCategories(bundle.getInt("category"));
        furnitureAdapter = new FurnitureAdapter(getContext(),arrayList);
        listView.setAdapter(furnitureAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos,
                                    long l) {
                Utils.furnitureHistory.add(arrayList.get(pos));
                Toast.makeText(getContext(), pos+"", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("furniture", arrayList.get(pos));
                startActivity(intent);
            }
        });
    }
}