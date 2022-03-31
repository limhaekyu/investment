package com.fastcampus.investment.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class Apis {
    // TODO: start

    @GetMapping("/product")
    public void searchProduct(){

    }

    @PostMapping("/investment")
    public void postInvestment(){

    }

    @PutMapping("/investment/{id}")
    public void putInvestment(@PathVariable int id){

    }


}
