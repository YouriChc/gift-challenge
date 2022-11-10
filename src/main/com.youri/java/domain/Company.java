package domain;

import domain.deposit.AbstractDeposit;
import domain.exception.CompanyNotEnoughBalanceException;
import domain.exception.UserNotInTheCompanyException;

import java.util.HashSet;
import java.util.Set;

public class Company {

    private String name;

    private Long balance;

    private Set<User> users;

    public Company(String name, Long balance) {
        this.name = name;
        this.balance = balance;
        this.users = new HashSet<>();
    }

    public void addDepositToUser(User user, AbstractDeposit deposit) throws UserNotInTheCompanyException, CompanyNotEnoughBalanceException {
        if (users.contains(user)) {
            if (this.balance >= deposit.getAmount()) {
                user.addDeposit(deposit);
                this.balance = this.balance - deposit.getAmount();
            } else {
                throw new CompanyNotEnoughBalanceException("The company %s has not enough balance to add a new deposit to user %s".formatted(this.name, user.getLastName()));
            }
        } else {
            throw new UserNotInTheCompanyException("The user %s is not in the company %s".formatted(user.getLastName(), this.name));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }
}
