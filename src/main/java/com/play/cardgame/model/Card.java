package com.play.cardgame.model;

public class Card {
    private final Value value;
    private final Color color;

    public Card(Value value, Color color) {
        this.value = value;
        this.color = color;
    }

    public Value getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return value + " of " + color;
    }

    public String getImageFilename() {
        return String.format("%s_%s.svg", this.value.toString().toLowerCase(), this.color.toString().toLowerCase());
    }
}
