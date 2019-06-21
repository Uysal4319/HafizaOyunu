package com.example.hafizaoyunu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.AppCompatDrawableManager;
import android.widget.Button;

import java.lang.Math.*;


public class kart extends Button {
    boolean isOpen = false;
    boolean cevrilebilir = true;
    int photoID;
    int backGroundID;
    int faceID;
    int kacli;
    Drawable back;
    Drawable face;

    public kart(Context context, int id,int matris) {
        super(context);
        setId(id);
        this.kacli = matris;



        if (kacli == 4) {

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

        } else if (kacli == 6) {

            backGroundID = R.drawable.back_altili;
            if ((id % 18) + 8 == 9) {
                faceID = R.drawable.c9;
            }
            if ((id % 18) + 8 == 10) {
                faceID = R.drawable.c10;
            }
            if ((id % 18) + 8 == 11) {
                faceID = R.drawable.c11;
            }
            if ((id % 18) + 8 == 12) {
                faceID = R.drawable.c12;
            }
            if ((id % 18) + 8 == 13) {
                faceID = R.drawable.c13;
            }
            if ((id % 18) + 8 == 14) {
                faceID = R.drawable.c14;
            }
            if ((id % 18) + 8 == 15) {
                faceID = R.drawable.c15;
            }
            if ((id % 18) + 8 == 16) {
                faceID = R.drawable.c16;
            }
            if ((id % 18) + 8 == 17) {
                faceID = R.drawable.c17;
            }
            if ((id % 18) + 8 == 18) {
                faceID = R.drawable.c18;
            }
            if ((id % 18) + 8 == 19) {
                faceID = R.drawable.c19;
            }
            if ((id % 18) + 8 == 20) {
                faceID = R.drawable.c20;
            }
            if ((id % 18) + 8 == 21) {
                faceID = R.drawable.c21;
            }
            if ((id % 18) + 8 == 22) {
                faceID = R.drawable.c22;
            }
            if ((id % 18) + 8 == 23) {
                faceID = R.drawable.c23;
            }
            if ((id % 18) + 8 == 24) {
                faceID = R.drawable.c24;
            }
            if ((id % 18) + 8 == 25) {
                faceID = R.drawable.c25;
            }
            if ((id % 18) + 8 == 8) {
                faceID = R.drawable.c26;
            }

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

