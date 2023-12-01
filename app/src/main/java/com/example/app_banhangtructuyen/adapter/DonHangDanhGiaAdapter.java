package com.example.app_banhangtructuyen.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.app_banhangtructuyen.R;
import com.example.app_banhangtructuyen.model.DonHangDanhGia;

import java.util.ArrayList;
import java.util.List;

public class DonHangDanhGiaAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<DonHangDanhGia> dadatList;
    public DonHangDanhGiaAdapter(Context context, int layout, ArrayList<DonHangDanhGia> dadatList) {
        this.context = context;
        this.layout = layout;
        this.dadatList = dadatList;
    }

    @Override
    public int getCount() {
        return dadatList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);
        //ánh xạ view
        TextView xacnhan = (TextView) view.findViewById(R.id.hoanthanh);
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

        //gán giá trị
        DonHangDanhGia daDat = dadatList.get(i);
        xacnhan.setText(daDat.getXacnhan());
        madon.setText(daDat.getMadon());
        thoigian.setText(daDat.getThoigian());
        txtImage.setImageResource(daDat.getHinhanh());
        tensp.setText(daDat.getTensp());
        diachi.setText(daDat.getDiachi());
        icon.setImageResource(daDat.getIcon());
        gia.setText(daDat.getGia());
        montienmat.setText(daDat.getMontienmat());
        danhgia.callOnClick();
        datlai.callOnClick();
        return view;
    }

}
