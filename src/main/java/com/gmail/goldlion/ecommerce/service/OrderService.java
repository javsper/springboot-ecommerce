package com.gmail.goldlion.ecommerce.service;

import com.gmail.goldlion.ecommerce.domain.Order;
import com.gmail.goldlion.ecommerce.domain.User;

import java.util.List;


public interface OrderService {

    List<Order> findAll();

    List<Order> findOrderByUser(User user);

    Order postOrder(Order validOrder, String email);

    Order save(Order order);
}
