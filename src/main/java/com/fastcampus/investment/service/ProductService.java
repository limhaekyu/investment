package com.fastcampus.investment.service;

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
}
