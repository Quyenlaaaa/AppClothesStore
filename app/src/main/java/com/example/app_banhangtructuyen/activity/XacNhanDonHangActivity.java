package com.example.app_banhangtructuyen.activity;

import androidx.annotation.NonNull;
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
import android.widget.Toast;

import com.example.app_banhangtructuyen.R;
import com.example.app_banhangtructuyen.adapter.SanPhamInDatHangAdapter;
import com.example.app_banhangtructuyen.adapter.SanphamAdapter;
import com.example.app_banhangtructuyen.model.ItemCart;
import com.example.app_banhangtructuyen.model.Product;
import com.example.app_banhangtructuyen.model.ShoppingCart;
import com.example.app_banhangtructuyen.model.ShoppingCartSingleton;
import com.example.app_banhangtructuyen.model.UserSingleton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class XacNhanDonHangActivity extends AppCompatActivity {
    ShoppingCart shoppingCart;
    double tongtien;
    double tongtien2;
    TextView tt, tt2, tt3, tenuser, sodt, diachi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xac_nhan_don_hang);
        tenuser = findViewById(R.id.tenuser);
        sodt = findViewById(R.id.sodt);
        diachi= findViewById(R.id.diachi);
        UserSingleton userSingleton = UserSingleton.getInstance();
        String email = userSingleton.getUsername();
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference("Khachhang");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snap:snapshot.getChildren())
                {
                    String emaila = snap.child("phone_email").getValue(String.class);

                    if( email.equals(emaila)==true)
                    {
                        tenuser.setText(snap.child("hoTen").getValue(String.class));
                        sodt.setText(snap.child("sodt").getValue(String.class));
                        diachi.setText(snap.child("diaChi").getValue(String.class));
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(XacNhanDonHangActivity.this, "Lỗi xuất dữ liệu", Toast.LENGTH_SHORT);
            }
        });

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
        ActionAddCart();
    }

    private void ActionAddCart() {
        AppCompatButton button = (AppCompatButton) findViewById(R.id.btnmua);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserSingleton userSingleton = UserSingleton.getInstance();
                String email = userSingleton.getUsername();
                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                DatabaseReference myRef = firebaseDatabase.getReference("Hoadon");
                myRef.push().setValue(shoppingCart);
                Toast.makeText(XacNhanDonHangActivity.this, "Đặt thành công", Toast.LENGTH_SHORT).show();
            }
        });
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