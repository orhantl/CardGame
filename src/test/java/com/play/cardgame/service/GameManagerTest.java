package com.play.cardgame.service;

import com.play.cardgame.controller.GameSetUp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GameManagerTest {

    private final HandDealer handDealer = new HandDealer();
    private final OrderProvider orderProvider = new OrderProvider();
    private final GameManager gameManager = new GameManager(handDealer, orderProvider);

    private static final int EXPECTED_COLOR_NUMBER = 4;
    private static final int EXPECTED_VALUE_NUMBER = 13;
    private static final int EXPECTED_HAND_SIZE = 10;

    @Test
    void should_provide_gameSetUp() {
        GameSetUp gameSetUp = gameManager.getGameSetUp();

        assertThat(gameSetUp).isNotNull();
        assertThat(gameSetUp.colors()).hasSize(EXPECTED_COLOR_NUMBER);
        assertThat(gameSetUp.colors()).doesNotHaveDuplicates();

        assertThat(gameSetUp.values()).hasSize(EXPECTED_VALUE_NUMBER);
        assertThat(gameSetUp.values()).doesNotHaveDuplicates();

        assertThat(gameSetUp.unorderedHand()).hasSize(EXPECTED_HAND_SIZE);
        assertThat(gameSetUp.unorderedHand()).doesNotHaveDuplicates();

        assertThat(gameSetUp.orderedHand()).hasSize(EXPECTED_HAND_SIZE);
        assertThat(gameSetUp.orderedHand()).doesNotHaveDuplicates();
    }

}