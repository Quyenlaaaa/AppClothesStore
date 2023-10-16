package com.example.appbanquanao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class Hoso extends AppCompatActivity {
    ListView simpleList;
    String List[] = {"Số điện thoại", "Giới tính", "Email", "Địa chỉ", "Thay đổi mật khẩu"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoso);
        simpleList	=	 (ListView)findViewById(R.id.hoso);
        HosoAdapter adapter	= 	new HosoAdapter(this, List,null);
        simpleList.setAdapter(adapter);
        Button back = (Button) findViewById(R.id.backve);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(Hoso.this, MainActivity.class);
                startActivity(myintent);
            }
        });
    }
}