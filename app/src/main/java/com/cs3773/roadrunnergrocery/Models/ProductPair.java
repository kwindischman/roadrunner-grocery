package com.cs3773.roadrunnergrocery.Models;

// The point of this class is to hold a product and quantity for Cart and Order
public class ProductPair {

    // Class Variables here
    private int quantity;
    private Product product;

    // Constructor(s) here
    public ProductPair(int pid) {
        ProductBase productBase = new ProductBase();

        this.product = productBase.getProduct(pid);
        quantity = 0;
    }

    // Methods here
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int mQuantity) {
        this.quantity = mQuantity;
    }

    public Product getProduct() {
        return product;
    }
}
