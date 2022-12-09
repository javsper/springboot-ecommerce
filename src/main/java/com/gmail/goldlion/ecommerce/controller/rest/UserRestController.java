package com.gmail.goldlion.ecommerce.controller.rest;

import com.gmail.goldlion.ecommerce.domain.Order;
import com.gmail.goldlion.ecommerce.domain.User;
import com.gmail.goldlion.ecommerce.dto.AuthenticationRequestDTO;
import com.gmail.goldlion.ecommerce.service.OrderService;
import com.gmail.goldlion.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rest")
public class UserRestController {

    private final UserService userService;

    private final OrderService orderService;

    @Autowired
    public UserRestController(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    @GetMapping("/user/edit")
    public ResponseEntity<?> getUserInfo(@AuthenticationPrincipal User userSession) {
        User user = userService.findByEmail(userSession.getEmail());

        return ResponseEntity.ok(user);
    }

    @PostMapping("/user/edit")
    public ResponseEntity<?> updateUserInfo(
            @AuthenticationPrincipal User userSession,
            @RequestBody AuthenticationRequestDTO request
    ) {
        userService.updateProfile(userSession, request.getPassword(), request.getEmail());

        return ResponseEntity.ok("OK");
    }

    @GetMapping("/user/orders")
    public ResponseEntity<?> getAllUserOrders(@AuthenticationPrincipal User userSession) {
        User user = userService.findByEmail(userSession.getEmail());
        List<Order> orders = orderService.findOrderByUser(user);

        return ResponseEntity.ok(orders);
    }
}
