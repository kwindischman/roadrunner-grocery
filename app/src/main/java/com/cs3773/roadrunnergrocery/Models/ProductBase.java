package com.cs3773.roadrunnergrocery.Models;

import java.util.ArrayList;
import java.util.List;

public class ProductBase {
    private final List<Product> productBase;

    public ProductBase() {
        List<Product> productBase = new ArrayList<>();

        productBase.add(new Product("Granny Smith apple", "A sour green apple", 0.39, 0));
        productBase.add(new Product("Red Delicious apple", "A crisp red apple", 0.44, 1));
        productBase.add(new Product("Gala apple", "A sweet red apple", 0.49, 2));
        productBase.add(new Product("Tomato", "", 0.25, 3));
        productBase.add(new Product("Onion", "", 0.20, 4));
        productBase.add(new Product("Carrot", "", 0.39, 5));
        productBase.add(new Product("Avocado", "", 1.49, 6));
        productBase.add(new Product("Lettuce", "", 0.19, 7));
        productBase.add(new Product("Ham", "", 8.99, 8));
        productBase.add(new Product("Chicken", "", 9.99, 9));
        productBase.add(new Product("Steak", "", 11.99, 10));
        productBase.add(new Product("Turkey", "", 9.99, 11));
        productBase.add(new Product("Fish", "", 14.99, 12));
        productBase.add(new Product("Chocolate", "", 1.99, 13));
        productBase.add(new Product("Popcorn", "", 3.99, 14));
        productBase.add(new Product("Jerky", "", 7.99, 15));
        productBase.add(new Product("Pretzels", "", 4.99, 16));
        productBase.add(new Product("Chips", "", 4.99, 17));
        productBase.add(new Product("Crackers", "", 2.99, 18));
        productBase.add(new Product("fruit gummy", "", 0.99, 19));
        productBase.add(new Product("Mixed Nuts", "", 5.99, 20));
        productBase.add(new Product("Pizza", "", 6.99, 21));
        productBase.add(new Product("Chicken Tendies", "", 7.99, 22));
        productBase.add(new Product("Lasagna", "", 9.99, 23));
        productBase.add(new Product("Mixed Vegetables", "", 2.99, 24));
        productBase.add(new Product("Dino Nuggies", "", 4.49, 25));
        productBase.add(new Product("Breakfast Sandwich", "", 1.99, 26));
        productBase.add(new Product("Fries", "", 2.99, 27));
        productBase.add(new Product("Water", "", 1.99, 28));
        productBase.add(new Product("Soda", "", 2.99, 29));
        productBase.add(new Product("Coffee", "", 3.49, 30));
        productBase.add(new Product("Tea", "", 3.49, 31));
        productBase.add(new Product("Cereal", "", 1.99, 32));
        productBase.add(new Product("Lunchable", "", 2.29, 33));
        productBase.add(new Product("Apple Juice", "", 2.39, 34));
        productBase.add(new Product("Eggs", "", 2.89, 35));
        productBase.add(new Product("Milk", "", 2.99, 36));
        productBase.add(new Product("Butter", "", 1.49, 37));
        productBase.add(new Product("Yogurt", "", 1.19, 38));
        productBase.add(new Product("Cheese", "", 2.39, 39));
        productBase.add(new Product("Candy Canes", "", 1.79, 40));
        productBase.add(new Product("Pie", "", 3.14, 41));

        this.productBase = productBase;
    }

    public List<Product> getProductBase() {
        return productBase;
    }
}
