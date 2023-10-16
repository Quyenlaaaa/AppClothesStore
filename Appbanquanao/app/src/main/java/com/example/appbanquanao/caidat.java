package com.example.appbanquanao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class caidat extends AppCompatActivity {
    ListView simpleList;
    String List[] = {"Thông báo", "Cài đặt riêng tư", "Cài đặt ngôn ngữ"};
    int flags[] = {R.drawable.bellringing, R.drawable.usergear__1_, R.drawable.translate__1_};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caidat);
        simpleList	=	 (ListView)findViewById(R.id.lvcaidat);
        CaidatchungAdapter adapter	= 	new CaidatchungAdapter(this, List, flags);
        simpleList.setAdapter(adapter);
        Button back = (Button) findViewById(R.id.backve);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(caidat.this, MainActivity.class);
                startActivity(myintent);
            }
        });
        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0: Intent myintent = new Intent(caidat.this, Caidatthongbao.class);
                        startActivity(myintent);
                    case 1: Intent myintent1 = new Intent(caidat.this,Caidatthongbao.class);
                        startActivity(myintent1); break;
                    case 2: Intent myintent2 = new Intent(caidat.this, Ngonngu.class);
                        startActivity(myintent2); break;

                }
            }
        });
    }
}