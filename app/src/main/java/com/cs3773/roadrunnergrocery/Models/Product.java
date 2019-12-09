package com.cs3773.roadrunnergrocery.Models;

public class Product {

    // Class Variables here
    private String name;
    private String description;
    private double price;
    private int pid;

    // Constructor(s) here
    public Product(String name, String description, double price, int pid) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.pid = pid;
    }


    // Methods here
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
}
