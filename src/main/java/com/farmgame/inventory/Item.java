package com.farmgame.inventory;

import java.io.Serializable;

public class Item implements Serializable {
    private final String name;
    private int quantity;

    public Item(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public void add(int q) { quantity += q; }
    public boolean remove(int q) {
        if (quantity >= q) { quantity -= q; return true; }
        return false;
    }

    @Override
    public String toString() { return name + " x" + quantity; }
}
