package com.project.agency.controller;


import com.project.agency.entities.Deck;
import com.project.agency.services.DeckInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Deck")
public class DeckController {

    @Autowired
    private DeckInter deckService;

    @PostMapping(value = "/create")
    @ResponseBody
    public Deck create (@RequestBody Deck D)
    {
        return deckService.addDeck(D);
    }

}
