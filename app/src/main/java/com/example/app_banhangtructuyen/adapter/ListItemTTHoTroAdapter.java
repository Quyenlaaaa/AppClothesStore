package com.example.app_banhangtructuyen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.app_banhangtructuyen.R;

public class ListItemTTHoTroAdapter extends BaseAdapter{
    Context context;
    String List[];
    int flags[];
    LayoutInflater inflter;
    public ListItemTTHoTroAdapter(Context context, String[] List, int[] flags) {
        super();
        this.context = context;
        this.List = List;
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
        convertView	=	inflter.inflate(R.layout.customlist_tthoto, null);
        TextView country = (TextView) convertView.findViewById(R.id.textView);
        ImageView icon = (ImageView) convertView.findViewById(R.id.icon);
        country.setText(List[position]);
        icon.setImageResource(flags[position]);
        return convertView;
    }
}