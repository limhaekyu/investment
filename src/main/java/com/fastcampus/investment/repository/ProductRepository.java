package com.fastcampus.investment.repository;

import com.fastcampus.investment.dto.response.InvestingPossibleProductResponseDto;
import com.fastcampus.investment.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select p from Product p where current_date >= p.startedAt and current_date < p.finishedAt")
//    @Query("select p from Product p where p.startedAt <= :currentDateTime and p.finishedAt > :currentDateTime")
    List<Product> findAllByInvestingPossibleProduct();
//
//    List<InvestingPossibleProductResponseDto> findAllByStartedAtAfterAndFinishedAtBefore(LocalDateTime now);


}
