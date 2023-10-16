package com.example.appbanquanao;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class Caidatthongbao extends AppCompatActivity {
    ListView simpleList;
    String List[] = {"Thông báo", "Cập nhật đơn hàng", "Khuyến mãi từ các cửa hàng", "Nhắc nhở", "Chuông thông báo"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caidatthongbao);
        simpleList	=	 (ListView)findViewById(R.id.caidat);
        CaidatAdapter adapter	= 	new CaidatAdapter(this, List,null);
        simpleList.setAdapter(adapter);
        Button back = (Button) findViewById(R.id.backve);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(Caidatthongbao.this, caidat.class);
                startActivity(myintent);
            }
        });
    }
}