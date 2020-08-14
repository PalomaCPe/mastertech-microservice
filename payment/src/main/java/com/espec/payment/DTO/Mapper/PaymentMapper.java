package com.espec.payment.DTO.Mapper;

import com.espec.payment.DTO.Request.PaymentRequest;
import com.espec.payment.DTO.Response.PaymentResponse;
import com.espec.payment.model.Payment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PaymentMapper {
    public Payment toPayment(PaymentRequest createPaymentRequest) {
        Payment payment = new Payment();
        payment.setCardId(createPaymentRequest.getCardId());
        payment.setDescription(createPaymentRequest.getDescription());
        payment.setValue(createPaymentRequest.getValue());

        return payment;
    }

    public PaymentResponse toCreatePaymentResponse(Payment payment) {
        PaymentResponse createPaymentResponse = new PaymentResponse();
        createPaymentResponse.setId(payment.getId());
        createPaymentResponse.setCardId(payment.getCardId());
        createPaymentResponse.setDescription(payment.getDescription());
        createPaymentResponse.setValue(payment.getValue());

        return createPaymentResponse;
    }

    public List<PaymentResponse> toListCreatePaymentResponse(Iterable<Payment> paymentsIdCartao) {

        List<PaymentResponse> createPaymentResponseList = new ArrayList<>();

        for (Payment payment : paymentsIdCartao) {
            createPaymentResponseList.add(toCreatePaymentResponse(payment));
        }
        return createPaymentResponseList;
    }

}
