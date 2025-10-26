package com.farmgame.core;

import java.io.Serializable;

public class TimeSystem implements Serializable {
    private int day = 1;

    public int getDay() { return day; }

    public void nextDay() {
        day++;
        System.out.println("A new day has begun. Today is day " + day + ".");
    }
}
