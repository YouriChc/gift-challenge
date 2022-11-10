package domain.deposit;

import java.time.LocalDate;

public abstract class AbstractDeposit {

    private Long amount;

    private LocalDate expireDate;

    public AbstractDeposit(Long amount) {
        this.amount = amount;
        calculateExpireDate();
    }

    public abstract void calculateExpireDate();

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }
}
