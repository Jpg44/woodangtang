package com.game.backend.store.currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class storeCurrencyService {
    private final storeCurrencyRepository storeCurrencyrepository;
    @Autowired
    public storeCurrencyService(storeCurrencyRepository storeCurrencyrepository){
        this.storeCurrencyrepository = storeCurrencyrepository;
    }
    public storeCurrency currencyAdd(storeCurrency storecurrency){
        return storeCurrencyrepository.save(storecurrency);
    }
    public List<storeCurrency> surrencyList(){
        return storeCurrencyrepository.findAll();
    }
}
