package com.espec.payment.service;

import com.espec.payment.client.Card;
import com.espec.payment.client.CardClient;
import com.espec.payment.exception.PaymentNotFoundException;
import com.espec.payment.model.Payment;
import com.espec.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    CardClient cardClient;

    public Payment createPayment(Payment payment) {
        Card card = cardClient.findById(payment.getCardId());
        return paymentRepository.save(payment);
    }

    public Iterable<Payment> findPaymentsByCardId(int cardId) {
        List<Payment> paymentList = paymentRepository.getPaymentsByCardId(cardId);

        if (paymentList.size() > 0) {
            return paymentList;
        } else {
            throw new PaymentNotFoundException();
        }
    }

    public void deletePaymentsByCardNumber(int cardNumber) {
        Card card = cardClient.findById(cardNumber);
        paymentRepository.deleteByCardId(card.getId());
    }

}
