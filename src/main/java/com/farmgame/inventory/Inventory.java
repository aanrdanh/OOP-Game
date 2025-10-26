package com.farmgame.inventory;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class Inventory implements Serializable {
    private final Map<String, Item> items = new LinkedHashMap<>();

    public void add(String name, int q) {
        items.computeIfAbsent(name, k -> new Item(k, 0)).add(q);
    }

    public boolean use(String name, int q) {
        Item it = items.get(name);
        if (it == null) return false;
        return it.remove(q);
    }

    public int count(String name) {
        Item it = items.get(name);
        return it == null ? 0 : it.getQuantity();
    }

    @Override
    public String toString() {
        return "Inventory" + items.values();
    }
}
