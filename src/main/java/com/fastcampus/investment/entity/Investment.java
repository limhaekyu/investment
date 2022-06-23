package com.fastcampus.investment.entity;

import com.fastcampus.investment.dto.request.InvestmentRequestDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "investment")
public class Investment {

    @Id
    @Column(name = "investment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "investor_id")
    @JsonManagedReference
    private Investor investor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    @JsonManagedReference
    private Product product;

    @Column(name = "investment_amount", columnDefinition = "long default 0L")
    private Long investmentAmount;

    @Column(name = "investment_status", columnDefinition = "varChar(32) default 'INVESTED'")
    @Enumerated(EnumType.STRING)
    private InvestmentStatus investmentStatus = InvestmentStatus.INVESTED;

    @Column(name = "investment_at")
    private LocalDate investmentAt = LocalDate.now();

    public void insertInvestmentSuccess(Long investmentAmount, Investor investor, Product product){
        this.investmentAmount = investmentAmount;
        this.investor = investor;
        this.product = product;
    }

    public void insertInvestmentFail(Long investmentAmount, Investor investor, Product product, InvestmentStatus investmentStatus){
        this.investmentAmount = investmentAmount;
        this.investor = investor;
        this.product = product;
        this.investmentStatus = investmentStatus;
    }
}
