package com.example.app_banhangtructuyen.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.app_banhangtructuyen.R;
import com.example.app_banhangtructuyen.model.Product;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class SanphamAdapter extends ArrayAdapter<Product> {
    public SanphamAdapter(Context context, List<Product> products) {

        super(context,0, products);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.view_sanpham, parent, false);

        // Lấy dữ liệu sản phẩm tại vị trí position
        Product product = getItem(position);

        // Thiết lập dữ liệu sản phẩm lên view
        TextView productName = convertView.findViewById(R.id.txttensp);
        productName.setText(product.getTenSP());

        ImageView productImage = convertView.findViewById(R.id.imgsp);
        Glide.with(getContext()).load(product.getHinhanh()).into(productImage);
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");

        TextView productPrice = convertView.findViewById(R.id.txtgiasp);
        productPrice.setText(decimalFormat.format(product.getDongia())+" đ");

        return convertView;
    }

}
