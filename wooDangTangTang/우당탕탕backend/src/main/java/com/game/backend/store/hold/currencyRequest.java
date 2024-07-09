package com.game.backend.store.hold;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class currencyRequest {
    private int goodsCode;
    private int userCode;
    private String state;
    private int currencyCode;
}
