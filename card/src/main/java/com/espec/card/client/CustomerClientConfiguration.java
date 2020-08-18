package com.espec.card.client;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import feign.Feign;
import feign.RetryableException;

public class CustomerClientConfiguration {
    @Bean
    public ErrorDecoder getCustomerClientDecoder(){
        return new CustomerClientDecoder();
    }

    @Bean
    public Feign.Builder builder() {
        FeignDecorators decorators = FeignDecorators.builder()
                .withFallback(new CustomerClientFallback(), RetryableException.class)
                .withFallbackFactory(CustomerClientLoadBalancerFallback::new, RuntimeException.class)
                .build();

        return Resilience4jFeign.builder(decorators);
    }
}
