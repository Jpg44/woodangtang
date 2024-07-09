package com.game.backend.store.hold;

import com.game.backend.store.goods.storeGoods;
import com.game.backend.store.goods.storeGoodsRepository;
import com.game.backend.user.users;
import com.game.backend.user.usersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class userHoldService {
    private final userHoldCurrencyRepository userHoldCurrencyrepository;
    private final userHoldGoodsRepository userHoldGoodsrepository;
    private final storeGoodsRepository storeGoodsrepository;
    private final usersRepository usersrepository;
    @Autowired
    public userHoldService(userHoldCurrencyRepository userHoldCurrencyrepository,userHoldGoodsRepository userHoldGoodsrepository, storeGoodsRepository storeGoodsrepository,usersRepository usersrepository) {
        this.userHoldCurrencyrepository = userHoldCurrencyrepository;
        this.userHoldGoodsrepository = userHoldGoodsrepository;
        this.storeGoodsrepository = storeGoodsrepository;
        this.usersrepository=usersrepository;
    }
    public List<userHoldCurrencyDTO> userHoldCurrencyList(int userCode){
        List<userHoldCurrencyDTO> userHoldCurrencyDTOList =new ArrayList<>();
        List<userHoldCurrency> userHoldCurrencies =new ArrayList<>();
        userHoldCurrencies=userHoldCurrencyrepository.findAllByUserUserCode(userCode );
        for(userHoldCurrency userHoldcurrency:userHoldCurrencies){
            userHoldCurrencyDTO userHoldCurrencyDto =new userHoldCurrencyDTO();
            userHoldCurrencyDto.setCurrencyName(userHoldcurrency.getStorecurrency().getCurrencyName());
            userHoldCurrencyDto.setCurrencyValue(userHoldcurrency.getCurrencyValue());
            userHoldCurrencyDTOList.add(userHoldCurrencyDto);
        }
        return userHoldCurrencyDTOList;
    }
    public List<userHoldGoodsDTO> userHoldGoodsList(int userCode){
        List<userHoldGoodsDTO> userHoldGoodsDTOList = new ArrayList<>();
        List<userHoldGoods> userHoldGoodsList = new ArrayList<>();
        userHoldGoodsList = userHoldGoodsrepository.findAllByUserUserCode(userCode);
        for(userHoldGoods userHoldgoods:userHoldGoodsList){
            userHoldGoodsDTO userHoldGoodsDto = new userHoldGoodsDTO();
            userHoldGoodsDto.setGoodsName(userHoldgoods.getStoregoods().getGoodsName());
            userHoldGoodsDto.setGoodsType(userHoldgoods.getStoregoods().getGoodsType());
            userHoldGoodsDTOList.add(userHoldGoodsDto);
        }
        return userHoldGoodsDTOList;
    }
    public void userHoldGoodsAdd(userHoldGoods userHoldgoods){
        userHoldGoodsrepository.save(userHoldgoods);
    }
    public void userHoldCurrencyUpdate(currencyRequest currencyrequest){
        userHoldCurrency userHoldcurrency = new userHoldCurrency();
        userHoldGoods userHoldgoods=new userHoldGoods();
        userHoldcurrency = userHoldCurrencyrepository.findByUserUserCode(currencyrequest.getUserCode());
        Optional<users> optionalUser = usersrepository.findByUserCode(currencyrequest.getUserCode());
        Optional<storeGoods> optionalStoreGood=storeGoodsrepository.findByGoodsCode(currencyrequest.getGoodsCode());
        int userCurrencyValue=userHoldCurrencyrepository.findCurrencyValueByUserUserCodeAndStorecurrencyCurrencyCode(currencyrequest.getUserCode(),currencyrequest.getCurrencyCode());
        int goodsCode=userHoldGoodsrepository.findCurrentCodeByStoregoodsGoodsCode(currencyrequest.getGoodsCode());
        int goodsPrice=storeGoodsrepository.findGoodsPriceByGoodsCode(goodsCode);
        if(currencyrequest.getState().equals("get")){
            if(userCurrencyValue>=goodsPrice) {
                userHoldcurrency.setCurrencyValue(userCurrencyValue - goodsPrice);
                if(optionalUser.isPresent()&&optionalStoreGood.isPresent()){
                    users user =optionalUser.get();
                    storeGoods storeGood =optionalStoreGood.get();
                userHoldgoods.setUser(user);
                userHoldgoods.setStoregoods(storeGood);
                userHoldGoodsAdd(userHoldgoods);
                }
            }

        } else if (currencyrequest.getState().equals("win")) {
            userHoldcurrency.setCurrencyValue(userCurrencyValue+150);
        }
         userHoldCurrencyrepository.save(userHoldcurrency);
    }
}
