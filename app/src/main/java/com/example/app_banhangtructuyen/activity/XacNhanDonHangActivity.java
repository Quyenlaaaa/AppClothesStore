package com.example.app_banhangtructuyen.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.app_banhangtructuyen.R;
import com.example.app_banhangtructuyen.adapter.SanPhamInDatHangAdapter;
import com.example.app_banhangtructuyen.adapter.SanphamAdapter;
import com.example.app_banhangtructuyen.model.ItemCart;
import com.example.app_banhangtructuyen.model.Product;

import java.util.ArrayList;
import java.util.List;

public class XacNhanDonHangActivity extends AppCompatActivity {
    List<Product> arrayList;
    List<ItemCart> itemCartList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xac_nhan_don_hang);
        ShowListSPDM();
        ClickBtnMua();
        ClickSuaThongTin();
    }

    private void ShowListSPDM() {
        ListView listView = findViewById(R.id.lvquanao);
        arrayList = new ArrayList<>();
        arrayList.add(new Product(1,"Áo khoác nam",150000,R.drawable.sanpham," ",1));
        arrayList.add(new Product(2,"Áo khoác nam",150000,R.drawable.sanpham," ",2));
        arrayList.add(new Product(3,"Áo khoác nam",150000,R.drawable.sanpham," ",3));
        arrayList.add(new Product(4,"Áo khoác nam",150000,R.drawable.sanpham," ",4));
        SanPhamInDatHangAdapter adapter = new SanPhamInDatHangAdapter(this,arrayList);
        listView.setAdapter(adapter);
    }
    public void goBack(View view){
        finish();
    }
    public void ClickBtnMua(){
        AppCompatButton button = (AppCompatButton) findViewById(R.id.btnmua);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(XacNhanDonHangActivity.this, ChiTietDonHangActivity.class);
                startActivity(intent);
            }
        });
    }public void ClickSuaThongTin(){
        ImageView imageView = (ImageView) findViewById(R.id.suathongtin);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(XacNhanDonHangActivity.this, SuaDiaChiNhanHangActivity.class);
                startActivity(intent);
            }
        });
    }


}