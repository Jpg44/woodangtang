package com.game.backend.store.currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class storeCurrencyController {
    private final storeCurrencyService storeCurrencyservice;
    @Autowired
    public storeCurrencyController(storeCurrencyService storeCurrencyservice){
        this.storeCurrencyservice =storeCurrencyservice;
    }
    @PostMapping("/add")
    public storeCurrency storeCurrencyAdd(@RequestBody storeCurrency storecurrency){
        return storeCurrencyservice.currencyAdd(storecurrency);
    }
    @GetMapping("/list")
    public List<storeCurrency> storeCurrencyList(){
        return storeCurrencyservice.surrencyList();
    }

}
