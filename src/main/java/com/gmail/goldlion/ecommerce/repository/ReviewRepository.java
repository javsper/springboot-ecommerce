package com.gmail.goldlion.ecommerce.repository;

import com.gmail.goldlion.ecommerce.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
