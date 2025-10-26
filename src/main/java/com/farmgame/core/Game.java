package com.farmgame.core;

import com.farmgame.io.SaveLoad;
import com.farmgame.market.Market;
import com.farmgame.player.Player;

import java.util.Scanner;

public class Game {
    private final Scanner scanner = new Scanner(System.in);
    private final World world = new World();
    private final Market market = new Market();
    private Player player;

    public void start(boolean startNew) {
        System.out.println("=== FARM GAME (Java OOP) ===");
        if (!startNew) {
            player = SaveLoad.load();
            if (player != null) {
                System.out.println("Loaded save for " + player.getName() + ". Day: " + world.getTime().getDay());
            } else {
                System.out.println("No save found. Starting a new game.");
                createPlayer();
            }
        } else {
            createPlayer();
        }
        loop();
    }

    private void createPlayer() {
        System.out.print("Your farmer name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) name = "Farmer";
        player = new Player(name);
        System.out.println("Welcome, " + name + "! You start with 100 gold, 1 field and 1 barn.");
    }

    private void loop() {
        while (true) {
            System.out.println("\n--- Day " + world.getTime().getDay() + " --- Gold: " + player.getGold());
            System.out.println("1) Next day");
            System.out.println("2) Plant");
            System.out.println("3) Harvest");
            System.out.println("4) Market (Buy/Sell)");
            System.out.println("5) Animal care");
            System.out.println("6) Farm status");
            System.out.println("7) Save game");
            System.out.println("0) Exit");
            System.out.print("Choose: ");
            String ch = scanner.nextLine().trim();

            switch (ch) {
                case "1" -> nextDay();
                case "2" -> plantMenu();
                case "3" -> harvestMenu();
                case "4" -> marketMenu();
                case "5" -> animalsMenu();
                case "6" -> player.printStatus();
                case "7" -> SaveLoad.save(player);
                case "0" -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void nextDay() {
        world.getTime().nextDay();
        player.nextDay(world);
    }

    private void plantMenu() {
        System.out.println("Choose a crop to plant: 1) Wheat  2) Corn  (anything else to cancel)");
        String ch = scanner.nextLine().trim();
        switch (ch) {
            case "1" -> player.plant("WHEAT");
            case "2" -> player.plant("CORN");
            default -> System.out.println("Canceled.");
        }
    }

    private void harvestMenu() {
        player.harvest();
    }

    private void marketMenu() {
        market.open(player, scanner);
    }

    private void animalsMenu() {
        System.out.println("1) Feed animals");
        System.out.println("2) Collect animal products (milk/eggs)");
        String ch = scanner.nextLine().trim();
        switch (ch) {
            case "1" -> player.feedAnimals();
            case "2" -> player.collectAnimalProducts();
            default -> System.out.println("Canceled.");
        }
    }
}
