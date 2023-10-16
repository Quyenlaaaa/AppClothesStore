package com.example.appbanquanao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NgonguAdapter extends BaseAdapter{
    Context context;
    String List[];

    LayoutInflater inflter;
    public NgonguAdapter(Context context, String[] List, int[] flags) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        convertView	=	inflter.inflate(R.layout.ngongu, null);
        TextView country = (TextView) convertView.findViewById(R.id.tvnn);
        country.setText(List[position]);
        return convertView;
    }
}