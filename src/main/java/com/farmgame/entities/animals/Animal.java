package com.farmgame.entities.animals;

import java.io.Serializable;

public abstract class Animal implements Serializable {
    protected String name;
    protected int hunger; // 0 is full, increases each day
    protected boolean hasProduct; // milk/egg to collect

    protected Animal(String name) {
        this.name = name;
        this.hunger = 0;
        this.hasProduct = false;
    }

    public void nextDay() {
        hunger++;
        if (hunger <= 1) {
            hasProduct = true;
        } else {
            hasProduct = false;
        }
    }

    public void feed() {
        hunger = Math.max(0, hunger - 2);
        System.out.println(name + " has been fed.");
    }

    public boolean collectProduct() {
        if (hasProduct) {
            hasProduct = false;
            return true;
        }
        return false;
    }

    public abstract String productName();
    public abstract int productPrice();

    @Override
    public String toString() {
        return name + " (Hunger: " + hunger + ", Has product: " + hasProduct + ")";
    }
}
