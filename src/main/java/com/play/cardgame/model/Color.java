package com.play.cardgame.model;

public enum Color {
    SPADE("Spade"),
    DIAMOND("Diamond"),
    CLUB("Club"),
    HEART("Heart");

    private final String name;

    Color(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
