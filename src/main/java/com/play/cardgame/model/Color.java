package com.play.cardgame.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Color implements OrderCriteria {
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

    public static List<OrderCriteria> convertColorToOrderCriteria() {
        return new ArrayList<>(Arrays.asList(Color.values()));
    }
}
