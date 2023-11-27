package com.example.app_banhangtructuyen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;

import com.bumptech.glide.Glide;
import com.example.app_banhangtructuyen.R;
import com.example.app_banhangtructuyen.model.ItemCart;
import com.example.app_banhangtructuyen.model.Product;
import com.example.app_banhangtructuyen.model.ShoppingCart;
import com.example.app_banhangtructuyen.model.ShoppingCartSingleton;

import java.text.DecimalFormat;
import java.util.List;

public class GiohangAdapter extends ArrayAdapter<ItemCart> {
    Integer so;
    ShoppingCart shoppingCart;
    List<ItemCart> item;
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
        shoppingCart = ShoppingCartSingleton.getInstance().getShoppingCart();
        item = shoppingCart.getCartItems();
        CheckBox checkBox = view.findViewById(R.id.ck);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    for (int i = 0; i < item.size(); i++) {
                        if (item.get(i).getProduct().getMaSP() == itemCart.getProduct().getMaSP()) {
                            item.remove(i);
                        }
                    }

                }
                else {
                    item.add(itemCart);
                }
            }
        });
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
        btntru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int newQuantity = cart.getQuantity() - 1;
                if (newQuantity > 0) {
                    cart.setQuantity(newQuantity);
                    notifyDataSetChanged();
                }else {
                    remove(cart);
                    notifyDataSetChanged();
                }
            }
        });
    }
    private Integer getValue(TextView text) {

        return Integer.parseInt(text.getText().toString());
    }
}
