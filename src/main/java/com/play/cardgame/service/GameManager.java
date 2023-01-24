package com.play.cardgame.service;

import com.play.cardgame.controller.GameSetUp;
import com.play.cardgame.model.Card;
import com.play.cardgame.model.OrderCriteria;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.play.cardgame.model.Color.convertColorToOrderCriteria;
import static com.play.cardgame.model.Value.convertValueToOrderCriteria;

@Service
public class GameManager {

    private final HandDealer handDealer;
    private final OrderProvider orderProvider;

    public GameManager(HandDealer handDealer, OrderProvider orderProvider) {
        this.handDealer = handDealer;
        this.orderProvider = orderProvider;
    }

    public GameSetUp getGameSetUp() {
        List<OrderCriteria> colors = orderProvider.getRandomOrder(convertColorToOrderCriteria());
        List<String> colorNames = colors.stream().map(OrderCriteria::getName).toList();

        List<OrderCriteria> values = orderProvider.getRandomOrder(convertValueToOrderCriteria());
        List<String> valueNames = values.stream().map(OrderCriteria::getName).toList();

        List<Card> unorderedHand = handDealer.getHand();
        List<String> unorderedHandFileNames = unorderedHand.stream().map(Card::getImageFilename).toList();

        List<Card> orderedHand = orderProvider.getOrderedHand(unorderedHand, colors, values);
        List<String> orderedHandFileNames = orderedHand.stream().map(Card::getImageFilename).toList();

        return new GameSetUp(colorNames, valueNames, unorderedHandFileNames, orderedHandFileNames);
    }
}
