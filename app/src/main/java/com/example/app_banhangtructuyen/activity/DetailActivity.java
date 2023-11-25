package com.example.app_banhangtructuyen.activity;

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

import com.bumptech.glide.Glide;
import com.example.app_banhangtructuyen.R;
import com.example.app_banhangtructuyen.fragment.FragmentCart;
import com.example.app_banhangtructuyen.model.Product;

import java.lang.reflect.Field;
import java.text.DecimalFormat;

public class DetailActivity extends AppCompatActivity {
    AppCompatButton btncong,btntru;
    TextView soluong,dongia, tensanpham, motasanpham;
    Integer so,gia,tong;
    ImageView hinhsp;

    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        AnhXa();
        Intent intent = getIntent();
        Product product =(Product)intent.getSerializableExtra("selectProduct");

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