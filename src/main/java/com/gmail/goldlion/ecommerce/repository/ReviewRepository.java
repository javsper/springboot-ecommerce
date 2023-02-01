package com.gmail.goldlion.ecommerce.repository;

import com.gmail.goldlion.ecommerce.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * A repository for {@link Review} objects providing a set of JPA methods for working with the database.
 * Inherits interface {@link JpaRepository}.
 *
 * @author Miroslav Khotinskiy (goldlion@gmail.com)
 * @version 1.0
 * @see Review
 * @see JpaRepository
 */
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
