package com.play.cardgame.service;

import com.play.cardgame.model.Card;
import com.play.cardgame.model.OrderCriteria;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class OrderProvider {

    private static final Random random = new Random();

    public OrderProvider() {
    }

    public List<OrderCriteria> getRandomOrder(List<OrderCriteria> orderCriteria) {
        List<OrderCriteria> randomOrderCriteria = new ArrayList<>();
        int originalCriteriaSize = orderCriteria.size();

        for (int i = 0; i < originalCriteriaSize; i++) {
            int randomIndex = random.nextInt(orderCriteria.size());
            randomOrderCriteria.add(orderCriteria.get(randomIndex));
            orderCriteria.remove(randomIndex);
        }
        return randomOrderCriteria;
    }

    public List<Card> getOrderedHand(List<Card> hand, List<OrderCriteria> orderedColors, List<OrderCriteria> orderedValues) {
        List<Card> orderedHand = new ArrayList<>();

        orderedColors.forEach(color -> orderedValues.forEach(value -> hand.stream()
                .filter(card -> card.getColor().equals(color) && card.getValue().equals(value))
                .findAny()
                .ifPresent(orderedHand::add)));

        return orderedHand;
    }

}
