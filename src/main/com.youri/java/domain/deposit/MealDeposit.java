package domain.deposit;

import java.time.LocalDate;

public class MealDeposit extends AbstractDeposit {

    public MealDeposit(Long amount) {
        super(amount);
    }

    @Override
    public void calculateExpireDate() {
        LocalDate expireDate = LocalDate.now()
                .plusYears(1)
                .withMonth(2);
        this.setExpireDate(expireDate.withDayOfMonth(expireDate.getMonth().length(expireDate.isLeapYear())));
    }
}
