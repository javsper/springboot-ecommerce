package com.gmail.goldlion.ecommerce.service;

import com.gmail.goldlion.ecommerce.domain.Order;
import com.gmail.goldlion.ecommerce.domain.User;

import java.util.List;

public interface OrderService {

    List<Order> findAll();

    List<Order> findOrderByEmail(String email);

    Order postOrder(Order validOrder);

    Order save(Order order);

    Long finalizeOrder();
}
