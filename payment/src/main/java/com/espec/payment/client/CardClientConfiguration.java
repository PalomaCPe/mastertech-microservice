package com.espec.payment.client;

import feign.Feign;
import io.github.resilience4j.feign.FeignDecorators;
import feign.codec.ErrorDecoder;
import feign.RetryableException;
import io.github.resilience4j.feign.Resilience4jFeign;
import org.springframework.context.annotation.Bean;

public class CardClientConfiguration {
    @Bean
    public ErrorDecoder getCrediClientDecoder(){
        return new CardClientDecoder();
    }

    @Bean
    public Feign.Builder builder(){
        FeignDecorators decorators = FeignDecorators.builder()
                .withFallback(new CardFallback(), RetryableException.class)
                .withFallbackFactory(CardClientLoadBalancerFallback::new, RuntimeException.class)
                .build();

        return Resilience4jFeign.builder(decorators);
    }

}
