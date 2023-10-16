package com.example.appbanquanao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Ngonngu extends AppCompatActivity {
     String List[] = {"Tiếng Việt", " Tiếng Anh","Tiếng Nhật","Tiếng Hàn","Tiếng Lào"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngonngu);
        ListView lvnn = (ListView) findViewById(R.id.lvnn);
       NgonguAdapter nn = new NgonguAdapter(this,List,null);
        lvnn.setAdapter(nn);
        Button back = (Button) findViewById(R.id.backve);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(Ngonngu.this, caidat.class);
                startActivity(myintent);
            }
        });
    }
}