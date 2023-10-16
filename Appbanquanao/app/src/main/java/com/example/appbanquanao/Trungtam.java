package com.example.appbanquanao;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class Trungtam extends AppCompatActivity {
    ListView simpleList;
    String List[] = {"Xin chào! Món này còn không shop? ", "Xin chào! Món này còn không shop?"};
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trungtam);
        simpleList	=	 (ListView)findViewById(R.id.lvtthh);
        CaidatchungAdapter2 adapter	= 	new CaidatchungAdapter2(this, List);
        simpleList.setAdapter(adapter);
        Button back = (Button) findViewById(R.id.backve);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(Trungtam.this,Hotro.class);
                startActivity(myintent);
            }
        });
    }
}