package org.minibank.creditCard.dto;

import org.minibank.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;
import org.minibank.marker.OnCreate;
import org.minibank.marker.OnUpdate;

@Data
@Builder
public class  NewCreditCardDto {
    @NotNull(groups = {OnCreate.class})
    @NotBlank(groups = {OnCreate.class})
    @Positive(groups = {OnUpdate.class, OnCreate.class})
    Long ownerId;
    String duration;
    Status status;
    @Positive(groups = {OnUpdate.class, OnCreate.class})
    int balance;
}
