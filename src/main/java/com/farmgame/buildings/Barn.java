package com.farmgame.buildings;

import com.farmgame.entities.animals.Animal;
import com.farmgame.entities.animals.Chicken;
import com.farmgame.entities.animals.Cow;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Barn implements Serializable {
    private final List<Animal> animals = new ArrayList<>();

    public Barn() {
        animals.add(new Cow());
        animals.add(new Chicken());
    }

    public void nextDay() {
        for (Animal a : animals) a.nextDay();
    }

    public void feedAll() {
        for (Animal a : animals) a.feed();
    }

    public int collectProducts() {
        int gold = 0;
        for (Animal a : animals) {
            if (a.collectProduct()) {
                gold += a.productPrice();
            }
        }
        if (gold > 0) System.out.println("Collected products. +" + gold + " gold.");
        else System.out.println("No products to collect.");
        return gold;
    }

    public void buy(String type) {
        switch (type) {
            case "COW" -> animals.add(new Cow());
            case "CHICKEN" -> animals.add(new Chicken());
        }
        System.out.println("Bought " + type + ".");
    }

    public int size() { return animals.size(); }

    @Override
    public String toString() {
        return "Barn{animals=" + animals + "}";
    }
}
