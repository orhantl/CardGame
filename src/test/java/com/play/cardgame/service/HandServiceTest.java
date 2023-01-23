package com.play.cardgame.service;

import com.play.cardgame.model.Card;
import com.play.cardgame.model.Color;
import com.play.cardgame.model.Value;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class HandServiceTest {

    private static final int EXPECTED_HAND_SIZE = 10;
    public static final int REGULAR_PLAYING_CARD_DECK_NUMBER = 52;

    private final HandService handService = new HandService();
    private final OrderProvider orderProvider = new OrderProvider();

    @Test
    void should_return_playing_card_deck() {
        List<Card> deck = handService.getDeck();
        assertEquals(REGULAR_PLAYING_CARD_DECK_NUMBER, deck.size());
    }

    @Test
    void should_return_unordered_hand() {
        List<Card> hand = handService.getHand();
        assertEquals(EXPECTED_HAND_SIZE, hand.size());
        assertThat(hand).doesNotHaveDuplicates();
    }

    @Test
    void should_return_ordered_hand() {
        List<Color> randomOrderColors = orderProvider.getRandomOrderColors();
        List<Value> randomOrderValues = orderProvider.getRandomOrderValues();
        List<Card> hand = handService.getHand();

        List<Card> orderedHand = handService.getOrderedHand(hand, randomOrderColors, randomOrderValues);
        assertEquals(EXPECTED_HAND_SIZE, orderedHand.size());
        assertThat(orderedHand).containsExactlyInAnyOrderElementsOf(hand);
    }
}