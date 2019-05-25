package com.example.hafizaoyunu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        TextView tv = (TextView) findViewById(R.id.result);
        Intent i =getIntent();

      final  String isim =i.getStringExtra("isim");
        int skor = i.getIntExtra("puan",0);
        tv.setText("Tebrikler "+ isim+  "\n"+ skor+ " hata ile bitirdiniz.");

        ((Button) findViewById(R.id.restart)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rI = new Intent(Main3Activity.this,Main2Activity.class);
                rI.putExtra("isim",isim);
                startActivity(rI);
            }
        });


    }

}
