package com.example.myapplication;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Utils {
    private Context context;
     static String filename = "database";
    public Utils(Context context) {
        this.context=context;
    }

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
        tmp.add(new Furniture(context.getString(R.string.product_one), context.getString(R.string.product_one_des), "hinh_1.png"));
        tmp.add(new Furniture(context.getString(R.string.product_two), context.getString(R.string.product_one_des), "hinh_2.png"));
        tmp.add(new Furniture(context.getString(R.string.product_three), context.getString(R.string.product_one_des), "hinh_3.png"));
        tmp.add(new Furniture(context.getString(R.string.product_four), context.getString(R.string.product_one_des), "hinh_4.png"));
        tmp.add(new Furniture(context.getString(R.string.product_five), context.getString(R.string.product_one_des),"hinh_5.png"));
        tmp.add(new Furniture(context.getString(R.string.product_six), context.getString(R.string.product_one_des), "hinh_6.png"));
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

    static ArrayList<Furniture> furnitureHistory = new ArrayList<>();

    public void addFurintureHistorry(Furniture furniture) {
            if(furnitureHistory.indexOf(furniture) > 0) {
                this.furnitureHistory.add(0, furniture);
            }

    }
    public ArrayList<Furniture> getFurnitureHistory(){ return this.furnitureHistory; }

    public ArrayList<Furniture> getFurnitureFromCategories(int pos){
        ArrayList<Furniture> tmp = new ArrayList<>();
        switch (pos){
            case 0:
                tmp.add(new Furniture(context.getString(R.string.product_one), context.getString(R.string.product_one_des), "hinh_1.png"));
                tmp.add(new Furniture(context.getString(R.string.product_one), context.getString(R.string.product_one_des), "hinh_2.png"));
                tmp.add(new Furniture(context.getString(R.string.product_one), context.getString(R.string.product_one_des), "hinh_3.png"));
                tmp.add(new Furniture(context.getString(R.string.product_one), context.getString(R.string.product_one_des), "hinh_4.png"));
                break;
            case 1:
                tmp.add(new Furniture(context.getString(R.string.product_one), context.getString(R.string.product_one_des), "hinh_3.png"));
                tmp.add(new Furniture(context.getString(R.string.product_one), context.getString(R.string.product_one_des), "hinh_4.png"));
                tmp.add(new Furniture(context.getString(R.string.product_one), context.getString(R.string.product_one_des), "hinh_2.png"));
                break;
            case 2:
                tmp.add(new Furniture(context.getString(R.string.product_one), context.getString(R.string.product_one_des), "hinh_2.png"));
                tmp.add(new Furniture(context.getString(R.string.product_one), context.getString(R.string.product_one_des), "hinh_3.png"));
                tmp.add(new Furniture(context.getString(R.string.product_one), context.getString(R.string.product_one_des), "hinh_4.png"));
                tmp.add(new Furniture(context.getString(R.string.product_one), context.getString(R.string.product_one_des), "hinh_5.png"));
                break;
            case 3:
                tmp.add(new Furniture(context.getString(R.string.product_one), context.getString(R.string.product_one_des), "hinh_3.png"));
                tmp.add(new Furniture(context.getString(R.string.product_one), context.getString(R.string.product_one_des), "hinh_4.png"));
                tmp.add(new Furniture(context.getString(R.string.product_one), context.getString(R.string.product_one_des), "hinh_5.png"));
                tmp.add(new Furniture(context.getString(R.string.product_one), context.getString(R.string.product_one_des), "hinh_1.png"));
                break;
        }
        return tmp;
    }

    public void WriteToFileInternal(ArrayList<Furniture> arrayList){

        try {
            File file = new File(context.getFilesDir(), filename);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new
                    ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(arrayList);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Furniture> LoadFileInternal() {
        ArrayList<Furniture> arrayList = new ArrayList<>();
        try {
            File file = new File(context.getFilesDir(), filename);
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            arrayList = (ArrayList<Furniture>) objectInputStream.readObject();
            Log.d("FurnitureApp", arrayList.size() + "");
            return arrayList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); }
        return null;
    }
}


