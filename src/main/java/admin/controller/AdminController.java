package admin.controller;

import creditCard.model.CreditCard;

public interface AdminController {
    CreditCard createCard(CreditCard card);

    void blockCard(Long cardId);

    void activateCard(Long cardId);

    void deleteCard(Long cardId);

    CreditCard getCard(Long cardId);
}
