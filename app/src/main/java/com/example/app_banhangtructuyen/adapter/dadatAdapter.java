package com.example.app_banhangtructuyen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.app_banhangtructuyen.R;
import com.example.app_banhangtructuyen.model.Product;

import java.util.ArrayList;
import java.util.List;

public class dadatAdapter extends ArrayAdapter<Product> {
    private Context context;

    public dadatAdapter(Context context, ArrayList<Product> dadatList) {
        super(context,0, dadatList);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(getContext()).inflate(R.layout.dsdhcuatoi, viewGroup, false);
        //ánh xạ view
        TextView xacnhan = (TextView) view.findViewById(com.example.app_banhangtructuyen.R.id.hoanthanh);
        TextView madon = (TextView) view.findViewById(R.id.madon);
        TextView thoigian = (TextView) view.findViewById(R.id.ngay) ;
        ImageView txtImage = (ImageView) view.findViewById(R.id.anh6);
        TextView tensp = (TextView) view.findViewById(R.id.tsp);
        TextView diachi = (TextView) view.findViewById(R.id.diachi) ;
        ImageView icon = (ImageView) view.findViewById(R.id.circle);
        TextView gia = (TextView) view.findViewById(R.id.gia) ;
        TextView montienmat = (TextView) view.findViewById(R.id.gido) ;
        Button danhgia = (Button) view.findViewById(R.id.danhgia);
        Button datlai = (Button) view.findViewById(R.id.datlai);

        Product product = getItem(i);
        madon.setText(product.IDsanpham);
        //gán giá trị
        return view;
    }
}
