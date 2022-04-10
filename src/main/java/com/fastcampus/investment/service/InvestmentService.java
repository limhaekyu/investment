package com.fastcampus.investment.service;

import com.fastcampus.investment.dto.request.InvestmentRequestDto;
import com.fastcampus.investment.dto.response.InvestedProductResponseDto;
import com.fastcampus.investment.dto.response.InvestingPossibleProductResponseDto;
import com.fastcampus.investment.entity.Investment;
import com.fastcampus.investment.entity.InvestmentStatus;
import com.fastcampus.investment.entity.Investor;
import com.fastcampus.investment.entity.Product;
import com.fastcampus.investment.repository.InvestmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class InvestmentService {

    private final InvestmentRepository investmentRepository;
    private final ProductService productService;
    private final InvestorService investorService;

    @Transactional
    public void insertInvestment(InvestmentRequestDto investmentRequestDto) {

        Product product = productService.insertInvestmentReactProduct(investmentRequestDto);
        Investor investor = investorService.searchInvestor(investmentRequestDto.getInvestorId());

        Investment investment = new Investment();
        if(investmentRequestDto.getInvestmentAmount() < (product.getTotalInvestAmount()- product.getInvestedAmount())) {
            investment.insertInvestmentSuccess(
                    investmentRequestDto.getInvestmentAmount(),
                    investor,
                    product
            );
        } else{
            investment.insertInvestmentFail(
                    investmentRequestDto.getInvestmentAmount(),
                    investor,
                    product,
                    InvestmentStatus.FAIL
            );
        }
        investmentRepository.save(investment);

    }

    @Transactional
    public List<InvestedProductResponseDto> getSearchInvestment(Long investorId) {

        Investor investor = investorService.searchInvestor(investorId);

        List<Investment> investmentList = investor.getInvestment();

        return investmentList.stream()
            .map(InvestedProductResponseDto::fromEntity).collect(Collectors.toList());


    }
}
