package com.gmail.goldlion.ecommerce.service;

import com.gmail.goldlion.ecommerce.domain.Order;
import com.gmail.goldlion.ecommerce.domain.User;

import java.util.List;


public interface OrderService {

    List<Order> findAll();

    Order save(Order order);

    List<Order> findOrderByUser(User user);

    Order postOrder(Order validOrder, User userSession);
}
