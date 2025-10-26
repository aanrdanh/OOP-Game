package com.farmgame.buildings;

import com.farmgame.entities.crops.Corn;
import com.farmgame.entities.crops.Crop;
import com.farmgame.entities.crops.Wheat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Field implements Serializable {
    private final List<Crop> crops = new ArrayList<>();

    public void plant(String type, int count) {
        for (int i = 0; i < count; i++) {
            switch (type) {
                case "WHEAT" -> crops.add(new Wheat());
                case "CORN" -> crops.add(new Corn());
            }
        }
        System.out.println("Planted " + count + " crop(s) of type " + type + ".");
    }

    public int growAndHarvestableCount() {
        int ready = 0;
        for (Crop c : crops) {
            c.growOneDay();
            if (c.isReady()) ready++;
        }
        return ready;
    }

    public int harvestAllReady() {
        int gold = 0;
        Iterator<Crop> it = crops.iterator();
        while (it.hasNext()) {
            Crop c = it.next();
            if (c.isReady()) {
                gold += c.getSellPrice();
                it.remove();
            }
        }
        System.out.println("Harvest complete. +" + gold + " gold.");
        return gold;
    }

    public int size() { return crops.size(); }

    @Override
    public String toString() { return "Field{crops=" + crops + "}"; }
}
