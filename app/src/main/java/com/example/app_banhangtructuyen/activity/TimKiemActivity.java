package com.example.app_banhangtructuyen.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.app_banhangtructuyen.R;
import com.example.app_banhangtructuyen.adapter.SanphamAdapter;
import com.example.app_banhangtructuyen.fragment.FragmentHome;
import com.example.app_banhangtructuyen.model.Product;

import java.util.ArrayList;
import java.util.List;

public class TimKiemActivity extends AppCompatActivity {
    List<Product> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tim_kiem);
        ShowSanPham();
        ClickItemSanpham();


    }
    public  void ShowSanPham(){
        arrayList = new ArrayList<>();
//        arrayList.add(new Product(1,"Áo khoác nam",150000,R.drawable.sanpham," ",1));
//        arrayList.add(new Product(2,"Áo khoác nam",150000,R.drawable.sanpham," ",2));
//        arrayList.add(new Product(3,"Áo khoác nam",150000,R.drawable.sanpham," ",3));
//        arrayList.add(new Product(4,"Áo khoác nam",150000,R.drawable.sanpham," ",4));
//        arrayList.add(new Product(5,"Áo khoác nam",150000,R.drawable.sanpham," ",5));
//        arrayList.add(new Product(6,"Áo khoác nam",150000,R.drawable.sanpham," ",6));
//        arrayList.add(new Product(7,"Áo khoác nam",150000,R.drawable.sanpham," ",7));
//        arrayList.add(new Product(8,"Áo khoác nam",150000,R.drawable.sanpham," ",8));
        GridView recyclerView = (GridView) findViewById(R.id.tksanpham);

        SanphamAdapter adapter = new SanphamAdapter(this,arrayList);
        recyclerView.setAdapter(adapter);
    }
    public void ClickItemSanpham(){
        GridView gridView = (GridView) findViewById(R.id.tksanpham);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(TimKiemActivity.this, DetailActivity.class);
                startActivity(intent);
            }
        });
    }
    public void goBack(View view) {
        // Đóng hoạt động hiện tại và quay lại hoạt động trước đó
        finish();
    }


}