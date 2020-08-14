package com.espec.card.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Cartão inativo")
public class NotActiveCardException extends RuntimeException {
}
