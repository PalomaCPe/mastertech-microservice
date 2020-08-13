package com.ex1cartoesapi.service;

import com.ex1cartoesapi.model.Card;
import com.ex1cartoesapi.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    public Card save(Card card) {
        return cardRepository.save(card);
    }

    public Card getCardByNumber(String number) {
        Optional<Card> cardOptional = cardRepository.findByNumber(number);

        if(!cardOptional.isPresent()) {
            throw new RuntimeException("Not Found Card "+number);
        }

        return cardOptional.get();

    }

    public Card active(String number, boolean active) {

        Card card = getCardByNumber(number);
        card.setActive(active);

        return cardRepository.save(card);
    }


    public Card getCard(Integer id) {
        Optional<Card> cardOptional = cardRepository.findById(id);

        if(!cardOptional.isPresent()) {
            throw new RuntimeException("Not Found");
        }

        return cardOptional.get();
    }
}
