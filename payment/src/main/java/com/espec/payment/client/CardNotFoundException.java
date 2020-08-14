package com.espec.payment.client;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Cartão não encontrado")
public class CardNotFoundException extends RuntimeException {

}
