package com.play.cardgame.model;

public record Card(Value value, Color color) {

    @Override
    public String toString() {
        return value.getName() + " of " + color.getName();
    }

    public String getImageFilename() {
        return String.format("%s_%s.svg", this.value.toString().toLowerCase(), this.color.toString().toLowerCase());
    }
}
