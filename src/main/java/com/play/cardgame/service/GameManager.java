package com.play.cardgame.service;

import com.play.cardgame.controller.GameSetUp;
import com.play.cardgame.model.Card;
import com.play.cardgame.model.Color;
import com.play.cardgame.model.OrderCriteria;
import com.play.cardgame.model.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class GameManager {

    private final HandDealer handDealer;
    private final OrderProvider orderProvider;

    public GameManager(HandDealer handDealer, OrderProvider orderProvider) {
        this.handDealer = handDealer;
        this.orderProvider = orderProvider;
    }

    public GameSetUp getGameSetUp() {
        List<OrderCriteria> colors = orderProvider.getRandomOrder(new ArrayList<>(Arrays.asList(Color.values())));
        List<String> colorNames = colors.stream().map(OrderCriteria::getName).toList();

        List<OrderCriteria> values = orderProvider.getRandomOrder(new ArrayList<>(Arrays.asList(Value.values())));
        List<String> valueNames = values.stream().map(OrderCriteria::getName).toList();

        List<Card> unorderedHand = handDealer.getHand();
        List<String> unorderedHandFileNames = unorderedHand.stream().map(Card::getImageFilename).toList();

        List<Card> orderedHand = orderProvider.getOrderedHand(unorderedHand, colors, values);
        List<String> orderedHandFileNames = orderedHand.stream().map(Card::getImageFilename).toList();

        return new GameSetUp(colorNames, valueNames, unorderedHandFileNames, orderedHandFileNames);
    }
}