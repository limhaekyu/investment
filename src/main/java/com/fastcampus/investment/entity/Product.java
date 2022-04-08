package com.fastcampus.investment.entity;

import com.fastcampus.investment.dto.request.InsertInvestmentReactProductRequestDto;
import com.fastcampus.investment.dto.request.InvestmentRequestDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "total_invest_amount")
    private Long totalInvestAmount;

    @Column(name = "invested_amount", columnDefinition = "long default 0L")
    private Long investedAmount;

    @Column(name = "invested_count", columnDefinition = "integer default 0")
    private Integer investedCount;

    @Column(name = "started_at")
    private LocalDate startedAt;

    @Column(name = "finished_at")
    private LocalDate finishedAt;

    @JsonBackReference
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Investment> investment = new ArrayList<>();

    public void insertInvestmentReactProduct(InsertInvestmentReactProductRequestDto insertInvestmentReactProductRequestDto){
        this.id = insertInvestmentReactProductRequestDto.getProductId();
        this.investedCount = insertInvestmentReactProductRequestDto.getInvestedCount();
        this.investedAmount = insertInvestmentReactProductRequestDto.getInvestmentAmount();
    }
}
