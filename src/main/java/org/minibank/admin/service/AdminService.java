package org.minibank.admin.service;

import org.minibank.creditCard.dto.CreditCardDto;
import org.minibank.creditCard.dto.NewCreditCardDto;

public interface AdminService {
    CreditCardDto createCard(NewCreditCardDto card);

    void blockCard(Long cardId);

    void activateCard(Long cardId);

    void deleteCard(Long cardId);

    CreditCardDto getCard(Long cardId);

    CreditCardDto updateCard(NewCreditCardDto dto, Long cardId);
}
