package com.fastcampus.investment.dto.response;

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
public class InvestingPossibleProductResponseDto {
    private Long id;
    private String title;
    private Long totalInvestAmount;
    private Integer investedCount;
    private Long investedAmount;
    private LocalDate startedAt;
    private LocalDate finishedAt;

    public static InvestingPossibleProductResponseDto fromEntity(Product product){
        return InvestingPossibleProductResponseDto.builder()
                .id(product.getId())
                .title(product.getTitle())
                .totalInvestAmount(product.getTotalInvestAmount())
                .investedCount(product.getInvestedCount())
                .investedAmount(product.getInvestedAmount())
                .startedAt(product.getStartedAt())
                .finishedAt(product.getFinishedAt())
                .build();
    }
}
