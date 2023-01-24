package com.play.cardgame.controller;

import java.util.List;

public class GameSetUp {

    private final List<String> colors;
    private final List<String> values;
    private final List<String> unorderedHand;
    private final List<String> orderedHand;

    public GameSetUp(List<String> colors, List<String> values, List<String> unorderedHand, List<String> orderedHand) {
        this.colors = colors;
        this.values = values;
        this.unorderedHand = unorderedHand;
        this.orderedHand = orderedHand;
    }

    public List<String> getColors() {
        return colors;
    }

    public List<String> getValues() {
        return values;
    }

    public List<String> getUnorderedHand() {
        return unorderedHand;
    }

    public List<String> getOrderedHand() {
        return orderedHand;
    }

    @Override
    public String toString() {
        return "GameSetUp{" +
                "colors=" + colors +
                ", values=" + values +
                ", unorderedHand=" + unorderedHand +
                ", orderedHand=" + orderedHand +
                '}';
    }
}
