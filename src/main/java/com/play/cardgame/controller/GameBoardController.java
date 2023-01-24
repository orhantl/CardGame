package com.play.cardgame.controller;

import com.play.cardgame.service.GameManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GameBoardController {

    private final GameManager gameManager;

    public GameBoardController(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @RequestMapping("/")
    public String homePage(Model model) {
        GameSetUp gameSetUp = gameManager.getGameSetUp();

        model.addAttribute("unorderedHand", gameSetUp.unorderedHand());
        model.addAttribute("orderedHand", gameSetUp.orderedHand());
        model.addAttribute("colors", gameSetUp.colors());
        model.addAttribute("values", gameSetUp.values());
        return "gameboard";
    }

}
