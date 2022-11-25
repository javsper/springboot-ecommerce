package com.gmail.goldlion.ecommerce.repository;

import com.gmail.goldlion.ecommerce.domain.Order;
import com.gmail.goldlion.ecommerce.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * A repository for {@link Order} objects providing a set of JPA methods for working with the database.
 * Inherits interface {@link JpaRepository}.
 *
 * @author Miroslav Khotinskiy (goldlion@gmail.com)
 * @version 1.0
 * @see Order
 * @see JpaRepository
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
    /**
     * Returns list of orders authenticated user.
     *
     * @param user name of authenticated user.
     * @return An object of type {@link List} is a list of orders of authenticated user.
     */
    List<Order> findOrderByUser(User user);
}