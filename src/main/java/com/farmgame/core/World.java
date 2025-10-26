package com.farmgame.core;

import java.io.Serializable;

public class World implements Serializable {
    private final TimeSystem time = new TimeSystem();

    public TimeSystem getTime() {
        return time;
    }
}
