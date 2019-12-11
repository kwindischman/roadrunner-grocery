package com.cs3773.roadrunnergrocery.Models;

import java.util.ArrayList;
import java.util.List;

public class ProductBase {
    private final List<Product> productBase;

    public ProductBase() {
        List<Product> productBase = new ArrayList<>();

        productBase.add(new Product("Granny Smith apple", "A sour green apple", 0.39, 0, "@drawable/granny_smith", "Produce"));
        productBase.add(new Product("Red Delicious apple", "A crisp red apple", 0.44, 1, "@drawable/red_delicious", "Produce"));
        productBase.add(new Product("Gala apple", "A sweet red apple", 0.49, 2, "@drawable/gala", "Produce"));
        productBase.add(new Product("Tomato", "", 0.25, 3, "@drawable/tomato", "Produce"));
        productBase.add(new Product("Onion", "", 0.20, 4, "@drawable/onion", "Produce"));
        productBase.add(new Product("Carrot", "", 0.39, 5, "@drawable/carrot", "Produce"));
        productBase.add(new Product("Avocado", "", 1.49, 6, "@drawable/avocado", "Produce"));
        productBase.add(new Product("Lettuce", "", 0.19, 7, "@drawable/lettuce", "Produce"));
        productBase.add(new Product("Ham", "", 8.99, 8, "@drawable/ham", "Meat"));
        productBase.add(new Product("Chicken", "", 9.99, 9, "@drawable/chicken", "Meat"));
        productBase.add(new Product("Steak", "", 11.99, 10, "@drawable/steak", "Meat"));
        productBase.add(new Product("Turkey", "", 9.99, 11, "@drawable/turkey", "Meat"));
        productBase.add(new Product("Fish", "", 14.99, 12, "@drawable/fish", "Meat"));
        productBase.add(new Product("Chocolate", "", 1.99, 13, "@drawable/chocolate", "Snacks"));
        productBase.add(new Product("Popcorn", "", 3.99, 14, "@drawable/popcorn", "Snacks"));
        productBase.add(new Product("Jerky", "", 7.99, 15, "@drawable/jerky", "Snacks"));
        productBase.add(new Product("Pretzels", "", 4.99, 16, "@drawable/pretzels", "Snacks"));
        productBase.add(new Product("Chips", "", 4.99, 17, "@drawable/chips", "Snacks"));
        productBase.add(new Product("Crackers", "", 2.99, 18, "@drawable/crackers", "Snacks"));
        productBase.add(new Product("fruit gummy", "", 0.99, 19, "@drawable/fruit_gummy", "Snacks"));
        productBase.add(new Product("Mixed Nuts", "", 5.99, 20, "@drawable/mixed_nuts", "Snacks"));
        productBase.add(new Product("Pizza", "", 6.99, 21, "@drawable/pizza", "Frozen"));
        productBase.add(new Product("Chicken Tendies", "", 7.99, 22, "@drawable/chicken_tendies", "Frozen"));
        productBase.add(new Product("Lasagna", "", 9.99, 23, "@drawable/lasagna", "Frozen"));
        productBase.add(new Product("Mixed Vegetables", "", 2.99, 24, "@drawable/mixed_vegetables", "Frozen"));
        productBase.add(new Product("Dino Nuggies", "", 4.49, 25, "@drawable/dino_nuggies", "Frozen"));
        productBase.add(new Product("Breakfast Sandwich", "", 1.99, 26, "@drawable/breakfast_sandwich", "Frozen"));
        productBase.add(new Product("Fries", "", 2.99, 27, "@drawable/fries",  "Frozen"));
        productBase.add(new Product("Water", "", 1.99, 28, "@drawable/water"));
        productBase.add(new Product("Soda", "", 2.99, 29, "@drawable/soda"));
        productBase.add(new Product("Coffee", "", 3.49, 30, "@drawable/coffee"));
        productBase.add(new Product("Tea", "", 3.49, 31, "@drawable/tea"));
        productBase.add(new Product("Cereal", "", 1.99, 32, "@drawable/cereal"));
        productBase.add(new Product("Lunchable", "", 2.29, 33, "@drawable/lunchable", "Snacks"));
        productBase.add(new Product("Apple Juice", "", 2.39, 34, "@drawable/apple_juice"));
        productBase.add(new Product("Eggs", "", 2.89, 35, "@drawable/eggs"));
        productBase.add(new Product("Milk", "", 2.99, 36, "@drawable/milk"));
        productBase.add(new Product("Butter", "", 1.49, 37, "@drawable/butter"));
        productBase.add(new Product("Yogurt", "", 1.19, 38, "@drawable/yogurt"));
        productBase.add(new Product("Cheese", "", 2.39, 39, "@drawable/cheese"));
        productBase.add(new Product("Candy Canes", "", 1.79, 40, "@drawable/candy_cane"));
        productBase.add(new Product("Pie", "", 3.14, 41, "@drawable/pie"));

        this.productBase = productBase;
    }

    public List<Product> getProductBase() {
        return productBase;
    }

    public Product getProduct(int pid) {
        for (int i = 0; i < productBase.size(); i++) {
            if (productBase.get(i).getPid() == pid) {
                return productBase.get(i);
            }
        }
        return productBase.get(0);
    }
}
