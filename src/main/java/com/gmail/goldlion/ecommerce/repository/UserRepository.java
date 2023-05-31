package com.gmail.goldlion.ecommerce.repository;

import com.gmail.goldlion.ecommerce.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByOrderByIdAsc();

    User findByActivationCode(String code);

    User findByEmail(String email);

    User findByPasswordResetCode(String code);
}
