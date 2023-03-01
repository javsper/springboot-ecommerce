package com.gmail.goldlion.ecommerce.repository;

import com.gmail.goldlion.ecommerce.domain.Order;
import com.gmail.goldlion.ecommerce.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findOrderByUser(User user);
}
