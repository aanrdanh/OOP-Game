package com.farmgame;

import com.farmgame.core.Game;

public class Main {
    public static void main(String[] args) {
        boolean startNew = false;
        for (String a : args) {
            if ("--new".equalsIgnoreCase(a)) startNew = true;
        }
        new Game().start(startNew);
    }
}
