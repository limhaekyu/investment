package com.fastcampus.investment.repository;

import com.fastcampus.investment.entity.Invester;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvesterRepository extends JpaRepository<Invester, Long> {
}
