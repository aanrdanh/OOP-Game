package com.farmgame.entities.animals;

public class Cow extends Animal {
    public Cow() {
        super("Cow");
    }

    @Override
    public String productName() {
        return "Milk";
    }

    @Override
    public int productPrice() {
        return 18;
    }
}
