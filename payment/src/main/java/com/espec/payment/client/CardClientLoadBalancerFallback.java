package com.espec.payment.client;

import com.netflix.client.ClientException;

public class CardClientLoadBalancerFallback implements CardClient {

    private Exception exception;

    public CardClientLoadBalancerFallback(Exception exception) {
        this.exception = exception;
    }

    @Override
    public Card findById(int id) {
        if(exception.getCause() instanceof ClientException) {
            Card card = new Card();
            card.setNumber("Falha em comunicação com o MS de cartão");
            return card;
        }
        throw (RuntimeException) exception;
    }
}
