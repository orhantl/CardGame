package com.play.cardgame.service;

import com.play.cardgame.model.Card;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HandDealerTest {

    public static final int REGULAR_PLAYING_CARD_DECK_NUMBER = 52;
    private static final int EXPECTED_HAND_SIZE = 10;

    private final HandDealer handDealer = new HandDealer();

    @Test
    void should_return_playing_card_deck() {
        List<Card> deck = handDealer.getDeck();
        assertEquals(REGULAR_PLAYING_CARD_DECK_NUMBER, deck.size());
    }

    @Test
    void should_return_unordered_hand() {
        List<Card> hand = handDealer.getHand();
        assertEquals(EXPECTED_HAND_SIZE, hand.size());
        assertThat(hand).doesNotHaveDuplicates();
    }
}