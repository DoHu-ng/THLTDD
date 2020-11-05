package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class FurnitureAdapter extends ArrayAdapter<Furniture> {
    Context context;
    ArrayList<Furniture> arrayList;

    public FurnitureAdapter(@NonNull Context context, @NonNull ArrayList<Furniture> objects) {
        super(context, 0, objects);
        this.context = context;
        this.arrayList = objects;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.item, parent,false);

        Furniture furniture = arrayList.get(position);

        TextView textView=convertView.findViewById(R.id.textView);
        ImageView imageView=convertView.findViewById(R.id.imageView);

        textView.setText(furniture.getDescription());

        imageView.setImageBitmap(furniture.getImage());

        return convertView;
    }

}
