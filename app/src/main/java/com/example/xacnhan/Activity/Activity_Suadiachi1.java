package com.example.xacnhan.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.xacnhan.Domain.Xacnhan;
import com.example.xacnhan.R;

public class Activity_Suadiachi1 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suadiachi1);





        Button chuyentrang = findViewById(R.id.chuyentiep1);
        chuyentrang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(Activity_Suadiachi1.this, Activity_Suadiachi2.class);
                startActivity(myintent);
            }
        });

        Button back1 = (Button) findViewById(R.id.back_xacnhan);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back1 = new Intent(Activity_Suadiachi1.this, MainActivity.class);
                startActivity(back1);
            }
        });

        Button chinhsua_diachinha = (Button) findViewById(R.id.chinhsua_diachinha);
        chinhsua_diachinha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chinhsuanha = new Intent(Activity_Suadiachi1.this, Activity_Suadiachi3.class);
                startActivity(chinhsuanha);
            }
        });

        Button chinhsua_diachihotel = (Button) findViewById(R.id.chinhsua_diachihotel);
        chinhsua_diachihotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chinhsuahotel = new Intent(Activity_Suadiachi1.this, Activity_Suadiachi3.class);
                startActivity(chinhsuahotel);
            }
        });

}
    }