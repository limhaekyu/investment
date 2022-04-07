package com.fastcampus.investment.api;

import com.fastcampus.investment.dto.response.InvestingPossibleProductResponseDto;
import com.fastcampus.investment.entity.Product;
import com.fastcampus.investment.global.ApiResponseDto;
import com.fastcampus.investment.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class Apis {
    // TODO: start

    private final ProductService productService;

    @GetMapping("/product")
    public ApiResponseDto<List<InvestingPossibleProductResponseDto>> searchPossibleProduct(){
        List<InvestingPossibleProductResponseDto> productList = productService.getSearchPossibleProducts();
        System.out.println(productList);
        return ApiResponseDto.of(productList);
    }

    @PostMapping("/investment")
    public void postInvestment(){

    }

    @PutMapping("/investment/{id}")
    public void putInvestment(@PathVariable int id){

    }


}
