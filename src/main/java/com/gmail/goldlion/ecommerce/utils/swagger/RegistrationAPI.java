package com.gmail.goldlion.ecommerce.utils.swagger;

import com.gmail.goldlion.ecommerce.dto.RegistrationRequestDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface RegistrationAPI {

    @ApiOperation(value = "New user registration")
    ResponseEntity<String> registration(RegistrationRequestDto user, BindingResult bindingResult);

    @ApiOperation(value = "Activate email code")
    ResponseEntity<String> activateEmailCode(String code);
}
