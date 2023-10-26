package com.example.app_banhangtructuyen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.app_banhangtructuyen.R;

public class HosoAdapter extends BaseAdapter {

    Context context;
    String List[];

    LayoutInflater inflter;
    public HosoAdapter(Context context, String[] List, int[] flags) {
        super();
        this.context = context;
        this.List = List;

        inflter	= (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return List.length;
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        // TODO Auto-generated method stub
        view	=	inflter.inflate(R.layout.listhoso,null);
        TextView country = (TextView) view.findViewById(R.id.tieude);
        country.setText(List[position]);
        return view;
    }
}
