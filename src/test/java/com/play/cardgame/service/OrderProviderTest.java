package com.play.cardgame.service;

import com.play.cardgame.model.Card;
import com.play.cardgame.model.Color;
import com.play.cardgame.model.OrderCriteria;
import com.play.cardgame.model.Value;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.play.cardgame.model.Color.convertColorToOrderCriteria;
import static com.play.cardgame.model.Value.convertValueToOrderCriteria;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrderProviderTest {

    private static final int EXPECTED_HAND_SIZE = 10;

    private final OrderProvider orderProvider = new OrderProvider();
    private final HandDealer handDealer = new HandDealer();

    @Test
    void should_return_randomly_ordered_values() {
        List<OrderCriteria> randomOrderValues = orderProvider.getRandomOrder(convertValueToOrderCriteria());
        assertEquals(Value.values().length, randomOrderValues.size());
        assertThat(randomOrderValues).doesNotHaveDuplicates();
    }

    @Test
    void should_return_randomly_ordered_colors() {
        List<OrderCriteria> randomOrderColors = orderProvider.getRandomOrder(convertColorToOrderCriteria());
        assertEquals(Color.values().length, randomOrderColors.size());
        assertThat(randomOrderColors).doesNotHaveDuplicates();
    }

    @Test
    void should_return_ordered_hand() {
        List<Card> hand = handDealer.getHand();
        List<OrderCriteria> orderedColors = orderProvider.getRandomOrder(convertColorToOrderCriteria());
        List<OrderCriteria> orderedValues = orderProvider.getRandomOrder(convertValueToOrderCriteria());

        List<Card> orderedHand = orderProvider.getOrderedHand(hand, orderedColors, orderedValues);
        assertEquals(EXPECTED_HAND_SIZE, orderedHand.size());
        assertThat(orderedHand).containsExactlyInAnyOrderElementsOf(hand);
    }
}