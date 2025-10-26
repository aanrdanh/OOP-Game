package com.farmgame.entities.animals;

public class Chicken extends Animal {
    public Chicken() {
        super("Chicken");
    }

    @Override
    public String productName() {
        return "Egg";
    }

    @Override
    public int productPrice() {
        return 8;
    }
}
