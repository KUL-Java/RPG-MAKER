package com.company;

public class Game {
    private String color;
    private int delay;

    public Game() {
        this.color = "GREEN";
        this.delay = 5;
    }

    public Game(String color, int delay) {
        this.color = color;
        this.delay = delay;
    }

    public String getColor() {
        return color;
    }

    public int getDelay() {
        return delay;
    }
}
