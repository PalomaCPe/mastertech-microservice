package com.espec.payment.repository;

import com.espec.payment.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {

    List<Payment> findByCardId(int cardId);

    void deleteByCardId(int cardId);
}
