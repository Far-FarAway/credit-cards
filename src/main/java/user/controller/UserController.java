package user.controller;

import creditCard.model.CreditCard;
import enums.Filter;
import enums.Sort;
import enums.Status;

public interface UserController {
    CreditCard getCard(Long userId, Long cardId, Filter filter, Sort sort, Status status);

    void requestBlockCard(Long userId, Long cardId);

    void transfer(Long userId, Long cardId, Long CarIdToTransfer);

    //Можно сделать дто где будет чисто баланс или тупо возвращать строку
    CreditCard getBalance(Long userId, Long cardId);
}
