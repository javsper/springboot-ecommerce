package com.gmail.goldlion.ecommerce.dto;

import lombok.Data;

@Data
public class PasswordResetRequestDto {
    private String email;
    private String password;
    private String password2;
}
