package com.example.app_banhangtructuyen.model;

import android.widget.Toast;

import com.example.app_banhangtructuyen.activity.DetailActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart implements Serializable {
    private ArrayList<ItemCart> cartItems;
    public ShoppingCart() {
        cartItems = new ArrayList<>();
    }

    public void addItem(Product product, int quantity) {
        // Kiểm tra xem sản phẩm đã tồn tại trong giỏ hàng chưa
        cartItems.clear();

        // Nếu chưa tồn tại, thêm mới vào giỏ hàng
        cartItems.add(new ItemCart(product,quantity));
    }
    public void addItem2(Product product, int quantity) {
        // Kiểm tra xem sản phẩm đã tồn tại trong giỏ hàng chưa
        for (ItemCart item : cartItems) {
            if (item.getProduct().getMaSP() == product.getMaSP()) {
                // Nếu đã tồn tại, tăng số lượng lên
                //item.incrementQuantity();
                return;
            }
        }

        // Nếu chưa tồn tại, thêm mới vào giỏ hàng
        cartItems.add(new ItemCart(product,quantity));
    }
    public double getCountItemCart(){
        double tongtien=0;
        for (ItemCart item : cartItems){
            tongtien += item.getQuantity() * item.getProduct().getDongia();
        }
        return tongtien;
    }
    public double getCountItemCart2(){
        double tongtien=15000;
        for (ItemCart item : cartItems){
            tongtien += item.getQuantity() * item.getProduct().getDongia();
        }
        return tongtien;
    }
    public String getUser ()
    {
        UserSingleton userSingleton = UserSingleton.getInstance();
        return  userSingleton.getUsername();
    }

    public ArrayList<ItemCart> getCartItems() {
        return cartItems;
    }
}
