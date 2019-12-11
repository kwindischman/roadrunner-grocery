package com.cs3773.roadrunnergrocery.Models;

public class Product {

    // Class Variables here
    private String name;
    private String description;
    private String imageURL;
    private double price;
    private int pid;
    private String tag = "";

    // Constructor(s) here
    public Product(String name, String description, double price, int pid, String imageURL) {
        this.name = name;
        this.description = description;
        this.imageURL = imageURL;
        this.price = price;
        this.pid = pid;
    }

    public Product(String name, String description, double price, int pid, String imageURL, String tag) {
        this.name = name;
        this.description = description;
        this.imageURL = imageURL;
        this.price = price;
        this.pid = pid;
        this.tag = tag;
    }

    public Product(String name, String description, double price, int pid) {
        this(name, description, price, pid, "@drawable/placeholder_image.webp");
    }


    // Methods here
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
