package com.youri.domain;

import domain.User;
import domain.deposit.GiftDeposit;
import domain.deposit.MealDeposit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    @DisplayName("When user have different deposit then balance will be updated")
    void user_s_different_balance_deposit() {
        // given
        User user = new User("Julien", "Dujardin");
        MealDeposit mealDeposit = new MealDeposit(50L);
        MealDeposit mealDeposit2 = new MealDeposit(30L);
        GiftDeposit giftDeposit = new GiftDeposit(100L);

        // when
        user.addDeposit(mealDeposit);
        user.addDeposit(giftDeposit);
        user.addDeposit(mealDeposit2);

        // then
        Assertions.assertEquals(80L, user.getBalance().getMealBalance());
        Assertions.assertEquals(100L, user.getBalance().getGiftBalance());
    }
}
