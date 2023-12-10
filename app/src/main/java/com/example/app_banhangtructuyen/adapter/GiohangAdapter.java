package com.example.app_banhangtructuyen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.bumptech.glide.Glide;
import com.example.app_banhangtructuyen.R;
import com.example.app_banhangtructuyen.model.ItemCart;
import com.example.app_banhangtructuyen.model.Product;
import com.example.app_banhangtructuyen.model.ShoppingCart;
import com.example.app_banhangtructuyen.model.ShoppingCartSingleton;
import com.example.app_banhangtructuyen.model.UserSingleton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DecimalFormat;
import java.util.List;

public class GiohangAdapter extends ArrayAdapter<ItemCart> {
    Integer so;
    ItemCart itemCart;
    public GiohangAdapter(Context context, List<ItemCart> itemCarts) {

        super(context,0, itemCarts);
    }
    @Override
    public View getView(int i, View view, ViewGroup parent) {
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.listitemin_giohang, parent, false);
        }
        //ánh xạ view
        itemCart = (ItemCart) getItem(i);

        // Thiết lập dữ liệu sản phẩm lên view
        TextView productName = view.findViewById(R.id.tensp);
        productName.setText(itemCart.getProduct().getTenSP());

        ImageView productImage = view.findViewById(R.id.hinhsp);
        Glide.with(getContext()).load(itemCart.getProduct().getHinhanh()).into(productImage);
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");

        TextView productPrice = view.findViewById(R.id.giasp);
        productPrice.setText(decimalFormat.format(itemCart.getProduct().getDongia())+" đ");
        TextView soluong = view.findViewById(R.id.soluong);
        soluong.setText(String.valueOf(itemCart.getQuantity()));
        SetSoLuong(view,itemCart);

        return view;
    }
    public void  SetSoLuong( View view, ItemCart cart){
        AppCompatButton btntru= view.findViewById(R.id.btntru);
        AppCompatButton btncong= view.findViewById(R.id.btncong);
        TextView soluong = view.findViewById(R.id.soluong);
        btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int newQuantity = cart.getQuantity() + 1;
                cart.setQuantity(newQuantity);
                notifyDataSetChanged();
            }
        });
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        UserSingleton userSingleton = UserSingleton.getInstance();
        String email = userSingleton.getUsername();
        DatabaseReference myRef = database.getReference("Cart");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snap:snapshot.getChildren()) {
                    String key = snap.getKey();
                    Product pr =snap.child("cartItems/0/product").getValue(Product.class);
                    String emaila = snap.child("user").getValue(String.class);
                    if( email.equals(emaila)==true && pr.getMaSP() == itemCart.getProduct().getMaSP()) {

                        btntru.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                int newQuantity = cart.getQuantity() - 1;
                                if (newQuantity > 0) {
                                    cart.setQuantity(newQuantity);
                                    notifyDataSetChanged();
                                } else {
                                    remove(cart);
                                    myRef.child(key).removeValue();
                                    notifyDataSetChanged();
                                }
                            }
                        });
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
    private Integer getValue(TextView text) {

        return Integer.parseInt(text.getText().toString());
    }
}
