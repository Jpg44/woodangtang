package com.game.backend.store.hold;

import com.game.backend.store.currency.storeCurrency;
import com.game.backend.user.users;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Currency;

@Entity
@Getter
@Setter
public class userHoldCurrency {
    @Id
    @GeneratedValue
    private int userHoldCurrencyCode;
    private int currencyValue;
    @ManyToOne
    @JoinColumn(name = "userCode")
    users user;
    @ManyToOne
    @JoinColumn(name = "currencyCode")
    storeCurrency storecurrency;
}
