package com.example.xacnhan.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xacnhan.Domain.Diachi;
import com.example.xacnhan.R;

import java.util.List;

public class DiachiAdapter extends RecyclerView.Adapter<DiachiAdapter.DiachiViewHolder>{
    private List<Diachi> mlistDiachi;
    public DiachiAdapter(List<Diachi> mlistUser) {
        this.mlistDiachi = mlistDiachi;
    }
    @NonNull
    @Override
    public DiachiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_address,parent,false);
return new DiachiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiachiViewHolder holder, int position) {
        Diachi diachi = mlistDiachi.get(position);
        if(diachi==null){
            return;
        }
        holder.imgicon1.setImageResource(diachi.getImg_icon1());
        holder.tvname.setText(diachi.getName());
        holder.tvdiachi.setText(diachi.getAddress());
        holder.imgicon2.setImageResource(diachi.getImg_icon2());
    }

    @Override
    public int getItemCount() {
        if (mlistDiachi != null) {
            return mlistDiachi.size();
        }
        return 0;

    }

    public class DiachiViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgicon1;
        private TextView tvname;
        private TextView tvdiachi;
        private ImageView imgicon2;

        public DiachiViewHolder(@NonNull View itemView) {
            super(itemView);
            imgicon1 =itemView.findViewById(R.id.img_icon1);
            tvname= itemView.findViewById(R.id.tv_name);
            tvdiachi = itemView.findViewById(R.id.tv_address);
            imgicon2=itemView.findViewById(R.id.img_icon2);

        }
    }
}
