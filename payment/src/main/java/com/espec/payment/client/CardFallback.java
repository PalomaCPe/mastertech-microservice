package com.espec.payment.client;


public class CardFallback implements CardClient {
    @Override
    public Card findById(int id) {
        throw new CardClientBadRequestException();
    }
}
