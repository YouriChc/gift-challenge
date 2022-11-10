package domain;

import domain.deposit.AbstractDeposit;
import domain.deposit.GiftDeposit;
import domain.deposit.MealDeposit;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String firstName;

    private String lastName;

    private List<AbstractDeposit> deposits;

    private Balance balance;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.deposits = new ArrayList<>();
        this.balance = new Balance();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<AbstractDeposit> getDeposits() {
        return deposits;
    }

    public void addDeposit(AbstractDeposit deposit) {
        this.deposits.add(deposit);
        if (deposit instanceof MealDeposit meal) {
            balance.setMealBalance(balance.getMealBalance() + meal.getAmount());
        } else if (deposit instanceof GiftDeposit gift) {
            balance.setGiftBalance(balance.getGiftBalance() + gift.getAmount());
        }
    }

    public Balance getBalance() {
        return balance;
    }
}
