package com.example.xacnhan.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.xacnhan.Activity.Activity_Suadiachi1;
import com.example.xacnhan.R;
import com.example.xacnhan.Domain.Xacnhan;

import java.util.List;

public class XacnhanAdapter extends RecyclerView.Adapter<XacnhanAdapter.XacnhanViewHolder> {
    private List<Xacnhan> mListXacnhan;
    private Context mContext;

    public XacnhanAdapter(Context context, List<Xacnhan> mListXacnhan) {
        this.mContext = context;
        this.mListXacnhan = mListXacnhan;
    }

    @NonNull
    @Override
    public XacnhanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_diachi,parent,false);
        return new XacnhanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull XacnhanViewHolder holder, int position) {
        final Xacnhan xacnhan = mListXacnhan.get(position);
        if(xacnhan==null){
            return;
        }
        holder.imgicon.setImageResource(xacnhan.getIcon());
        holder.tvTitle.setText(xacnhan.getTitile());
        holder.tvaddress.setText(xacnhan.getAddress());
        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickGotoSuadiachi(xacnhan);
            }

            private void onClickGotoSuadiachi(Xacnhan xacnhan) {
                Intent intent = new Intent(mContext, Activity_Suadiachi1.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("object_xacnhan", xacnhan);
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mListXacnhan!=null){
            return mListXacnhan.size();
        }
        return 0;
    }

    public class XacnhanViewHolder extends RecyclerView.ViewHolder{
        private RelativeLayout layoutItem;
        private ImageView imgicon;
        private TextView tvTitle;
        private TextView tvinfo;
        private TextView tvaddress;

        public XacnhanViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutItem = itemView.findViewById(R.id.layout_item);
            imgicon = itemView.findViewById(R.id.icon_location);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvinfo = itemView.findViewById(R.id.tv_info_user);
            tvaddress = itemView.findViewById(R.id.tv_address);
        }
    }

}
