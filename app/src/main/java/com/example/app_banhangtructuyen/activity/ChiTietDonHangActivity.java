package com.example.app_banhangtructuyen.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.app_banhangtructuyen.R;
import com.example.app_banhangtructuyen.adapter.SanPhamInDatHangAdapter;
import com.example.app_banhangtructuyen.model.Product;

import java.util.ArrayList;


public class ChiTietDonHangActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_don_hang);
        ShowlistSanPhamChiTiet();

        AppCompatButton huyDonButton = findViewById(R.id.buttonHuyDon);

        huyDonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChiTietDonHangActivity.this, Huy.class);
                startActivity(intent);
            }
        });
    }

    public void goBack(View view) {
        finish();
    }

    private void ShowlistSanPhamChiTiet() {
        ListView gridView = (ListView) findViewById(R.id.lvquanao);
        ArrayList arrayList = new ArrayList<>();

//        arrayList.add(new Product(1,"Áo khoác nam",150000,R.drawable.sanpham," ",1));
//        arrayList.add(new Product(2,"Áo khoác nam",150000,R.drawable.sanpham," ",2));
//        arrayList.add(new Product(3,"Áo khoác nam",150000,R.drawable.sanpham," ",3));
//        arrayList.add(new Product(3,"Áo khoác nam",150000,R.drawable.sanpham," ",4));
        SanPhamInDatHangAdapter adapter = new SanPhamInDatHangAdapter(this,arrayList);
        gridView.setAdapter(adapter);
    }
}
