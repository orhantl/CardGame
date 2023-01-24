package com.play.cardgame.controller;

import java.util.List;

public record GameSetUp(List<String> colors, List<String> values,
                        List<String> unorderedHand, List<String> orderedHand) {

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
