package com.fastcampus.investment.repository;

import com.fastcampus.investment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
