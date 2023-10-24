package com.example.taolao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class GiohangAdapter extends BaseAdapter {
    private Context context;
        private int layout;
        private List<giohang> giohangList;

    public GiohangAdapter(Context context, int layout, List<giohang> giohangList) {
        this.context = context;
        this.layout = layout;
        this.giohangList = giohangList;
    }

    @Override
    public int getCount() {
        return giohangList.size();
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
        TextView txtTen = (TextView) view.findViewById(R.id.spten);
        TextView txtGia = (TextView) view.findViewById(R.id.gia);
        CheckBox txtCheck = (CheckBox) view.findViewById(R.id.checkbox);
        ImageView txtImage = (ImageView) view.findViewById(R.id.pc);
        ImageView txtIcon = (ImageView) view.findViewById(R.id.dollar);
        Button btnTru = (Button) view.findViewById(R.id.tru);
        Button btnCong = (Button) view.findViewById(R.id.cong);
        TextView txtSL = (TextView) view.findViewById(R.id.slg);

        //gán giá trị
        giohang gioHang = giohangList.get(i);
        txtTen.setText(gioHang.getTensp());
        txtGia.setText(gioHang.getGia());
        txtImage.setImageResource(gioHang.getHinhanh());
        txtIcon.setImageResource(gioHang.getIcon());
        txtCheck.isChecked();
        btnTru.callOnClick();
        btnCong.callOnClick();
        return view;
    }
}
