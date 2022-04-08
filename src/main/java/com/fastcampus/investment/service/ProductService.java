package com.fastcampus.investment.service;

import com.fastcampus.investment.dto.request.InsertInvestmentReactProductRequestDto;
import com.fastcampus.investment.dto.request.InvestmentRequestDto;
import com.fastcampus.investment.dto.response.InvestingPossibleProductResponseDto;
import com.fastcampus.investment.entity.Product;
import com.fastcampus.investment.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public List<InvestingPossibleProductResponseDto> getSearchPossibleProducts() {

        return productRepository.findAllByInvestingPossibleProduct().stream()
                .map(InvestingPossibleProductResponseDto::fromEntity).collect(Collectors.toList());

    }

    public Product insertInvestmentReactProduct(InvestmentRequestDto investmentRequestDto){
        Product product = productRepository.findById(investmentRequestDto.getProductId()).orElseThrow(
                ()-> new IllegalArgumentException("상품이 없습니다.")
        );

        if(product.getTotalInvestAmount()-product.getInvestedAmount()- investmentRequestDto.getInvestmentAmount() > 0){

            InsertInvestmentReactProductRequestDto insertInvestmentReactProductRequestDto = InsertInvestmentReactProductRequestDto.builder()
                    .productId(investmentRequestDto.getProductId())
                    .investedCount(product.getInvestedCount()+1)
                    .investmentAmount(product.getInvestedAmount()+ investmentRequestDto.getInvestmentAmount())
                    .build();

            product.insertInvestmentReactProduct(insertInvestmentReactProductRequestDto);

            return product;
        } else{
            return null;
        }

    }

}
