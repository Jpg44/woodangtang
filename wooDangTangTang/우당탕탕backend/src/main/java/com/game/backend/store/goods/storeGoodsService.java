package com.game.backend.store.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class storeGoodsService {
    private final storeGoodsRepository storeGoodsrepository;
    @Autowired
    public storeGoodsService(storeGoodsRepository storeGoodsrepository){
        this.storeGoodsrepository = storeGoodsrepository;
    }
    public storeGoods storeGoodsAdd(storeGoods storegoods){
        return storeGoodsrepository.save(storegoods);
    }
    public List<storeGoods>storeGoodsList(){
        return storeGoodsrepository.findAll();
    }
    public List<storeGoods>storeGoodsTypeList(String goodsType){
        return storeGoodsrepository.findAllByGoodsType(goodsType);
    }
}
