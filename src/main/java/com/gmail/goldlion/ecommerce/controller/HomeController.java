package com.gmail.goldlion.ecommerce.controller;

import com.gmail.goldlion.ecommerce.dto.perfume.PerfumeDtoOut;
import com.gmail.goldlion.ecommerce.mapper.PerfumeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/home")
public class HomeController {

    private final PerfumeMapper perfumeMapper;

    @GetMapping
    public ResponseEntity<List<PerfumeDtoOut>> getAllPerfumes() {
        return ResponseEntity.ok(perfumeMapper.findAllPerfumes());
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<PerfumeDtoOut> getPerfume(@PathVariable("id") Long perfumeId) {
        return ResponseEntity.ok(perfumeMapper.findPerfumeById(perfumeId));
    }
}
