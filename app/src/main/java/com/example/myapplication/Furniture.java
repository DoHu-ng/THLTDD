package com.example.myapplication;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Furniture implements Serializable {
    Integer id;
    String name;
    String description;
    String image;
    Categories categories;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Furniture{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image=" + image +
                ", categories=" + categories +
                '}';
    }

    public Furniture(String name, String description, String image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public Furniture(String name, String description, String image, Categories CategoriesID, Integer ID) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.categories=CategoriesID;
        this.id=ID;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public Categories getCategories() {
        return categories;
    }
    public void setCategories(Categories categories) {
        this.categories = categories;
    }


}
