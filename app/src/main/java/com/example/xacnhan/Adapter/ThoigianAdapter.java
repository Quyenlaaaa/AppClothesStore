package com.example.xacnhan.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xacnhan.Domain.Thoigian;
import com.example.xacnhan.R;

import java.util.List;


public class ThoigianAdapter extends RecyclerView.Adapter<ThoigianAdapter.ThoigianViewHolder> {


    private List<Thoigian> mListThoigian;
    public ThoigianAdapter(List<Thoigian> mListThoigian) {
        this.mListThoigian = mListThoigian;
    }

    @NonNull
    @Override
    public ThoigianViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_thoigian,parent,false);
        return new ThoigianViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ThoigianViewHolder holder, int position) {
        Thoigian thoigian = mListThoigian.get(position);
        if(thoigian==null){
            return;
        }
        holder.imgicon.setImageResource(thoigian.getIcon());
        holder.tvTitile.setText(thoigian.getTitile());
        holder.tvTime.setText(thoigian.getTime());
    }

    @Override
    public int getItemCount() {
        if (mListThoigian != null) {
            return mListThoigian.size();
        }
        return 0;
    }

    public class ThoigianViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgicon;
        private TextView tvTitile;
        private TextView tvTime;

        public ThoigianViewHolder(@NonNull View itemView) {
            super(itemView);
            imgicon = itemView.findViewById(R.id.icon_time);
            tvTitile = itemView.findViewById(R.id.tv_title);
            tvTime = itemView.findViewById(R.id.tvtime);
        }
    }

}
