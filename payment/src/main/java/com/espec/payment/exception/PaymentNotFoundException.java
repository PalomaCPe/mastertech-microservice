package com.espec.payment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Pagamento não encontrado")
public class PaymentNotFoundException extends RuntimeException{

}