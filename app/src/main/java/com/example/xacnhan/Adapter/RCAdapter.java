package com.example.xacnhan.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.xacnhan.Domain.QuanAo;
import com.example.xacnhan.R;

import java.util.List;

public class RCAdapter extends RecyclerView.Adapter<RCAdapter.ViewHolder> {

    private List<QuanAo> items;

    public RCAdapter(List<QuanAo> items) {
        this.items = items;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Tạo một view holder mới
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardthem ,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Lấy dữ liệu của item tại vị trí position
        QuanAo item = items.get(position);


        // Set dữ liệu cho view holder
        holder.ten.setText(item.getTen());
        holder.gia.setText(item.getGia());
        holder.img.setImageResource(item.getFlags());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView ten;
        public TextView gia;
        public ImageView img;


        public ViewHolder(View view) {
            super(view);
           ten = view.findViewById(R.id.tvao2);
            gia = view.findViewById(R.id.tvgia2);
            img=view.findViewById(R.id.imgao2);
        }
    }
}

