package com.example.taolao;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class giohangmain extends AppCompatActivity {
    private Button buttonNextPage;
    private ImageButton buttonBack;
    ListView lvvgiohang;
    ArrayList<giohang> arraygiohang;
    GiohangAdapter adapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giohangmain);
        Anhxa();
        buttonNextPage = (Button) findViewById(R.id.muangay);
        buttonNextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int1 = new Intent(giohangmain.this, ddadat.class);
                startActivity(int1);

            }

        });

        buttonBack = (ImageButton) findViewById(R.id.quayve);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int1 = new Intent(giohangmain.this, MainActivity.class);
                startActivity(int1);
            }
        });
        adapter = new GiohangAdapter(this, R.layout.lvsanpham, arraygiohang);
        lvvgiohang.setAdapter(adapter);
    }
    private void Anhxa() {
        lvvgiohang = (ListView) findViewById(R.id.sanpham);
        arraygiohang = new ArrayList<>();

        arraygiohang.add(new giohang(R.drawable.image_22, "Áo khoác nam Kaki - hiệu NokiaSamsung", R.drawable.currencycircledollar, "50000", "2"));
        arraygiohang.add(new giohang(R.drawable.image_22, "Áo khoác nam Kaki - hiệu NokiaSamsung", R.drawable.currencycircledollar, "100000", "2"));
        arraygiohang.add(new giohang(R.drawable.image_22, "Áo khoác nam Kaki - hiệu NokiaSamsung", R.drawable.currencycircledollar, "200000", "2"));
        arraygiohang.add(new giohang(R.drawable.image_22, "Áo khoác nam Kaki - hiệu NokiaSamsung", R.drawable.currencycircledollar, "300000", "2"));
        arraygiohang.add(new giohang(R.drawable.image_22, "Áo khoác nam Kaki - hiệu NokiaSamsung", R.drawable.currencycircledollar, "400000", "2"));
    }
}