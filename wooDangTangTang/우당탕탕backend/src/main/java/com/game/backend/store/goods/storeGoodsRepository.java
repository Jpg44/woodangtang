package com.game.backend.store.goods;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface storeGoodsRepository extends JpaRepository<storeGoods,Integer> {
    List<storeGoods> findAllByGoodsType(String goodsType);

    int findGoodsPriceByGoodsCode(int goodsCode);

    Optional<storeGoods> findByGoodsCode(int goodsCode);
}
