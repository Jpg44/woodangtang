package com.game.backend.store.hold;

import com.game.backend.store.goods.storeGoods;
import com.game.backend.user.users;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class userHoldGoods {
    @Id
    @GeneratedValue
    private int userHoldGoodsCode;
    @ManyToOne
    @JoinColumn(name = "userCode",referencedColumnName = "userCode")
    users user;
    @ManyToOne
    @JoinColumn(name = "goodsCode",referencedColumnName = "goodsCode")
    storeGoods storegoods;

}
