package com.fastcampus.investment.repository;

import com.fastcampus.investment.entity.Investor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestorRepository extends JpaRepository<Investor, Long> {
}
