package com.play.cardgame.service;

import com.play.cardgame.model.Color;
import com.play.cardgame.model.Value;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrderProviderTest {

    private final OrderProvider orderProvider = new OrderProvider();

    @Test
    void should_return_randomly_ordered_values() {
        List<Value> randomOrderValues = orderProvider.getRandomOrderValues();
        assertEquals(Value.values().length, randomOrderValues.size());
        assertThat(randomOrderValues).doesNotHaveDuplicates();
    }

    @Test
    void should_return_randomly_ordered_colors() {
        List<Color> randomOrderColors = orderProvider.getRandomOrderColors();
        assertEquals(Color.values().length, randomOrderColors.size());
        assertThat(randomOrderColors).doesNotHaveDuplicates();
    }

}