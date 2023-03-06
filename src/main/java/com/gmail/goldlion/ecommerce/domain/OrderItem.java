package com.gmail.goldlion.ecommerce.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long amount;
    private Long quantity;

    @OneToOne
    private Perfume perfume;
}
