package com.gmail.goldlion.ecommerce.controller.rest;

import com.gmail.goldlion.ecommerce.domain.Perfume;
import com.gmail.goldlion.ecommerce.dto.PerfumeSearchFilterDto;
import com.gmail.goldlion.ecommerce.service.PerfumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rest")
public class MenuRestController {

    private final PerfumeService perfumeService;

    @Autowired
    public MenuRestController(PerfumeService perfumeService) {
        this.perfumeService = perfumeService;
    }

    @PostMapping("/menu/search")
    public ResponseEntity<?> getProductsByFilterParams(@RequestBody PerfumeSearchFilterDto filterDto) {
        List<Perfume> filter = perfumeService.filter(filterDto.getPerfumers(), filterDto.getGenders(), filterDto.getPrices());

        return ResponseEntity.ok(filter);
    }

    @PostMapping("/menu/gender")
    public ResponseEntity<?> findByPerfumeGender(@RequestBody PerfumeSearchFilterDto filterDto) {
        List<Perfume> gender = perfumeService.findByPerfumeGenderOrderByPriceDesc(filterDto.getPerfumeGender());

        return ResponseEntity.ok(gender);
    }

    @PostMapping("/menu/perfumer")
    public ResponseEntity<?> findByPerfumer(@RequestBody PerfumeSearchFilterDto filterDto) {
        List<Perfume> gender = perfumeService.findByPerfumerOrderByPriceDesc(filterDto.getPerfumer());

        return ResponseEntity.ok(gender);
    }
}
