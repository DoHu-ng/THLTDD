package com.example.myapplication;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Utils {
    public static Bitmap convertStringToBitmapFromAccess(Context context, String
            filename){
        AssetManager assetManager = context.getAssets();
        try {
            InputStream is = assetManager.open(filename);
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            return bitmap;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static  ArrayList<Furniture> getMockData(Context context){
        ArrayList<Furniture> tmp = new ArrayList<>();
        tmp.add(new Furniture(context.getString(R.string.product_one), context.getString(R.string.product_one_des), convertStringToBitmapFromAccess(context,"hinh_1.png")));
        tmp.add(new Furniture(context.getString(R.string.product_one), context.getString(R.string.product_one_des), convertStringToBitmapFromAccess(context,"hinh_2.png")));
        tmp.add(new Furniture(context.getString(R.string.product_one), context.getString(R.string.product_one_des), convertStringToBitmapFromAccess(context,"hinh_3.png")));
        tmp.add(new Furniture(context.getString(R.string.product_one), context.getString(R.string.product_one_des), convertStringToBitmapFromAccess(context,"hinh_4.png")));
        tmp.add(new Furniture(context.getString(R.string.product_one), context.getString(R.string.product_one_des), convertStringToBitmapFromAccess(context,"hinh_5.png")));
        tmp.add(new Furniture(context.getString(R.string.product_one), context.getString(R.string.product_one_des), convertStringToBitmapFromAccess(context,"hinh_6.png")));
        return tmp;
    }

    public static ArrayList<Categories> getMockData2(Context context) {
        ArrayList<Furniture> arrayListBed = new ArrayList<>();
        ArrayList<Furniture> arrayListLiving = new ArrayList<>();
        ArrayList<Furniture> arrayListMeeting = new ArrayList<>();
        ArrayList<Furniture> arrayListAccessories = new ArrayList<>();
        ArrayList<Categories> tmp = new ArrayList<>();
        tmp.add(new Categories("BedRoom", arrayListBed,
                convertStringToBitmapFromAccess(context,"bed_room.png")));
        tmp.add(new Categories("LivingRoom", arrayListBed,
                convertStringToBitmapFromAccess(context,"living_room.png")));
        tmp.add(new Categories("Meeting", arrayListBed,
                convertStringToBitmapFromAccess(context,"meeting_room.png")));
        tmp.add(new Categories("Accessories", arrayListBed,
                convertStringToBitmapFromAccess(context,"accessories.png")));
        return tmp;
    }


    public static ArrayList<Furniture> getMockData3(Context context) {
        ArrayList<Furniture> tmp = new ArrayList<>();
        tmp.add(new Furniture(context.getString(R.string.product_one), context.getString(R.string.product_one_des), convertStringToBitmapFromAccess(context,"hinh_2.png")));
        tmp.add(new Furniture(context.getString(R.string.product_one), context.getString(R.string.product_one_des), convertStringToBitmapFromAccess(context,"hinh_3.png")));
        tmp.add(new Furniture(context.getString(R.string.product_one), context.getString(R.string.product_one_des), convertStringToBitmapFromAccess(context,"hinh_4.png")));

        return tmp;
    }
}
