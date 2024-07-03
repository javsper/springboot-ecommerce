package com.gmail.goldlion.ecommerce.dto.perfume;

import com.gmail.goldlion.ecommerce.enums.SearchPerfume;
import lombok.Data;

@Data
public class SearchTypeRequest {
    private SearchPerfume searchType;
    private String text;
}
