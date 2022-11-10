package com.youri.domain.deposit;

import domain.deposit.MealDeposit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class MealDepositTest {

    @Test
    @DisplayName("When instantiate meal deposit then it has the right expire date")
    void right_expire_date() {
        // given
        LocalDate expectedDate = LocalDate.now()
                .plusYears(1)
                .withMonth(2);
        expectedDate = expectedDate.withDayOfMonth(expectedDate.getMonth().length(expectedDate.isLeapYear()));

        // when
        MealDeposit mealDeposit = new MealDeposit(50L);

        // then
        Assertions.assertEquals(50, mealDeposit.getAmount(), "Not the expected amount");
        Assertions.assertEquals(expectedDate, mealDeposit.getExpireDate());
    }
}
