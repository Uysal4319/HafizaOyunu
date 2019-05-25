package com.example.hafizaoyunu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.AppCompatDrawableManager;
import android.widget.Button;
import  java.lang.Math.*;


public class kart extends Button  {
    boolean isOpen = false;
    boolean cevrilebilir = true;
    int photoID;
    int backGroundID;
    int faceID = R.drawable.c7;
    Drawable back;
    Drawable face;

    public kart(Context context, int id) {
        super(context);
        setId(id);

        backGroundID = R.drawable.back;

        if (id % 8 == 1) {
            faceID = R.drawable.c1;
        }
        if (id % 8 == 2) {
            faceID = R.drawable.c2;
        }
        if (id % 8 == 3) {
            faceID = R.drawable.c3;
        }
        if (id % 8 == 4) {
            faceID = R.drawable.c4;
        }
        if (id % 8 == 5) {
            faceID = R.drawable.c5;
        }
        if (id % 8 == 6) {
            faceID = R.drawable.c6;
        }
        if (id % 8 == 7) {
            faceID = R.drawable.c7;
        }
        if (id % 8 == 0) {
            faceID = R.drawable.c8;
        }

        back = AppCompatDrawableManager.get().getDrawable(context, backGroundID);
        face = AppCompatDrawableManager.get().getDrawable(context, faceID);
        setBackground(back);
    }

    public void cevir() {
        if (!cevrilebilir)
            return;
        if (!isOpen) {
            setBackground(face);
            isOpen = true;
        } else {
            setBackground(back);
            isOpen = false;

        }
    }

}

