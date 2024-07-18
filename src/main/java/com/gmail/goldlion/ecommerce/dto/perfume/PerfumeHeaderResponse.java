package com.gmail.goldlion.ecommerce.dto.perfume;

import java.util.List;

import org.springframework.http.HttpHeaders;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PerfumeHeaderResponse {
    private List<PerfumeResponse> perfumes;
    private HttpHeaders headers;
}
