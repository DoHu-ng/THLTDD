package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    TextView textView;
    ImageView imh;
    TextView textView2;
    Utils utils;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        utils = new Utils(getApplication());
        Intent intent = getIntent();
        Furniture furniture = (Furniture) intent.getSerializableExtra("furniture");
        textView=findViewById(R.id.textViewtitle);
        textView2=findViewById(R.id.textView4);
        imh=findViewById(R.id.imageView3);
        textView.setText(furniture.getName());
        textView2.setText(furniture.getDescription());
        imh.setImageBitmap(Utils.convertStringToBitmapFromAccess(this,furniture.getImage()));

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}