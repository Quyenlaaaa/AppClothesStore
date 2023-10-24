package com.example.taolao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ddadat extends AppCompatActivity {
    ListView lvvdadat;
    ArrayList<dadat> arraydadat;
    dadatAdapter adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ddadat);
        Anhxa3();
        adapter2 = new dadatAdapter(this, R.layout.dathanhtoan, arraydadat);
        lvvdadat.setAdapter(adapter2);
    }

    private void Anhxa3() {
        lvvdadat = (ListView) findViewById(R.id.list22);
        arraydadat = new ArrayList<dadat>();
        arraydadat.add(new dadat("Hoàn thành", "# 12345", "20/6/2023", R.drawable.image_22,"Áo khoác nam Kaki - hiệu nokia samsung" ,"30/38 Hải Hồ, P.Thanh Bình, Quận Hải Châu...",R.drawable.currencycircledollar ,"50000d", " (1 món) - Tiền mặt"));
        arraydadat.add(new dadat("Hoàn thành", "# 12345", "20/6/2023", R.drawable.image_22,"Áo khoác nam Kaki - hiệu nokia samsung" ,"30/38 Hải Hồ, P.Thanh Bình, Quận Hải Châu...",R.drawable.currencycircledollar ,"50000d", " (1 món) - Tiền mặt"));
        arraydadat.add(new dadat("Hoàn thành", "# 12345", "20/6/2023", R.drawable.image_22,"Áo khoác nam Kaki - hiệu nokia samsung" ,"30/38 Hải Hồ, P.Thanh Bình, Quận Hải Châu...",R.drawable.currencycircledollar ,"50000d", " (1 món) - Tiền mặt"));
        arraydadat.add(new dadat("Hoàn thành", "# 12345", "20/6/2023", R.drawable.image_22,"Áo khoác nam Kaki - hiệu nokia samsung" ,"30/38 Hải Hồ, P.Thanh Bình, Quận Hải Châu...",R.drawable.currencycircledollar ,"50000d", " (1 món) - Tiền mặt"));
        arraydadat.add(new dadat("Hoàn thành", "# 12345", "20/6/2023", R.drawable.image_22,"Áo khoác nam Kaki - hiệu nokia samsung" ,"30/38 Hải Hồ, P.Thanh Bình, Quận Hải Châu...",R.drawable.currencycircledollar ,"50000d", " (1 món) - Tiền mặt"));
    }
}
