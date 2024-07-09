package com.game.backend.store.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class storeGoodsController {
    private final storeGoodsService storeGoodsservice;
    @Autowired
    public storeGoodsController(storeGoodsService storeGoodsservice){
        this.storeGoodsservice =storeGoodsservice;
    }
    @PostMapping("/add")
    public storeGoods storeGoodsAdd(@RequestBody storeGoods storegoods){
        return storeGoodsservice.storeGoodsAdd(storegoods);
    }
    @GetMapping("/list")
    public List<storeGoods> storeGoodsList(){
        return storeGoodsservice.storeGoodsList();
    }
    @PostMapping("/typelist")
    public List<storeGoods> storeGoodsTypeList(@RequestBody String goodsType){
        return storeGoodsservice.storeGoodsTypeList(goodsType);
    }
}
