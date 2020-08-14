package com.espec.card.DTO.Mapper;

import com.espec.card.DTO.Request.CardRequest;
import com.espec.card.DTO.Response.ActiveCardResponse;
import com.espec.card.DTO.Response.CardResponse;
import com.espec.card.client.Customer;
import com.espec.card.model.Card;
import org.springframework.stereotype.Component;

@Component
public class CardMapper {
    public Card toCard(CardRequest cardRequest){
        Card card = new Card();
        card.setNumber(cardRequest.getNumber());
        card.setActive(false);

        Customer customer = new Customer();
        customer.setId(cardRequest.getCustomerId());

        card.setCustomerId(customer.getId());

        return card;
    }

    public CardResponse toCardResponse(Card card) {
        CardResponse cardResponse = new CardResponse();
        cardResponse.setId(card.getId());
        cardResponse.setNumber(card.getNumber());
        cardResponse.setCustomerId(card.getCustomerId());
        cardResponse.setActive(card.getActive());
        return cardResponse;
    }

    public CardResponse toCardDetalheResponse(Card card) {
        CardResponse cardDetalheResponse = new CardResponse();
        cardDetalheResponse.setId(card.getId());
        cardDetalheResponse.setNumber(card.getNumber());
        cardDetalheResponse.setCustomerId(card.getCustomerId());
        cardDetalheResponse.setActive(card.getActive());
        return cardDetalheResponse;
    }

    public ActiveCardResponse toActiveCardResponse(Card card) {
        ActiveCardResponse cardAtivoResponse = new ActiveCardResponse();

        cardAtivoResponse.setId(card.getId());
        cardAtivoResponse.setNumber(card.getNumber());
        cardAtivoResponse.setCustomerId(card.getCustomerId());
        cardAtivoResponse.setActive(card.getActive());

        return cardAtivoResponse;
    }
}
