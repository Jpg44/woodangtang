package com.game.backend.store.hold;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface userHoldCurrencyRepository extends JpaRepository<userHoldCurrency ,Integer> {
    List<userHoldCurrency> findAllByUserUserCode(int userCode);

    int findCurrencyValueByUserUserCodeAndStorecurrencyCurrencyCode(int userCode, int currencyCode);

    userHoldCurrency findByUserUserCode(int userCode);
}
