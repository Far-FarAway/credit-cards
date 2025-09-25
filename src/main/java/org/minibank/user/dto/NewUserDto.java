package org.minibank.user.dto;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import org.minibank.marker.OnCreate;
import org.minibank.marker.OnUpdate;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
public class NewUserDto {
    @NotBlank(groups = {OnCreate.class})
    @NotNull(groups = {OnCreate.class})
    String login;
    @Email(groups = {OnUpdate.class, OnCreate.class})
    String email;
    @NotBlank(groups = { OnCreate.class})
    @NotNull(groups = {OnCreate.class})
    @Length(groups = {OnUpdate.class, OnCreate.class},
            max = 20, min = 5)
    String password;
    @NotBlank(groups = {OnCreate.class})
    @NotNull(groups = {OnCreate.class})
    @Past(groups = {OnUpdate.class, OnCreate.class})
    String birthDate;
}
