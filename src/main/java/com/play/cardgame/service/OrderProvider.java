package com.play.cardgame.service;

import com.play.cardgame.model.Color;
import com.play.cardgame.model.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;

@Service
public class OrderProvider {

    private static final Random random = new Random();

    public OrderProvider() {
    }

    public List<Value> getRandomOrderValues() {
        List<Value> originalValues = new ArrayList<>(EnumSet.allOf(Value.class));
        List<Value> randomOrderValues = new ArrayList<>();

        for (int i = 0; i < Value.values().length; i++) {
            int randomIndex = random.nextInt(originalValues.size());
            randomOrderValues.add(originalValues.get(randomIndex));
            originalValues.remove(randomIndex);
        }
        return randomOrderValues;
    }

    public List<Color> getRandomOrderColors() {
        List<Color> originalColors = new ArrayList<>(EnumSet.allOf(Color.class));
        List<Color> randomOrderColors = new ArrayList<>();

        for (int i = 0; i < Color.values().length; i++) {
            int randomIndex = random.nextInt(originalColors.size());
            randomOrderColors.add(originalColors.get(randomIndex));
            originalColors.remove(randomIndex);
        }
        return randomOrderColors;
    }
}
