package com.project.agency.services;

import com.project.agency.entities.Cabin;
import com.project.agency.entities.Deck;
import com.project.agency.repositories.DeckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;


@Service
public class DeckImpl implements DeckInter{

    @Autowired
    private DeckRepository deckRepo;

    @Override
    public Deck addDeck(Deck X) {
        return deckRepo.save(X);
    }

}
