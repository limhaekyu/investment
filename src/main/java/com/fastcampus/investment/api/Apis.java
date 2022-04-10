package com.fastcampus.investment.api;

import com.fastcampus.investment.dto.request.InvestmentRequestDto;
import com.fastcampus.investment.dto.response.InvestedProductResponseDto;
import com.fastcampus.investment.dto.response.InvestingPossibleProductResponseDto;
import com.fastcampus.investment.entity.Investor;
import com.fastcampus.investment.global.ApiResponseDto;
import com.fastcampus.investment.service.InvestmentService;
import com.fastcampus.investment.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class Apis {
    // TODO: start

    private final ProductService productService;
    private final InvestmentService investmentService;

    @GetMapping("/product")
    public ApiResponseDto<List<InvestingPossibleProductResponseDto>> searchPossibleProduct(){
        List<InvestingPossibleProductResponseDto> productList = productService.getSearchPossibleProducts();

        System.out.println(productList);
        return ApiResponseDto.of(productList);
    }

    @PostMapping("/investment")
    public void insertInvestment(@RequestHeader("X-USER-ID") Long investorId, @RequestParam("productId") Long productId,
                                 @RequestParam("investAmount") Long investAmount){

        InvestmentRequestDto investmentRequestDto = InvestmentRequestDto.builder()
                .investorId(investorId)
                .productId(productId)
                .investmentAmount(investAmount)
                .build();

         investmentService.insertInvestment(investmentRequestDto);


    }

    @GetMapping("/investment")
    public ApiResponseDto<List<InvestedProductResponseDto>> searchInvestmentList(@RequestHeader("X-USER-ID") Long investorId){

        List<InvestedProductResponseDto> investedProductList = investmentService.getSearchInvestment(investorId);
        System.out.println(investedProductList);
        return ApiResponseDto.of(investedProductList);
    }

    @PutMapping("/investment/{id}")
    public void putInvestment(@PathVariable int id){

    }


}
