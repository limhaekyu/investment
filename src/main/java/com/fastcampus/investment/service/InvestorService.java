package com.fastcampus.investment.service;

import com.fastcampus.investment.dto.request.InvestmentRequestDto;
import com.fastcampus.investment.entity.Investor;
import com.fastcampus.investment.repository.InvestorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvestorService {

    private final InvestorRepository investorRepository;

    public Investor insertInvestmentReactInvestor(InvestmentRequestDto investmentRequestDto){

        Investor investor = investorRepository.findById(investmentRequestDto.getInvestorId()).orElseThrow(
                ()-> new IllegalArgumentException("투자자가 없습니다.")
        );

        return investor;
    }
}
