package com.gmail.goldlion.ecommerce.service;

import com.gmail.goldlion.ecommerce.domain.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {

    List<Order> findAll();

    List<Order> findOrderByEmail(String email);

    Order postOrder(Order validOrder, Map<Long, Long> perfumesId);

    Long finalizeOrder();
}
