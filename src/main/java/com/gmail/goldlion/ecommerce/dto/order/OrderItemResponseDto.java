package com.gmail.goldlion.ecommerce.dto.order;

import com.gmail.goldlion.ecommerce.dto.perfume.PerfumeResponseDto;
import lombok.Data;

@Data
public class OrderItemResponseDto {
    private Long id;
    private Long amount;
    private Long quantity;
    private PerfumeResponseDto perfume;
}
