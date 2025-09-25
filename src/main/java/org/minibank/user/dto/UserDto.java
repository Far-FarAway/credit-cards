package org.minibank.user.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    String login;
    String email;
    String birthDate;
}
