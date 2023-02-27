package com.gmail.goldlion.ecommerce.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ReviewDto {

    @NotBlank(message = "Fill in the input field")
    private String author;

    @NotBlank(message = "Fill in the input field")
    private String message;
}
