package com.example.xacnhan.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.xacnhan.R;

public class Activity_Suadiachi3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suadiachi3);

        Button back_suadiachi2 = (Button) findViewById(R.id.back_suadiachi2);
        back_suadiachi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(Activity_Suadiachi3.this, Activity_Suadiachi1.class);
                startActivity(myintent);
            }
        });

        Button btnluu = (Button) findViewById(R.id.bt_luu);
        btnluu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btn_luu = new Intent(Activity_Suadiachi3.this, MainActivity.class);
                startActivity(btn_luu);
            }
        });
    }
}