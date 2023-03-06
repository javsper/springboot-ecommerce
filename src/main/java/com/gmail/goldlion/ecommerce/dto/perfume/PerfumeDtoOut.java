package com.gmail.goldlion.ecommerce.dto.perfume;

import com.gmail.goldlion.ecommerce.dto.review.ReviewDtoOut;
import lombok.Data;

import java.util.List;

@Data
public class PerfumeDtoOut {
    private Long id;
    private String perfumeTitle;
    private String perfumer;
    private Integer year;
    private String country;
    private String perfumeGender;
    private String fragranceTopNotes;
    private String fragranceMiddleNotes;
    private String fragranceBaseNotes;
    private String description;
    private String filename;
    private Integer price;
    private String volume;
    private String type;
    private List<ReviewDtoOut> reviews;
}
