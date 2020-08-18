package com.espec.card.controller;

import com.espec.card.DTO.Mapper.CardMapper;
import com.espec.card.DTO.Request.ActiveCardRequest;
import com.espec.card.DTO.Request.CardRequest;
import com.espec.card.DTO.Response.ActiveCardResponse;
import com.espec.card.DTO.Response.CardResponse;
import com.espec.card.model.Card;
import com.espec.card.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    CardService cardService;

    @Autowired
    CardMapper cardMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CardResponse saveCard(@RequestBody @Valid CardRequest cardRequest) {
        Card card = cardMapper.toCard(cardRequest);
        card = cardService.save(card);
        return cardMapper.toCardResponse(card);
    }

    @PatchMapping("/{number}")
    public ActiveCardResponse activeCard(@PathVariable String number, @Valid  @RequestBody ActiveCardRequest cardRequest) {
        Card card = cardService.active(number, cardRequest.getActive());
        return cardMapper.toActiveCardResponse(card);
    }

    @GetMapping("/{number}")
    public CardResponse getCard(@PathVariable String number) {
        Card card = cardService.getCardByNumber(number);
        return cardMapper.toCardDetalheResponse(card);
    }

    @GetMapping("/byId/{id}")
    public CardResponse getCardById(@PathVariable int id) {
        Card card = cardService.getCardById(id);
        return cardMapper.toCardDetalheResponse(card);
    }
}
