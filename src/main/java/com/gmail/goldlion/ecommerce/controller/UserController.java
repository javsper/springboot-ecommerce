package com.gmail.goldlion.ecommerce.controller;

import com.gmail.goldlion.ecommerce.dto.order.OrderRequestDto;
import com.gmail.goldlion.ecommerce.dto.order.OrderResponseDto;
import com.gmail.goldlion.ecommerce.dto.perfume.PerfumeResponseDto;
import com.gmail.goldlion.ecommerce.dto.review.ReviewRequestDto;
import com.gmail.goldlion.ecommerce.dto.user.UserRequestDto;
import com.gmail.goldlion.ecommerce.dto.user.UserResponseDto;
import com.gmail.goldlion.ecommerce.exception.InputFieldException;
import com.gmail.goldlion.ecommerce.mapper.OrderMapper;
import com.gmail.goldlion.ecommerce.mapper.UserMapper;
import com.gmail.goldlion.ecommerce.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserMapper userMapper;
    private final OrderMapper orderMapper;

    @GetMapping("/info")
    public ResponseEntity<UserResponseDto> getUserInfo(@AuthenticationPrincipal UserPrincipal user) {
        return ResponseEntity.ok(userMapper.findUserByEmail(user.getEmail()));
    }

    @PutMapping("/edit")
    public ResponseEntity<String> updateUserInfo(@AuthenticationPrincipal UserPrincipal user,
                                                 @Valid @RequestBody UserRequestDto request,
                                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        } else {
            userMapper.updateProfile(user.getEmail(), request.getUsername());
            return ResponseEntity.ok("User updated successfully.");
        }
    }

    @PostMapping("/cart")
    public ResponseEntity<List<PerfumeResponseDto>> getCart(@RequestBody List<Long> perfumesIds) {
        return ResponseEntity.ok(userMapper.getCart(perfumesIds));
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderResponseDto>> getAllUserOrders(@AuthenticationPrincipal UserPrincipal user) {
        return ResponseEntity.ok(orderMapper.findOrderByEmail(user.getEmail()));
    }

    @PostMapping("/order")
    public ResponseEntity<OrderResponseDto> postOrder(@Valid @RequestBody OrderRequestDto order, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        } else {
            return ResponseEntity.ok(orderMapper.postOrder(order));
        }
    }

    @GetMapping("/order/finalize")
    public ResponseEntity<Long> finalizeOrder() {
        return ResponseEntity.ok(orderMapper.finalizeOrder());
    }

    @PostMapping("/review")
    public ResponseEntity<String> addReviewToPerfume(@Valid @RequestBody ReviewRequestDto review, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        } else {
            userMapper.addReviewToPerfume(review, review.getPerfumeId());
            return ResponseEntity.ok("Review added successfully.");
        }
    }
}
