package org.minibank.creditCard.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreditCardDto {
    String owner;
    String duration;
    String status;
    int balance;
}
