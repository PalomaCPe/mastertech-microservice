package com.espec.payment.controller;

import com.espec.payment.DTO.Mapper.PaymentMapper;
import com.espec.payment.DTO.Request.PaymentRequest;
import com.espec.payment.DTO.Response.PaymentResponse;
import com.espec.payment.model.Payment;
import com.espec.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @Autowired
    PaymentMapper paymentMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentResponse createPayment(@RequestBody @Valid PaymentRequest createPaymentRequest) {
        Payment payment = paymentService.createPayment(paymentMapper.toPayment(createPaymentRequest));
        return paymentMapper.toCreatePaymentResponse(payment);
    }

    @GetMapping("/{cardId}")
    public List<PaymentResponse> findPaymentsIdCartao(@PathVariable(name = "cardId") int cardId) {
        List<PaymentResponse> createPaymentResponseList =
                paymentMapper.toListCreatePaymentResponse(
                        paymentService.findPaymentsByCardId(cardId));
        return createPaymentResponseList;

    }

//    @DeleteMapping("/{cardId}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deletePaymentByIdCartao (@PathVariable(name = "cardId") int cardId) {
//        paymentService.deletePaymentsByCardId(cardId);
//    }


}
