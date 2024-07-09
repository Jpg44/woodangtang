package com.game.backend.store.hold;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hold")
public class userHoldController {
    private final userHoldService userHoldservice;
    @Autowired
    public userHoldController(userHoldService userHoldservice){
        this.userHoldservice = userHoldservice;
    }
    @PostMapping("/currencylist")
    public List<userHoldCurrencyDTO> userHoldCurrencyList(@RequestBody int userCode){
        return userHoldservice.userHoldCurrencyList(userCode);
    }
    @PostMapping("/goodslist")
    public List<userHoldGoodsDTO> userHoldGoodsList(@RequestBody int userCode){
        return userHoldservice.userHoldGoodsList(userCode);
    }
    @PutMapping("/update")
    public void userHoldCurrencyUpdate(@RequestBody currencyRequest currencyrequest){
        userHoldservice.userHoldCurrencyUpdate(currencyrequest);
    }


}
