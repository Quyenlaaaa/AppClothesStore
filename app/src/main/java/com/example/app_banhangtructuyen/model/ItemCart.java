package com.example.app_banhangtructuyen.model;

public class ItemCart {
    private Product product;
    private int quantity;

    public ItemCart(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity; // Số lượng mặc định là 1 khi thêm mới vào giỏ hàng
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void incrementQuantity() {
        quantity++;
    }

}
