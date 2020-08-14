package com.espec.payment.client;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class CardClientConfiguration {
    @Bean
    public ErrorDecoder findCardClientDecoder(){
        return new CardClientDecoder();
    }

}
