package com.farmgame.market;

import com.farmgame.player.Player;

import java.io.Serializable;
import java.util.Scanner;

public class Market implements Serializable {

    public void open(Player player, Scanner scanner) {
        System.out.println("=== MARKET ===");
        System.out.println("1) Buy wheat seed (2 gold)");
        System.out.println("2) Buy corn seed (3 gold)");
        System.out.println("3) Buy animal feed (4 gold)");
        System.out.println("4) Buy Cow (60 gold)");
        System.out.println("5) Buy Chicken (25 gold)");
        System.out.println("0) Exit");
        System.out.print("Choose: ");
        String ch = scanner.nextLine().trim();
        switch (ch) {
            case "1" -> buy(player, "WHEAT_SEED", 2, 1);
            case "2" -> buy(player, "CORN_SEED", 3, 1);
            case "3" -> buy(player, "FEED", 4, 1);
            case "4" -> buyAnimal(player, "COW", 60);
            case "5" -> buyAnimal(player, "CHICKEN", 25);
            default -> System.out.println("Leaving the market.");
        }
    }

    private void buy(Player player, String item, int price, int qty) {
        int cost = price * qty;
        if (player.spendGold(cost)) {
            player.getInventory().add(item, qty);
            System.out.println("Bought " + qty + " " + item + " for " + cost + " gold.");
        } else {
            System.out.println("Not enough gold.");
        }
    }

    private void buyAnimal(Player player, String type, int price) {
        if (player.spendGold(price)) {
            switch (type) {
                case "COW" -> player.getBarn().buy("COW");
                case "CHICKEN" -> player.getBarn().buy("CHICKEN");
            }
        } else {
            System.out.println("Not enough gold to buy " + type + ".");
        }
    }
}
