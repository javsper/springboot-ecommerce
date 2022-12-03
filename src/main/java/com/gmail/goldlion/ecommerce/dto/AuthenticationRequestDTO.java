package com.gmail.goldlion.ecommerce.dto;

import lombok.Data;

//2
@Data
public class AuthenticationRequestDTO {
    private String email;
    private String password;
}
