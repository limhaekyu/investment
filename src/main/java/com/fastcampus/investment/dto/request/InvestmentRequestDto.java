package com.fastcampus.investment.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvestmentRequestDto {
    private Long productId;
    private Long investorId;
    private Long investmentAmount;

}
