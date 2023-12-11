package com.example.app_banhangtructuyen.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.app_banhangtructuyen.R;
import com.example.app_banhangtructuyen.fragment.FragmentCart;
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

import java.lang.reflect.Field;
import java.text.DecimalFormat;

public class DetailActivity extends AppCompatActivity {
    AppCompatButton btncong,btntru;
    TextView soluong,dongia, tensanpham, motasanpham;
    Integer so,gia,tong;
    ImageView hinhsp;
    Product product;
    boolean isProcessing;


    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        AnhXa();
        Intent intent = getIntent();
        product =(Product)intent.getSerializableExtra("selectProduct");

        Glide.with(this).load(product.getHinhanh()).into(hinhsp);
        tensanpham.setText(product.getTenSP());
        motasanpham.setText(product.getMota());
        dongia.setText(String.valueOf(product.getDongia()));

        ActionCongTruSoLuong();
        ActionAddCart();

    }

    private void ActionAddCart() {
        AppCompatButton button = (AppCompatButton) findViewById(R.id.themvaogiohang);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserSingleton userSingleton = UserSingleton.getInstance();
                String email = userSingleton.getUsername();
                ShoppingCart shoppingCart = ShoppingCartSingleton.getInstance().getShoppingCart();
                shoppingCart.addItem(product,Integer.parseInt(soluong.getText().toString()));
                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                DatabaseReference myRef = firebaseDatabase.getReference("Cart");
             //   myRef.push().setValue(shoppingCart);
                ValueEventListener valueEventListener=
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        if(!isProcessing) {
                            isProcessing = true; // Đánh dấu là đang xử lý để tránh lặp lại

                            // Logic xử lý dữ liệu ở đây
                            int a=0;
                            for (DataSnapshot snap : snapshot.getChildren()) {
                                Product pr = snap.child("cartItems/0/product").getValue(Product.class);
                                String emaila = snap.child("user").getValue(String.class);
                                if(emaila.equals(email)==true && pr.getTenSP().equals(product.getTenSP())==true) {
                                    Toast.makeText(DetailActivity.this, "Đã tồn tại", Toast.LENGTH_SHORT).show();
                                    a=1;
                                    return;
                                }




                            }
                            if (a==0)
                            {
                                myRef.push().setValue(shoppingCart);
                                AlertDialog.Builder builder = new AlertDialog.Builder(DetailActivity.this);
                                // Gắn layout cho dialog
                                View dialogView = getLayoutInflater().inflate(R.layout.showdialog_addgiohang, null);
                                builder.setView(dialogView);
                                alertDialog = builder.create();
                                alertDialog.show();
                                int dialogDuration = 600; // milliseconds

                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        alertDialog.dismiss();
                                    }
                                }, dialogDuration);
                                return;
                            }

                            isProcessing = false; // Đánh dấu đã xử lý xong
                        }

                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }

                };
                myRef.addValueEventListener(valueEventListener);

            }

        });
    }


    private void ActionCongTruSoLuong() {
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        gia = getValue(dongia);
        btncong.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                so = getValue(soluong);
                soluong.setText(String.valueOf(so+1));
                dongia.setText(String.valueOf((so+1) * gia)+ " đ");

            }
        });
        btntru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                so = getValue(soluong) ;
                if (so != 1){
                    soluong.setText(String.valueOf(so-1));
                    dongia.setText(String.valueOf((so-1) * gia) + " đ");
                }else
                    soluong.setText(String.valueOf(so));


            }
        });
    }

    public void goBack(View view) {
        // Đóng hoạt động hiện tại và quay lại hoạt động trước đó
        finish();
    }
    private Integer getValue(TextView text) {
        return Integer.parseInt(text.getText().toString());
    }
    public void AnhXa(){
        btncong = (AppCompatButton) findViewById(R.id.btncong);
        btntru = (AppCompatButton) findViewById(R.id.btntru);
        soluong = (TextView) findViewById(R.id.soluong);
        dongia = (TextView) findViewById(R.id.txtdongia);
        tensanpham = (TextView) findViewById(R.id.tensp);
        hinhsp = (ImageView) findViewById(R.id.imghinhsp);
        motasanpham = (TextView) findViewById(R.id.txtmota);
    }

}