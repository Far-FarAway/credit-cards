package org.minibank.admin.controller;

import org.minibank.creditCard.dto.CreditCardDto;
import org.minibank.creditCard.dto.NewCreditCardDto;

public interface AdminController {
    CreditCardDto createCard(NewCreditCardDto dto);

    void blockCard(Long cardId);

    void activateCard(Long cardId);

    void deleteCard(Long cardId);

    CreditCardDto getCard(Long cardId);

    CreditCardDto updateCard(NewCreditCardDto dto, Long cardId);
}
