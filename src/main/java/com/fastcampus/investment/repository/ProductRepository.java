package com.fastcampus.investment.repository;

import com.fastcampus.investment.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
