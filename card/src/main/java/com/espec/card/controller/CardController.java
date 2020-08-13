package com.ex1cartoesapi.controller;

import com.ex1cartoesapi.DTO.Mapper.CardMapper;
import com.ex1cartoesapi.DTO.Request.ActiveCardRequest;
import com.ex1cartoesapi.DTO.Request.CardRequest;
import com.ex1cartoesapi.DTO.Response.ActiveCardResponse;
import com.ex1cartoesapi.DTO.Response.CardResponse;
import com.ex1cartoesapi.model.Card;
import com.ex1cartoesapi.service.CardService;
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
//    @RequestMapping(method = RequestMethod.POST, path = "/save")
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
}
