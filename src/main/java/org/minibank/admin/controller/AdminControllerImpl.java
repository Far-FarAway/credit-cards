package org.minibank.admin.controller;

import org.minibank.admin.service.AdminService;
import org.minibank.creditCard.dto.CreditCardDto;
import org.minibank.creditCard.dto.NewCreditCardDto;
import org.minibank.marker.OnCreate;
import org.minibank.marker.OnUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admins")
public class AdminControllerImpl implements AdminController {
    @Autowired
    AdminService service;

    //Подумать над созданием поля "роль" у пользователя и при запросах запрашивать айди админа, чтобы проверять в БД,
    //что это действительно админ
    @Override
    @PostMapping("/cards")
    public CreditCardDto createCard(@Validated(OnCreate.class) @RequestBody NewCreditCardDto card) {
        return service.createCard(card);
    }

    @Override
    @PatchMapping("/cards/{cardId}/block")
    public void blockCard(@PathVariable Long cardId) {
        service.blockCard(cardId);
    }

    @Override
    @PatchMapping("/cards/{cardId}/activate")
    public void activateCard(@PathVariable Long cardId) {
        service.activateCard(cardId);
    }

    @Override
    @DeleteMapping("/cards/{cardId}")
    public void deleteCard(@PathVariable Long cardId) {
        service.deleteCard(cardId);
    }

    @Override
    @GetMapping("/cards/{cardId}")
    public CreditCardDto getCard(@PathVariable Long cardId) {
        return service.getCard(cardId);
    }

    @Override
    @PatchMapping("/cards/{cardId}")
    public CreditCardDto updateCard(@Validated(OnUpdate.class) @RequestBody NewCreditCardDto dto,
                                    @PathVariable Long cardId) {
        return service.updateCard(dto, cardId);
    }
}
