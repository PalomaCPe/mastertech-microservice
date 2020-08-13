package com.espec.card.DTO.Mapper;

import com.espec.card.DTO.Request.CardRequest;
import com.espec.card.DTO.Response.ActiveCardResponse;
import com.espec.card.DTO.Response.CardResponse;
import org.springframework.stereotype.Component;

@Component
public class CardMapper {
    public Card toCard(CardRequest cardRequest){
        Card card = new Card();
        card.setNumber(cardRequest.getNumber());

        Customer customer = new Customer();
        customer.setId(cardRequest.getCustomerId());

        card.setCustomer(customer);

        return card;
    }

    public CardResponse toCardResponse(Card card) {
        CardResponse cardResponse = new CardResponse();
        cardResponse.setId(card.getId());
        cardResponse.setNumber(card.getNumber());
        cardResponse.setCustomerId(card.getCustomer().getId());
        return cardResponse;
    }

    public CardResponse toCardDetalheResponse(Card card) {
        CardResponse cardDetalheResponse = new CardResponse();
        cardDetalheResponse.setId(card.getId());
        cardDetalheResponse.setNumber(card.getNumber());
        cardDetalheResponse.setCustomerId(card.getCustomer().getId());
        return cardDetalheResponse;
    }

    public ActiveCardResponse toActiveCardResponse(Card card) {
        ActiveCardResponse cardAtivoResponse = new ActiveCardResponse();

        cardAtivoResponse.setId(card.getId());
        cardAtivoResponse.setNumber(card.getNumber());
        cardAtivoResponse.setCustomerId(card.getCustomer().getId());
        cardAtivoResponse.setActive(card.getActive());

        return cardAtivoResponse;
    }
}
