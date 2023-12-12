package com.example.app_banhangtructuyen.activity;

import static android.system.Os.remove;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app_banhangtructuyen.R;
import com.example.app_banhangtructuyen.adapter.GiohangAdapter;
import com.example.app_banhangtructuyen.adapter.SanPhamInDatHangAdapter;
import com.example.app_banhangtructuyen.fragment.FragmentHome;
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


public class ChiTietDonHangActivity extends AppCompatActivity {
    ShoppingCart shoppingCart;
    GridView gridView;
    ArrayList<ItemCart> arrayList;
    SanPhamInDatHangAdapter adapter;
    double tongtien;
    double tongtien2;
    TextView tt, tt2, tenuser, sodt, diachi;
    ItemCart itemCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_don_hang);
        shoppingCart = ShoppingCartSingleton.getInstance().getShoppingCart();
        ShowlistSanPhamChiTiet();
        tongtien = shoppingCart.getCountItemCart();
        tongtien2 = shoppingCart.getCountItemCart2();
        tt = (TextView) findViewById(R.id.tong1);
        tt2 = (TextView) findViewById(R.id.tong2);
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        tt.setText(decimalFormat.format(tongtien)+" đ");
        tt2.setText(decimalFormat.format(tongtien2)+" đ");
        AppCompatButton huyDonButton = findViewById(R.id.buttonHuyDon);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        UserSingleton userSingleton = UserSingleton.getInstance();
        String email = userSingleton.getUsername();
        DatabaseReference myRef = database.getReference("Hoadon");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snap:snapshot.getChildren()) {
                    String key = snap.getKey();
                    Product pr = snap.child("cartItems/0/product").getValue(Product.class);
                    String emaila = snap.child("user").getValue(String.class);
                    if (email.equals(emaila) == true) {
                        huyDonButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(ChiTietDonHangActivity.this, Huy.class);
                                myRef.child(key).removeValue();
                                startActivity(intent);
                            }
                        });

                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void goBack(View view) {
        finish();
    }

    private void ShowlistSanPhamChiTiet() {
        gridView = (GridView) findViewById(R.id.lvquanao);
        UserSingleton userSingleton = UserSingleton.getInstance();
        String email = userSingleton.getUsername();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Cart");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snap:snapshot.getChildren()) {
                    String emaila = snap.child("user").getValue(String.class);
                    if( email.equals(emaila)==true) {
                        Product pr =snap.child("cartItems/0/product").getValue(Product.class);
                        Integer quan=snap.child("cartItems/0/quantity").getValue(Integer.class);
                        shoppingCart.addItem(pr,quan);

                        //Toast.makeText(getContext(), pr.getTenSP(), Toast.LENGTH_SHORT).show();
                        // arrayList.add(new ItemCart(pr,1));
                        arrayList = shoppingCart.getCartItems();
//
                    }
                }
                try {
                    adapter = new SanPhamInDatHangAdapter(ChiTietDonHangActivity.this, arrayList);
                    gridView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                    //adapter.notifyDataSetChanged();
                }
                catch (Exception e) {
                    Toast.makeText(ChiTietDonHangActivity.this, "Chua co don hang", Toast.LENGTH_SHORT).show();
                }
            }



            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}
