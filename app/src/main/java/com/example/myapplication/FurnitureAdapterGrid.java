package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class FurnitureAdapterGrid extends ArrayAdapter<Categories> {
    Context context;
    ArrayList<Categories> arrayList;
    public FurnitureAdapterGrid(@NonNull Context context, @NonNull ArrayList<Categories> objects) {
        super(context, 0, objects);
        this.context = context;
        this.arrayList = objects;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.item2, parent,false);

        Categories categories = arrayList.get(position);

        TextView textView = convertView.findViewById(R.id.textView2);
        ImageView imageView = convertView.findViewById(R.id.imageView2);

        textView.setText(categories.getName());

        imageView.setImageBitmap(Utils.convertStringToBitmapFromAccess(getContext(), categories.getImage()));

        return convertView;
    }
}
