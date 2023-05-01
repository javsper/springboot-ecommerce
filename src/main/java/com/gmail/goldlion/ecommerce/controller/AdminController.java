package com.gmail.goldlion.ecommerce.controller;

import com.gmail.goldlion.ecommerce.dto.order.OrderResponseDto;
import com.gmail.goldlion.ecommerce.dto.perfume.PerfumeRequestDto;
import com.gmail.goldlion.ecommerce.dto.perfume.PerfumeResponseDto;
import com.gmail.goldlion.ecommerce.dto.user.UserRequestDto;
import com.gmail.goldlion.ecommerce.dto.user.UserResponseDto;
import com.gmail.goldlion.ecommerce.exception.InputFieldException;
import com.gmail.goldlion.ecommerce.mapper.OrderMapper;
import com.gmail.goldlion.ecommerce.mapper.PerfumeMapper;
import com.gmail.goldlion.ecommerce.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/api/v1/admin")
public class AdminController {

    private final UserMapper userMapper;
    private final PerfumeMapper perfumeMapper;
    private final OrderMapper orderMapper;

    @PostMapping("/add")
    public ResponseEntity<PerfumeResponseDto> addPerfume(@RequestPart(name = "file", required = false) MultipartFile file,
                                                         @RequestPart("perfume") @Valid PerfumeRequestDto perfume,
                                                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        } else {
            return ResponseEntity.ok(perfumeMapper.savePerfume(perfume, file));
        }
    }

    @PutMapping("/edit")
    public ResponseEntity<PerfumeResponseDto> updatePerfume(@RequestPart(name = "file", required = false) MultipartFile file,
                                                            @RequestPart("perfume") @Valid PerfumeRequestDto perfume,
                                                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        } else {
            return ResponseEntity.ok(perfumeMapper.savePerfume(perfume, file));
        }
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderResponseDto>> getAllOrders() {
        return ResponseEntity.ok(orderMapper.findAllOrders());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable("id") Long userId) {
        return ResponseEntity.ok(userMapper.findUserById(userId));
    }

    @GetMapping("/user/all")
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        return ResponseEntity.ok(userMapper.findAllUsers());
    }

    @PutMapping("/user/edit")
    public ResponseEntity<String> updateUser(@RequestParam String username,
                                             @RequestParam Map<String, String> form,
                                             @RequestParam("userId") UserRequestDto userDto) {
        userMapper.userSave(username, form, userDto);
        return ResponseEntity.ok("User updated successfully.");
    }
}
