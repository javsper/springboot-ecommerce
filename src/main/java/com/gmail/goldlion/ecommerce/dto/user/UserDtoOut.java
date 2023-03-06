package com.gmail.goldlion.ecommerce.dto.user;

import com.gmail.goldlion.ecommerce.domain.Role;
import lombok.Data;

import java.util.Set;

@Data
public class UserDtoOut {
    private Long id;
    private String username;
    private String email;
    private boolean active;
    private String activationCode;
    private String passwordResetCode;
    private String token;
    private Set<Role> roles;
}
