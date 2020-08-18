package com.espec.card.repository;

import com.espec.card.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card,Integer > {
    Optional<Card> getCardByNumber(String number);
    Optional<Card> getCardById(int id);
}
