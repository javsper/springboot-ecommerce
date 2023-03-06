package com.gmail.goldlion.ecommerce.dto.order;

import com.gmail.goldlion.ecommerce.dto.perfume.PerfumeDtoOut;
import lombok.Data;

@Data
public class OrderItemDtoOut {
    private Long id;
    private Long amount;
    private Long quantity;
    private PerfumeDtoOut perfume;
}
