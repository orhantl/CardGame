package com.play.cardgame.controller;

import com.play.cardgame.service.GameManager;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@WebMvcTest(GameBoardController.class)
class GameBoardControllerTest {

    private static final String EXPECTED_UNORDERED_HAND = "[nine_diamond.svg, ten_heart.svg, jack_diamond.svg, five_spade.svg, " +
            "five_heart.svg, seven_diamond.svg, four_diamond.svg, three_spade.svg, queen_club.svg, ten_club.svg]";
    private static final String EXPECTED_ORDERED_HAND = "[four_diamond.svg, seven_diamond.svg, jack_diamond.svg, " +
            "nine_diamond.svg, ten_club.svg, queen_club.svg, ten_heart.svg, five_heart.svg, three_spade.svg, five_spade.svg]";

    @MockBean
    private GameManager gameManager;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldCreateMockMvc() {
        assertNotNull(mockMvc);
    }

    @Test
    void should_display_card_order_setting_and_hands() throws Exception {
        when(gameManager.getGameSetUp()).thenReturn(getGameSetUp());

        this.mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("gameboard"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("colors"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("values"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("unorderedHand"))
                .andExpect(MockMvcResultMatchers.model().attribute("unorderedHand", Matchers.hasSize(10)))
                .andExpect(MockMvcResultMatchers.model().attributeExists("orderedHand"))
                .andExpect(MockMvcResultMatchers.model().attribute("orderedHand", Matchers.hasSize(10)));

        String unorderedHand = Objects.requireNonNull(this.mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andReturn().getModelAndView()).getModel().get("unorderedHand").toString();
        String orderedHand = Objects.requireNonNull(this.mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andReturn().getModelAndView()).getModel().get("orderedHand").toString();

        assertEquals(EXPECTED_UNORDERED_HAND,unorderedHand);
        assertEquals(EXPECTED_ORDERED_HAND, orderedHand);
    }

    private GameSetUp getGameSetUp() {
        List<String> colors = List.of("Diamond", "Club", "Heart", "Spade");
        List<String> values = List.of("4", "7", "6", "10", "2", "King", "3", "Ace", "5", "Queen", "8", "Jack", "9");
        List<String> unorderedHand = List.of(
                "nine_diamond.svg", "ten_heart.svg", "jack_diamond.svg", "five_spade.svg", "five_heart.svg",
                "seven_diamond.svg", "four_diamond.svg", "three_spade.svg", "queen_club.svg", "ten_club.svg");
        List<String> orderedHand = List.of(
                "four_diamond.svg", "seven_diamond.svg", "jack_diamond.svg", "nine_diamond.svg", "ten_club.svg",
                "queen_club.svg", "ten_heart.svg", "five_heart.svg", "three_spade.svg", "five_spade.svg");

        return new GameSetUp(colors, values, unorderedHand, orderedHand);
    }
}