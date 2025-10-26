package com.farmgame.io;

import com.farmgame.player.Player;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SaveLoad {
    private static final Path SAVE_PATH = Paths.get("savegame.json");
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static void save(Player player) {
        try (FileWriter fw = new FileWriter(SAVE_PATH.toFile())) {
            GSON.toJson(player, fw);
            System.out.println("Saved game to " + SAVE_PATH.toAbsolutePath());
        } catch (Exception e) {
            System.out.println("Save failed: " + e.getMessage());
        }
    }

    public static Player load() {
        try {
            if (!Files.exists(SAVE_PATH)) return null;
            try (FileReader fr = new FileReader(SAVE_PATH.toFile())) {
                Player p = GSON.fromJson(fr, Player.class);
                System.out.println("Loaded game from " + SAVE_PATH.toAbsolutePath());
                return p;
            }
        } catch (Exception e) {
            System.out.println("Load failed: " + e.getMessage());
            return null;
        }
    }
}
