package com.espec.card.service;

import com.espec.card.client.Customer;
import com.espec.card.client.CustomerClient;
import com.espec.card.exception.CardNotFoundException;
import com.espec.card.exception.NotActiveCardException;
import com.espec.card.model.Card;
import com.espec.card.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    @Autowired
    CustomerClient customerClient;

    public Card save(Card card) {
        Customer customer = customerClient.findById(card.getCustomerId());

        card.setCustomerId(customer.getId());
        card.setNumber(card.getNumber());

        return cardRepository.save(card);
    }

    public Card getCardByNumber(String number) {
        Optional<Card> cardOptional = cardRepository.getCardByNumber(number);

        if(!cardOptional.isPresent()) {
            throw new CardNotFoundException();
        } else if (!cardOptional.get().getActive()) {
            throw new NotActiveCardException();
        }
        return cardOptional.get();
    }

    public Card getCardById(int id) {
        Optional<Card> cardOptional = cardRepository.getCardById(id);

        if(!cardOptional.isPresent()) {
            throw new CardNotFoundException();
        } else if (!cardOptional.get().getActive()) {
            throw new NotActiveCardException();
        }
        return cardOptional.get();
    }

    public Card active(String number, boolean active) {
        Optional<Card> cardOptional = cardRepository.getCardByNumber(number);;

        if(!cardOptional.isPresent()) {
            throw new CardNotFoundException();
        }

        cardOptional.get().setActive(active);
        return cardRepository.save(cardOptional.get());
    }


    public Card getCard(Integer id) {
        Optional<Card> cardOptional = cardRepository.findById(id);

        if(!cardOptional.isPresent()) {
            throw new RuntimeException("Not Found");
        }

        return cardOptional.get();
    }
}
