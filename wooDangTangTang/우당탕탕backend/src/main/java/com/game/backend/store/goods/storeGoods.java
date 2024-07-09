package com.game.backend.store.goods;

import com.game.backend.store.currency.storeCurrency;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class storeGoods {
    @Id
    @GeneratedValue
    private int goodsCode;
    private String goodsName;
    private String goodsType;
    private int goodsPrice;
    @ManyToOne
    @JoinColumn(name = "currencyCode",referencedColumnName = "currencyCode")
    storeCurrency storeCurrency;

}
