package com.example.xacnhan.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xacnhan.R;

public class QuanAoAdapter  extends BaseAdapter {
    Context context;
    String List[],List2[];
    int flags[];
    LayoutInflater inflter;
    public QuanAoAdapter(Context context, String[] List,String[] List2, int[] flags) {
        super();
        this.context = context;
        this.List = List;
        this.List2 = List2;
        this.flags = flags;
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
        convertView	=	inflter.inflate(R.layout.cardquanao, null);
        TextView country = (TextView) convertView.findViewById(R.id.tvao);
        TextView country2 = (TextView) convertView.findViewById(R.id.tvgia);
        ImageView icon = (ImageView) convertView.findViewById(R.id.imgao);
        country.setText(List[position]);
        country2.setText(List2[position]);
        icon.setImageResource(flags[position]);
        return convertView;
    }
}
