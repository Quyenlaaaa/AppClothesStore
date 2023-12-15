package com.example.app_banhangtructuyen.model;

public class ShoppingCartSingleton {
    private static ShoppingCartSingleton instance;
    private ShoppingCart shoppingCart;

    private ShoppingCartSingleton() {
        shoppingCart = new ShoppingCart();
    }

    public static synchronized ShoppingCartSingleton getInstance() {
        if (instance == null) {
            instance = new ShoppingCartSingleton();
        }
        return instance;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }
}
