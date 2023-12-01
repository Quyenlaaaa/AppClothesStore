package com.example.app_banhangtructuyen.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.app_banhangtructuyen.R;
import com.example.app_banhangtructuyen.model.ItemCart;
import com.example.app_banhangtructuyen.model.Product;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DecimalFormat;
import java.util.List;

public class QuanlysanphamAdapter extends ArrayAdapter<Product> {
    public QuanlysanphamAdapter(Context context, List<Product> itemCarts) {

        super(context,0, itemCarts);
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Product product = getItem(position);
        view = LayoutInflater.from(getContext()).inflate(R.layout.cardadim, parent, false);
        ImageView anhsp = view.findViewById(R.id.imgao);
        TextView txtsl = view.findViewById(R.id.id);
        TextView txttensp = view.findViewById(R.id.tensp);
        Product itemCart = getItem(position);
        Glide.with(getContext()).load(product.getHinhanh()).into(anhsp);
      //  anhsp.setImageResource(itemCart.getHinhanh());
        txtsl.setText("ID:"+product.getMaSP());
        txttensp.setText(itemCart.getTenSP());
        Button btxoa = (Button) view.findViewById(R.id.buttonxoas);
        btxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Sanpham");
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot snap: snapshot.getChildren())
                        {
                            String tensp=snap.child("tenSP").getValue(String.class);
                           if(tensp.equals(product.getTenSP())==true)
                           {
                                reference.child(snap.getKey()).removeValue();
                                Toast.makeText(getContext(), "Xoa thanh cong", Toast.LENGTH_SHORT).show();
                        }
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
              //  Toast.makeText(getContext(), "Hellllo", Toast.LENGTH_SHORT).show();
            }
        });

        return view;

    }
}
