package com.play.cardgame.service;

import com.play.cardgame.model.Card;
import com.play.cardgame.model.Color;
import com.play.cardgame.model.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class HandDealer {

    private static final int HAND_SIZE = 10;
    private static final  Random random = new Random();

    public HandDealer() {
    }

    public List<Card> getHand() {
        List<Card> deck = getDeck();
        List<Card> hand = new ArrayList<>();

        for (int i = 0; i < HAND_SIZE; i++) {
            int randomIndex = random.nextInt(deck.size()-1);
            hand.add(deck.get(randomIndex));
            deck.remove(randomIndex);
        }
        return hand;
    }

    public List<Card> getDeck() {
        List<Card> deck = new ArrayList<>();
        Arrays.stream(Color.values()).forEach(c ->
                Arrays.stream(Value.values())
                        .map(v -> new Card(v, c))
                        .forEach(deck::add));
        return deck;
    }
}
