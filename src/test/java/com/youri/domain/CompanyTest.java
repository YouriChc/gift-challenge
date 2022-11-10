package com.youri.domain;

import domain.Company;
import domain.User;
import domain.deposit.GiftDeposit;
import domain.exception.CompanyNotEnoughBalanceException;
import domain.exception.UserNotInTheCompanyException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class CompanyTest {

    @Test
    @DisplayName("When company has enough balance and the user is in company then user have a new deposit")
    void company_add_new_deposit_to__user() throws UserNotInTheCompanyException, CompanyNotEnoughBalanceException {
        // given
        GiftDeposit giftDeposit = new GiftDeposit(100L);
        User user = new User("Jean", "Dupont");
        Company company = new Company("Capee", 1000L);

        // when
        company.addUser(user);
        company.addDepositToUser(user, giftDeposit);

        // then
        Assertions.assertEquals(900, company.getBalance());
        Assertions.assertEquals(Set.of(user), company.getUsers());
        Assertions.assertEquals(giftDeposit, user.getDeposits().get(0));
    }

    @Test
    @DisplayName("When user not in company then throw error")
    void user_not_in_the_company() {
        // given
        GiftDeposit giftDeposit = new GiftDeposit(100L);
        User user = new User("Jean", "Dupont");
        Company company = new Company("Capee", 1000L);

        // when then
        UserNotInTheCompanyException exception = Assertions.assertThrows(UserNotInTheCompanyException.class, () -> company.addDepositToUser(user, giftDeposit));
        Assertions.assertEquals("The user Dupont is not in the company Capee", exception.getMessage());
    }

    @Test
    @DisplayName("When company has not enough balance then throw error")
    void company_has_not_enough_balance() {
        // given
        GiftDeposit giftDeposit = new GiftDeposit(100L);
        User user = new User("Jean", "Dupont");
        Company company = new Company("Capee", 50L);
        company.addUser(user);

        // when then
        CompanyNotEnoughBalanceException exception = Assertions.assertThrows(CompanyNotEnoughBalanceException.class, () -> company.addDepositToUser(user, giftDeposit));
        Assertions.assertEquals("The company Capee has not enough balance to add a new deposit to user Dupont", exception.getMessage());
    }
}
