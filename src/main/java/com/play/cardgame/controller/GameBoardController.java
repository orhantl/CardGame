package com.play.cardgame.controller;

import com.play.cardgame.service.GameManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GameBoardController {

    @Autowired
    private GameManager gameManager;

    @RequestMapping("/")
    public String homePage(Model model) {
        GameSetUp gameSetUp = gameManager.getGameSetUp();

        model.addAttribute("unorderedHand", gameSetUp.getUnorderedHand());
        model.addAttribute("orderedHand", gameSetUp.getOrderedHand());
        model.addAttribute("colors", gameSetUp.getColors());
        model.addAttribute("values", gameSetUp.getValues());
        return "gameboard";
    }

}
