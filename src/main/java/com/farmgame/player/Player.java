package com.farmgame.player;

import com.farmgame.buildings.Barn;
import com.farmgame.buildings.Field;
import com.farmgame.core.World;
import com.farmgame.inventory.Inventory;

import java.io.Serializable;

public class Player implements Serializable {
    private final String name;
    private int gold = 100;
    private final Field field = new Field();
    private final Barn barn = new Barn();
    private final Inventory inventory = new Inventory();

    public Player(String name) {
        this.name = name;
        inventory.add("WHEAT_SEED", 5);
        inventory.add("CORN_SEED", 3);
        inventory.add("FEED", 5);
    }

    public String getName() { return name; }
    public int getGold() { return gold; }
    public void addGold(int g) { gold += g; }
    public boolean spendGold(int g) { if (gold >= g) { gold -= g; return true; } return false; }

    public void nextDay(World world) {
        int ready = field.growAndHarvestableCount();
        barn.nextDay();
        if (ready > 0) {
            System.out.println(ready + " crop(s) are ready to harvest!");
        }
    }

    public void plant(String type) {
        String seed = switch (type) {
            case "WHEAT" -> "WHEAT_SEED";
            case "CORN" -> "CORN_SEED";
            default -> "";
        };
        int have = inventory.count(seed);
        if (have <= 0) {
            System.out.println("No seeds left. Buy more at the market.");
            return;
        }
        inventory.use(seed, 1);
        field.plant(type, 1);
    }

    public void harvest() {
        int income = field.harvestAllReady();
        addGold(income);
    }

    public void feedAnimals() {
        if (inventory.use("FEED", 1)) {
            barn.feedAll();
        } else {
            System.out.println("No animal feed left. Buy some at the market.");
        }
    }

    public void collectAnimalProducts() {
        int income = barn.collectProducts();
        addGold(income);
    }

    public Field getField() { return field; }
    public Barn getBarn() { return barn; }
    public Inventory getInventory() { return inventory; }

    public void printStatus() {
        System.out.println("=== FARM STATUS ===");
        System.out.println("Name: " + name + " | Gold: " + gold);
        System.out.println("Field: " + field);
        System.out.println("Barn: " + barn);
        System.out.println("Inventory: " + inventory);
    }
}
