package com.espec.payment.client;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CardClientDecoder implements ErrorDecoder {
    private ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String s, Response response) {
        if (response.status() == 404){
            return new CardNotFoundException();
        }

        if (response.status() == 400){
            return new NotActiveCardException();
        }

        return errorDecoder.decode(s,response);
    }

}
