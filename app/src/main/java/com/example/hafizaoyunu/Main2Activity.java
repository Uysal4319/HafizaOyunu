package com.example.hafizaoyunu;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;


public class Main2Activity extends AppCompatActivity {
    int sonKart = 0;
    int skor;
    int hata;
    int first = 1;
    int last = 16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent i = getIntent();
        final String s = i.getStringExtra("isim");
        final int matris = i.getIntExtra("matris", 4);

        TextView tv = (TextView) findViewById(R.id.isim);
        tv.setText(s);

        GridLayout gr = (GridLayout) findViewById(R.id.cards);


        final kart kartlar[] = new kart[matris * matris];
        if (matris == 6) {
            gr.setColumnCount(6);
            gr.setRowCount(6);

            for (int j = 1; j <= 36; j++) {
                kartlar[j - 1] = new kart(this, j,matris);
                first = 1;
                last = 36;
            }

        } else if (matris == 4) {

            gr.setColumnCount(4);
            gr.setRowCount(4);

            for (int j = 1; j <= 16; j++) {
                kartlar[j - 1] = new kart(this, j,matris);
                first = 1;
                last = 16;
            }

        }
        for (int j = first; j <= last; j++) {
            kartlar[j - 1].setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onClick(View v) {
                    final kart k = (kart) v;

                    k.cevir();
                    if (sonKart > 0) {
                        final kart k2 = (kart) findViewById(sonKart);
                        k2.kacli = matris;
                        if (k2.faceID == k.faceID && k2.getId() != k.getId()) {
                            k.cevrilebilir = false;
                            k2.cevrilebilir = false;
                            skor++;
                            TextView tv = (TextView) findViewById(R.id.skor);
                            tv.setText("Skor : " + skor);
                            sonKart = 0;
                            if ((matris == 4 && skor == 8) || (matris == 6 && skor == 18)){
                                Intent i = new Intent(Main2Activity.this, Main3Activity.class);
                                i.putExtra("puan", hata);
                                i.putExtra("isim", s);
                                startActivity(i);
                            }

                        } else {
                            Handler h = new Handler();
                            h.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    k.cevir();
                                    k2.cevir();
                                }
                            }, 500);

                            sonKart = 0;
                            hata++;
                            TextView tv = (TextView) findViewById(R.id.hata);
                            tv.setText("Hata : " + hata);
                        }
                    } else {
                        sonKart = k.getId();
                    }
                }
            });
        }


        // Karistir
        if (matris == 6) {
            karistir(kartlar, 36);
            for (int j = 0; j < 36; j++) {
                gr.addView(kartlar[j]);
            }
        } else if (matris == 4) {
            karistir(kartlar, 16);
            for (int j = 0; j < 16; j++) {
                gr.addView(kartlar[j]);
            }
        }


    }

    public kart[] karistir(kart cards[], int incr) {
        for (int j = 0; j < incr; j++) {
            int random = (int) (Math.random() * incr);
            kart k = cards[random];
            cards[random] = cards[j];
            cards[j] = k;
        }
        return cards;
    }

}
