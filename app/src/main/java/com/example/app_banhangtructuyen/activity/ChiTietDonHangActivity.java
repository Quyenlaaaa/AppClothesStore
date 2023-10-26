package com.example.app_banhangtructuyen.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;

import com.example.app_banhangtructuyen.R;
import com.example.app_banhangtructuyen.adapter.GiohangAdapter;
import com.example.app_banhangtructuyen.adapter.SanPhamInDatHangAdapter;
import com.example.app_banhangtructuyen.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ChiTietDonHangActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_don_hang);
        ShowlistSanPhamChiTiet();
    }

    public void goBack(View view) {
        // Đóng hoạt động hiện tại và quay lại hoạt động trước đó
        finish();
    }
    private void ShowlistSanPhamChiTiet() {

        ListView gridView = (ListView) findViewById(R.id.lvquanao);
        ArrayList arrayList = new ArrayList<>();

        arrayList.add(new Product(1,"Áo khoác nam",150000,R.drawable.sanpham," ",1));
        arrayList.add(new Product(2,"Áo khoác nam",150000,R.drawable.sanpham," ",2));
        arrayList.add(new Product(3,"Áo khoác nam",150000,R.drawable.sanpham," ",3));
        arrayList.add(new Product(4,"Áo khoác nam",150000,R.drawable.sanpham," ",4));
        SanPhamInDatHangAdapter adapter = new SanPhamInDatHangAdapter(this,arrayList);
        gridView.setAdapter(adapter);
    }
}