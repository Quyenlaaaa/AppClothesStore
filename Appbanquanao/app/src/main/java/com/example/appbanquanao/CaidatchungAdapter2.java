package com.example.appbanquanao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CaidatchungAdapter2 extends BaseAdapter{
    Context context;
    String List[];

    LayoutInflater inflter;
    public CaidatchungAdapter2(Context context, String[] List ) {
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
        convertView	=	inflter.inflate(R.layout.caidatchung2, null);
        TextView country = (TextView) convertView.findViewById(R.id.textView);
        country.setText(List[position]);
        return convertView;
    }
}