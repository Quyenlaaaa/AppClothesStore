package com.example.taolao;

import static com.example.taolao.R.id.themvaogiohang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button buttonNextPage;
    ListView lvvgiohang;
    ArrayList<giohang> arraygiohang;
    GiohangAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonNextPage = (Button) findViewById(R.id.themvaogiohang);
        buttonNextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int1 = new Intent(MainActivity.this, giohangmain.class);
                startActivity(int1);
            }
        });
    }



    
    
}