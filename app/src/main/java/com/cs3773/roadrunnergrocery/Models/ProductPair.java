package com.cs3773.roadrunnergrocery.Models;

// The point of this class is to hold a product and quantity for Cart and Order
public class ProductPair {

    // Class Variables here

    // Constructor(s) here

    public ProductPair(int pid, int quantity) {
        ProductBase productBase = new ProductBase();

        this.product = productBase.getProduct(pid);
        this.quantity = quantity;
    }

    // Methods here

}
