package com.play.cardgame.controller;

import com.play.cardgame.service.HandService;
import com.play.cardgame.service.OrderProvider;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Objects;

import static com.play.cardgame.controller.CardBoardControllerTestHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest(CardBoardController.class)
class CardBoardControllerTest {

    @MockBean
    private HandService handService;

    @MockBean
    private OrderProvider orderProvider;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldCreateMockMvc() {
        assertNotNull(mockMvc);
    }

    @Test
    void should_display_card_order_setting_and_hands() throws Exception {
        when(handService.getHand()).thenReturn(getUnorderedHand());
        when(handService.getOrderedHand(any(), any(), any())).thenReturn(getOrderedHand());
        when(orderProvider.getRandomOrderColors()).thenReturn(getColorOrder());
        when(orderProvider.getRandomOrderValues()).thenReturn(getValueOrder());

        this.mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("cardboard"))
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
}