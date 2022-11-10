package com.youri.domain.deposit;

import domain.deposit.GiftDeposit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class GiftDepositTest {


    @Test
    @DisplayName("When instantiate gift deposit then it has the right expire date")
    void right_expire_date() {
        // given
        LocalDate expectedDate = LocalDate.now().plusDays(365);

        // when
        GiftDeposit giftDeposit = new GiftDeposit(100L);

        // then
        Assertions.assertEquals(100, giftDeposit.getAmount(), "Not the expected amount");
        Assertions.assertEquals(expectedDate, giftDeposit.getExpireDate());
    }
}
