package com.play.cardgame.controller;

import com.play.cardgame.model.Card;
import com.play.cardgame.model.Color;
import com.play.cardgame.model.Value;
import com.play.cardgame.service.HandService;

import java.util.List;

import static com.play.cardgame.model.Color.*;
import static com.play.cardgame.model.Color.SPADE;
import static com.play.cardgame.model.Value.*;

public class CardBoardControllerTestHelper {

    public static final String EXPECTED_UNORDERED_HAND = "[Ace of Spade, 2 of Spade, 3 of Spade, Ace of Club, 2 of Club, Ace of Heart, " +
            "2 of Heart, Ace of Diamond, 2 of Diamond, 3 of Diamond]";
    public static final String EXPECTED_ORDERED_HAND = "[3 of Diamond, 2 of Diamond, Ace of Diamond, 2 of Heart, Ace of Heart, " +
            "2 of Club, Ace of Club, 3 of Spade, 2 of Spade, Ace of Spade]";

    public static List<Value> getValueOrder() {
        return List.of(KING, QUEEN, JACK, TEN, NINE, EIGHT, SEVEN, SIX, FIVE, FOUR, THREE, TWO, ACE);
    }

    public static List<Color> getColorOrder() {
        return List.of(DIAMOND, HEART, CLUB, SPADE);
    }

    public static List<Card> getUnorderedHand() {
        return List.of(
                new Card(ACE, SPADE),
                new Card(TWO, SPADE),
                new Card(THREE, SPADE),
                new Card(ACE, CLUB),
                new Card(TWO, CLUB),
                new Card(ACE, HEART),
                new Card(TWO, HEART),
                new Card(ACE, DIAMOND),
                new Card(TWO, DIAMOND),
                new Card(THREE, DIAMOND));
    }

    public static List<Card> getOrderedHand() {
        HandService handService = new HandService();
        return handService.getOrderedHand(getUnorderedHand(), getColorOrder(), getValueOrder());
    }
}
