package com.cs3773.roadrunnergrocery.Models;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    public static final Cart cart = new Cart();
    private List<ProductPair> cartItems = new ArrayList<>();

    public static Cart getInstance() {
        return cart;
    }

    public void addItem(int pid, int quantity) {
        boolean isIn = false;
        for (ProductPair pp : cartItems) {
            if (pp.getProduct().getPid() == pid) {
                isIn = true;
                pp.setQuantity(pp.getQuantity() + quantity);
            }
        }
        if (!isIn) {
            cartItems.add(new ProductPair(pid, quantity));
        }
    }

    public List<ProductPair> getItems() {
        return cartItems;
    }
}
