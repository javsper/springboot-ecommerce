package com.gmail.goldlion.ecommerce.dto.order;

import com.gmail.goldlion.ecommerce.dto.perfume.PerfumeResponse;
import lombok.Data;

@Data
public class OrderItemResponse {
    private Long id;
    private Long amount;
    private Long quantity;
    private PerfumeResponse perfume;
}
