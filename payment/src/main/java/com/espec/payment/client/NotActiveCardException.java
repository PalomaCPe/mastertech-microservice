package com.espec.payment.client;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Cartão inativo")
public class NotActiveCardException extends RuntimeException {

}
