package com.farmgame.entities.crops;

import java.io.Serializable;

public abstract class Crop implements Serializable {
    protected int growth;       // days grown
    protected final int growDays; // days to harvest
    protected final int seedCost;
    protected final int sellPrice;
    protected String name;

    protected Crop(String name, int growDays, int seedCost, int sellPrice) {
        this.name = name;
        this.growDays = growDays;
        this.seedCost = seedCost;
        this.sellPrice = sellPrice;
        this.growth = 0;
    }

    public void growOneDay() {
        growth++;
    }

    public boolean isReady() {
        return growth >= growDays;
    }

    public String getName() { return name; }
    public int getSeedCost() { return seedCost; }
    public int getSellPrice() { return sellPrice; }

    @Override
    public String toString() {
        return name + " (" + growth + "/" + growDays + ")";
    }
}
