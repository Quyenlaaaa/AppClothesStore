package com.example.appbanquanao;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class Hotro extends AppCompatActivity {
    ListView simpleList;
    String List[] = {"Trung tâm hỗ trợ ", "Yêu cầu xóa tài khoản"};
    int flags[] = {R.drawable.headphones,R.drawable.chinhsua};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotro);
        simpleList	=	 (ListView)findViewById(R.id.lvhotro);
        CaidatchungAdapter adapter	= 	new CaidatchungAdapter(this, List, flags);
        simpleList.setAdapter(adapter);
        Button back = (Button) findViewById(R.id.backve);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent0 = new Intent(Hotro.this, MainActivity.class);
                startActivity(myintent0);
            }
        });
        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0: Intent myintent = new Intent(Hotro.this, Trungtam.class);
                        startActivity(myintent);break;
                    case 1: Intent myintent1 = new Intent(Hotro.this,Xoataikhoan.class);
                        startActivity(myintent1); break;
                }
            }
        });
    }
}