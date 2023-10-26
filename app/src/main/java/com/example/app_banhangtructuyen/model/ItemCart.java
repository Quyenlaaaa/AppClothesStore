package com.example.app_banhangtructuyen.model;

public class ItemCart {
    private Product product;
    private Integer slmua;

    public ItemCart(Product product, Integer slmua) {
        this.product = product;
        this.slmua = slmua;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getSlmua() {
        return slmua;
    }

    public void setSlmua(Integer slmua) {
        this.slmua = slmua;
    }
}
