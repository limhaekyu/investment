package com.fastcampus.investment.service;

import com.fastcampus.investment.dto.request.InvestmentRequestDto;
import com.fastcampus.investment.entity.Investment;
import com.fastcampus.investment.entity.Investor;
import com.fastcampus.investment.entity.Product;
import com.fastcampus.investment.repository.InvestmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class InvestmentService {

    private final InvestmentRepository investmentRepository;
    private final ProductService productService;
    private final InvestorService investorService;

    @Transactional
    public void insertInvestment(InvestmentRequestDto investmentRequestDto) {

        Product product = productService.insertInvestmentReactProduct(investmentRequestDto);
        Investor investor = investorService.insertInvestmentReactInvestor(investmentRequestDto);

        Investment investment = new Investment();

        investment.insertInvestment(
                investmentRequestDto.getInvestmentAmount(),
                investor,
                product
        );

        investmentRepository.save(investment);

    }
}
