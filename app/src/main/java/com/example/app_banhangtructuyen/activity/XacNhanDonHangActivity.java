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
import android.widget.TextView;

import com.example.app_banhangtructuyen.R;
import com.example.app_banhangtructuyen.adapter.SanPhamInDatHangAdapter;
import com.example.app_banhangtructuyen.adapter.SanphamAdapter;
import com.example.app_banhangtructuyen.model.ItemCart;
import com.example.app_banhangtructuyen.model.Product;
import com.example.app_banhangtructuyen.model.ShoppingCart;
import com.example.app_banhangtructuyen.model.ShoppingCartSingleton;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class XacNhanDonHangActivity extends AppCompatActivity {
    ShoppingCart shoppingCart;
    double tongtien;
    double tongtien2;
    TextView tt, tt2, tt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xac_nhan_don_hang);
        shoppingCart = ShoppingCartSingleton.getInstance().getShoppingCart();
        ShowListSPDM();
        tongtien = shoppingCart.getCountItemCart();
        tongtien2 = shoppingCart.getCountItemCart2();
        tt = (TextView) findViewById(R.id.tongcong);
        tt2 = (TextView) findViewById(R.id.tongcong2);
        tt3 = (TextView) findViewById(R.id.tien);
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        tt.setText(decimalFormat.format(tongtien)+" đ");
        tt2.setText(decimalFormat.format(tongtien2)+" đ");
        tt3.setText(decimalFormat.format(tongtien2)+ " đ");
        //ClickBtnMua();
        //ClickSuaThongTin();
    }

    private void ShowListSPDM() {
        ListView listView = findViewById(R.id.lvquanao);
        List<ItemCart> arrayList = shoppingCart.getCartItems();

//        arrayList.add(new Product(1,"Áo khoác nam",150000,R.drawable.sanpham," ",1));
//        arrayList.add(new Product(2,"Áo khoác nam",150000,R.drawable.sanpham," ",2));
//        arrayList.add(new Product(3,"Áo khoác nam",150000,R.drawable.sanpham," ",3));
//        arrayList.add(new Product(4,"Áo khoác nam",150000,R.drawable.sanpham," ",4));
        SanPhamInDatHangAdapter adapter = new SanPhamInDatHangAdapter(this,arrayList);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
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