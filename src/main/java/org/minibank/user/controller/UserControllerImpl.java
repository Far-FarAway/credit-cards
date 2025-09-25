package org.minibank.user.controller;

import org.minibank.creditCard.dto.CreditCardDto;
import org.minibank.enums.Filter;
import org.minibank.enums.Sort;
import org.minibank.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.minibank.user.service.UserService;

@RestController
@RequestMapping("users")
public class UserControllerImpl implements UserController {
    @Autowired
    UserService service;

    @Override
    @GetMapping("{userId}/card/{cardId}")
    public CreditCardDto getCard(@PathVariable Long userId, @PathVariable Long cardId,
                                 @RequestParam(defaultValue = "BALANCE") Filter filter,
                                 @RequestParam(defaultValue = "DESC") Sort sort,
                                 @RequestParam(required = false) Status status) {
        return service.getCard(userId, cardId, filter, sort, status);
    }

    @Override
    @PatchMapping("{userId}/block/{cardId}")
    public void requestBlockCard(@PathVariable Long userId, @PathVariable Long cardId) {
        service.requestBlockCard(userId, cardId);
    }

    @Override
    @PatchMapping("{userId}/transfer/{cardId}/{cardIdTrans}")
    public void transfer(@PathVariable Long userId, @PathVariable Long cardId, @PathVariable Long CardIdToTransfer) {
        service.transfer(userId, cardId, CardIdToTransfer);
    }

    @Override
    @GetMapping("{userId}/balance/{cardId}")
    public String getBalance(@PathVariable Long userId, @PathVariable Long cardId) {
        return service.getBalance(userId, cardId);
    }
}
