package com.example.app_banhangtructuyen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;

import com.example.app_banhangtructuyen.R;
import com.example.app_banhangtructuyen.model.Product;

import java.text.DecimalFormat;
import java.util.List;

public class GiohangAdapter extends ArrayAdapter<Product> {
    Integer so;
    public GiohangAdapter(Context context, List<Product> products) {

        super(context,0, products);
    }
    @Override
    public View getView(int i, View view, ViewGroup parent) {
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.listitemin_giohang, parent, false);
        }
        //ánh xạ view
        Product product = (Product) getItem(i);

        // Thiết lập dữ liệu sản phẩm lên view
        TextView productName = view.findViewById(R.id.tensp);
        productName.setText(product.getTenSP());

        ImageView productImage = view.findViewById(R.id.hinhsp);
        //productImage.setImageResource(product.getHinhanh());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");

        TextView productPrice = view.findViewById(R.id.giasp);
        productPrice.setText(decimalFormat.format(product.getDongia())+" $");

        SetSoLuong(view);

        return view;
    }
    public void  SetSoLuong( View view){
        AppCompatButton btntru= view.findViewById(R.id.btntru);
        AppCompatButton btncong= view.findViewById(R.id.btncong);
        TextView soluong = view.findViewById(R.id.soluong);
        btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                so = getValue(soluong);
                soluong.setText(String.valueOf(so+1));
            }
        });
        btntru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                so = getValue(soluong);
                if (so != 1){
                    soluong.setText(String.valueOf(so-1));
                }else
                    soluong.setText(String.valueOf(so));
            }
        });
    }
    private Integer getValue(TextView text) {

        return Integer.parseInt(text.getText().toString());
    }
}
