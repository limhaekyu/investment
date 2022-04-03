package com.fastcampus.investment.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "investment")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Investment {

    @Id
    @Column(name = "investment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invester_id")
    @JsonManagedReference
    private Invester invester;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @JsonManagedReference
    private Product product;

    @Column(name = "investment_amount")
    private Long investmentAmount;

    @Column(name = "investment_status")
    private InvestmentStatus investmentStatus = InvestmentStatus.INVESTMENT_POSSIBAL;

    @Column(name = "investment_at")
    private LocalDateTime investmentAt = LocalDateTime.now();




}
