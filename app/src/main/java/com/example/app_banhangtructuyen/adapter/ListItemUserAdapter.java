package com.example.app_banhangtructuyen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.app_banhangtructuyen.R;

import java.util.List;

public class ListItemUserAdapter extends BaseAdapter {
    Context context;
    String List[];
    int flags[];
    LayoutInflater inflter;
    public ListItemUserAdapter(Context context, String[] List, int[] flags) {
        super();
        this.context = context;
        this.List = List;
        this.flags = flags;
        inflter	= (LayoutInflater.from(context));
    }
    @Override
    public int getCount() {
        return List.length;
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
        view	=	inflter.inflate(R.layout.listoptionlayout_user, null);
        TextView country = (TextView) view.findViewById(R.id.textView);
        ImageView icon = (ImageView) view.findViewById(R.id.icon);
        country.setText(List[i]);
        icon.setImageResource(flags[i]);
        return view;
    }
}
