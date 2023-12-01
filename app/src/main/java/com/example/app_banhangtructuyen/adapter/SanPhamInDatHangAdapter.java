package com.example.app_banhangtructuyen.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.app_banhangtructuyen.R;
import com.example.app_banhangtructuyen.model.ItemCart;
import com.example.app_banhangtructuyen.model.Product;

import java.text.DecimalFormat;
import java.util.List;

public class SanPhamInDatHangAdapter extends ArrayAdapter<ItemCart> {
    ItemCart itemCart;
    public SanPhamInDatHangAdapter(Context context, List<ItemCart> itemCarts) {

        super(context,0, itemCarts);
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.cardquanao, parent, false);
        }
        itemCart = (ItemCart) getItem(position);
        ImageView anhsp = view.findViewById(R.id.imgao);
        Glide.with(getContext()).load(itemCart.getProduct().getHinhanh()).into(anhsp);
        TextView txtsl = view.findViewById(R.id.soluong);
        txtsl.setText(String.valueOf(itemCart.getQuantity()));
        TextView txttensp = view.findViewById(R.id.tensanpham);
        txttensp.setText(itemCart.getProduct().getTenSP());
        TextView txtgiasp = view.findViewById(R.id.giasanpham);

        //anhsp.setImageResource(itemCart.getHinhanh());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        txtgiasp.setText(decimalFormat.format(itemCart.getProduct().getDongia())+" đ");

        return view;

    }
}
