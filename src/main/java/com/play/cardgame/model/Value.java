package com.play.cardgame.model;

public enum Value {
    ACE ("Ace"),
    KING("King"),
    QUEEN("Queen"),
    JACK("Jack"),
    TEN("10"),
    NINE("9"),
    EIGHT("8"),
    SEVEN("7"),
    SIX("6"),
    FIVE("5"),
    FOUR("4"),
    THREE("3"),
    TWO("2");

    private final String name;

    Value(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
