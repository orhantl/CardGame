package com.play.cardgame.controller;

import com.play.cardgame.model.Card;
import com.play.cardgame.model.Color;
import com.play.cardgame.model.Value;
import com.play.cardgame.service.HandService;
import com.play.cardgame.service.OrderProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CardBoardController {

    @Autowired
    private HandService handService;

    @Autowired
    private OrderProvider orderProvider;

    @RequestMapping("/")
    public String homePage(Model model) {

        List<Card> unorderedHand = handService.getHand();
        List<Value> values = orderProvider.getRandomOrderValues();
        List<Color> colors = orderProvider.getRandomOrderColors();
        List<Card> orderedHand = handService.getOrderedHand(unorderedHand, colors, values);

        model.addAttribute("unorderedHand", unorderedHand);
        model.addAttribute("orderedHand", orderedHand);
        model.addAttribute("colors", colors);
        model.addAttribute("values", values);
        return "cardboard";
    }

}
