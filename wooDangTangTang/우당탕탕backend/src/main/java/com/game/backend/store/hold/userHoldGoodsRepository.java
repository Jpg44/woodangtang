package com.game.backend.store.hold;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface userHoldGoodsRepository extends JpaRepository<userHoldGoods,Integer> {
    List<userHoldGoods> findAllByUserUserCode(int userCode);

    int findCurrentCodeByStoregoodsGoodsCode(int goodsCode);
}
