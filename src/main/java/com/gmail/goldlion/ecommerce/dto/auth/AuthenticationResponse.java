package com.gmail.goldlion.ecommerce.dto.auth;

import com.gmail.goldlion.ecommerce.dto.user.UserResponse;
import lombok.Data;

@Data
public class AuthenticationResponse {
    private UserResponse user;
    private String token;
}
