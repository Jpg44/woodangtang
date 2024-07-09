package com.game.backend.store.currency;

import com.game.backend.store.goods.storeGoods;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class storeCurrency {
    @Id
    @GeneratedValue
    private int currencyCode;
    private String currencyName;
    @OneToMany(mappedBy = "storeCurrency")
    private List<storeGoods> storeGoods =new ArrayList<>();
}
