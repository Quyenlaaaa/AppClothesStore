package com.example.app_banhangtructuyen.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.app_banhangtructuyen.R;
import com.example.app_banhangtructuyen.adapter.DonHangDanhGiaAdapter;
import com.example.app_banhangtructuyen.model.DonHangDanhGia;

import java.util.ArrayList;

public class Danhgia1 extends AppCompatActivity {
    ListView lvvdadat;
    ArrayList<DonHangDanhGia> arraydadat;
    DonHangDanhGiaAdapter adapter2;
    Button btdanhgia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhgia1);


        Anhxa3();
        adapter2 = new DonHangDanhGiaAdapter(this, R.layout.list_don_hang_danh_gia, arraydadat);
        lvvdadat.setAdapter(adapter2);
        lvvdadat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                btdanhgia = findViewById(R.id.danhgia);
                btdanhgia.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent it = new Intent(Danhgia1.this, DanhGiaActivity.class);
                    }
                });
            }
        });
    }
    private void Anhxa3() {
        lvvdadat = (ListView) findViewById(R.id.list22);
        btdanhgia =findViewById(R.id.danhgia);
        arraydadat = new ArrayList<DonHangDanhGia>();
        arraydadat.add(new DonHangDanhGia("Hoàn thành", "# 12345", "20/6/2023", R.drawable.image_22,"Áo khoác nam Kaki - hiệu nokia samsung" ,"30/38 Hải Hồ, P.Thanh Bình, Quận Hải Châu...", R.drawable.currencycircledollar ,"50000d", " (1 món) - Tiền mặt"));
        arraydadat.add(new DonHangDanhGia("Hoàn thành", "# 12345", "20/6/2023", R.drawable.image_22,"Áo khoác nam Kaki - hiệu nokia samsung" ,"30/38 Hải Hồ, P.Thanh Bình, Quận Hải Châu...", R.drawable.currencycircledollar ,"50000d", " (1 món) - Tiền mặt"));
        arraydadat.add(new DonHangDanhGia("Hoàn thành", "# 12345", "20/6/2023", R.drawable.image_22,"Áo khoác nam Kaki - hiệu nokia samsung" ,"30/38 Hải Hồ, P.Thanh Bình, Quận Hải Châu...", R.drawable.currencycircledollar ,"50000d", " (1 món) - Tiền mặt"));
        arraydadat.add(new DonHangDanhGia("Hoàn thành", "# 12345", "20/6/2023", R.drawable.image_22,"Áo khoác nam Kaki - hiệu nokia samsung" ,"30/38 Hải Hồ, P.Thanh Bình, Quận Hải Châu...", R.drawable.currencycircledollar ,"50000d", " (1 món) - Tiền mặt"));
        arraydadat.add(new DonHangDanhGia("Hoàn thành", "# 12345", "20/6/2023", R.drawable.image_22,"Áo khoác nam Kaki - hiệu nokia samsung" ,"30/38 Hải Hồ, P.Thanh Bình, Quận Hải Châu...", R.drawable.currencycircledollar ,"50000d", " (1 món) - Tiền mặt"));
    }
}