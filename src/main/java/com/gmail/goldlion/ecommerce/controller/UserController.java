package com.gmail.goldlion.ecommerce.controller;

import com.gmail.goldlion.ecommerce.domain.User;
import com.gmail.goldlion.ecommerce.dto.AuthenticationRequestDto;
import com.gmail.goldlion.ecommerce.dto.review.ReviewDtoIn;
import com.gmail.goldlion.ecommerce.dto.user.UserDtoIn;
import com.gmail.goldlion.ecommerce.dto.order.OrderDtoOut;
import com.gmail.goldlion.ecommerce.dto.user.UserDtoOut;
import com.gmail.goldlion.ecommerce.exception.InputFieldException;
import com.gmail.goldlion.ecommerce.mapper.OrderMapper;
import com.gmail.goldlion.ecommerce.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserMapper userMapper;
    private final OrderMapper orderMapper;

    @GetMapping("/edit")
    public ResponseEntity<UserDtoOut> getUserInfo(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(userMapper.findUserByEmail(user.getEmail()));
    }

    @PutMapping("/edit")
    public ResponseEntity<String> updateUserInfo(@AuthenticationPrincipal UserDtoIn userDto,
                                                 @RequestBody AuthenticationRequestDto request) {
        userMapper.updateProfile(userDto, request.getPassword(), request.getEmail());
        return ResponseEntity.ok("User updated successfully.");
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderDtoOut>> getAllUserOrders(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(orderMapper.findOrderByEmail(user.getEmail()));
    }

    @PostMapping("/review")
    public ResponseEntity<String> addReviewToPerfume(@RequestParam(required = false, name = "perfumeId") Long perfumeId,
                                                     @Valid ReviewDtoIn reviewDto,
                                                     BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        } else {
            userMapper.addReviewToPerfume(reviewDto, perfumeId);
            return ResponseEntity.ok("Review added successfully.");
        }
    }
}
