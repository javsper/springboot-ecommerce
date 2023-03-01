package com.gmail.goldlion.ecommerce.controller;

import com.gmail.goldlion.ecommerce.domain.User;
import com.gmail.goldlion.ecommerce.dto.OrderDto;
import com.gmail.goldlion.ecommerce.dto.PerfumeDto;
import com.gmail.goldlion.ecommerce.exception.InputFieldException;
import com.gmail.goldlion.ecommerce.mapper.OrderMapper;
import com.gmail.goldlion.ecommerce.mapper.UserMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    private final UserMapper userMapper;
    private final OrderMapper orderMapper;

    public OrderController(UserMapper userMapper, OrderMapper orderMapper) {
        this.userMapper = userMapper;
        this.orderMapper = orderMapper;
    }

    @GetMapping
    public ResponseEntity<List<PerfumeDto>> getOrder(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(userMapper.getCart(user.getEmail()));
    }

    @PostMapping
    public ResponseEntity<OrderDto> postOrder(@AuthenticationPrincipal User user,
                                              @Valid @RequestBody OrderDto orderDto,
                                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        } else {
            return ResponseEntity.ok(orderMapper.postOrder(orderDto, user.getEmail()));
        }
    }

    @GetMapping("/finalize")
    public ResponseEntity<Long> finalizeOrder() {
        return ResponseEntity.ok(orderMapper.finalizeOrder());
    }

    @GetMapping("/list")
    public ResponseEntity<List<OrderDto>> getUserOrdersList(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(orderMapper.findOrderByUser(user));
    }
}
