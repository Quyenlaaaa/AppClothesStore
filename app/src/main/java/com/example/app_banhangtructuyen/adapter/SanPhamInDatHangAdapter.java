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

import com.example.app_banhangtructuyen.R;
import com.example.app_banhangtructuyen.model.ItemCart;
import com.example.app_banhangtructuyen.model.Product;

import java.text.DecimalFormat;
import java.util.List;

public class SanPhamInDatHangAdapter extends ArrayAdapter<Product> {
    public SanPhamInDatHangAdapter(Context context, List<Product> itemCarts) {

        super(context,0, itemCarts);
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = LayoutInflater.from(getContext()).inflate(R.layout.cardquanao, parent, false);
        ImageView anhsp = view.findViewById(R.id.imgao);
        TextView txtsl = view.findViewById(R.id.soluong);
        TextView txttensp = view.findViewById(R.id.tensanpham);
        TextView txtgiasp = view.findViewById(R.id.giasanpham);
        Product itemCart = getItem(position);

        //anhsp.setImageResource(itemCart.getHinhanh());
        txtsl.setText("1");
        txttensp.setText(itemCart.getTenSP());

        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        txtgiasp.setText(decimalFormat.format(itemCart.getDongia()));

        return view;

    }
}
