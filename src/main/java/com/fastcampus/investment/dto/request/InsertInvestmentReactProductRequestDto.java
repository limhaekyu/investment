package com.fastcampus.investment.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InsertInvestmentReactProductRequestDto {
    private Long productId;
    private Long investmentAmount;
    private Integer investedCount;
}
