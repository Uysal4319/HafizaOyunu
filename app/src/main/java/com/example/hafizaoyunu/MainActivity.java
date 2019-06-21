package com.example.hafizaoyunu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    int matris = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText et = (EditText) findViewById(R.id.nameEdit);


        ((Button) findViewById(R.id.start)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Main2Activity.class);
                i.putExtra("isim", et.getText().toString());
                i.putExtra("matris", matris);
                startActivity(i);
            }
        });

        RadioButton dortlu = (RadioButton) findViewById(R.id.dortlu);
        RadioButton altili = (RadioButton) findViewById(R.id.altili);


    }

    public void onRadioButtonClicked(View view) {
        boolean check_durum = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.dortlu:
                if (check_durum) {
                    matris = 4;
                }
                break;
            case R.id.altili:
                if (check_durum) {
                    matris = 6;
                }
                break;
        }
    }
}
