package com.bakery.model;

public abstract class BakeryItem {
    protected String name;
    protected double price;
    protected int preparationTime;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getPreparationTime() {
        return preparationTime;
    }
}
