package org.minibank.user.controller;

import org.minibank.creditCard.dto.CreditCardDto;
import org.minibank.enums.Filter;
import org.minibank.enums.Sort;
import org.minibank.enums.Status;

public interface UserController {
    CreditCardDto getCard(Long userId, Long cardId, Filter filter, Sort sort, Status status);

    void requestBlockCard(Long userId, Long cardId);

    void transfer(Long userId, Long cardId, Long CardIdToTransfer);

    String getBalance(Long userId, Long cardId);
}
