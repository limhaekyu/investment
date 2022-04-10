package com.fastcampus.investment.dto.response;

import com.fastcampus.investment.entity.Investment;
import com.fastcampus.investment.entity.InvestmentStatus;
import com.fastcampus.investment.entity.Investor;
import com.fastcampus.investment.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvestedProductResponseDto {
    private Long id;
    private Product product;
    private Long investedAmount;
    private InvestmentStatus status;
    private LocalDate investedAt;

    public static InvestedProductResponseDto fromEntity(Investment investment){
        return InvestedProductResponseDto.builder()
                .id(investment.getId())
                .product(investment.getProduct())
                .investedAmount(investment.getInvestmentAmount())
                .status(investment.getInvestmentStatus())
                .investedAt(investment.getInvestmentAt())
                .build();
    }

}
