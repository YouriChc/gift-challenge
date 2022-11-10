package domain.deposit;

import java.time.LocalDate;

public class GiftDeposit extends AbstractDeposit {

    private static final long LIFESPAN_DAYS = 365;

    public GiftDeposit(Long amount) {
        super(amount);
    }

    @Override
    public void calculateExpireDate() {
        this.setExpireDate(LocalDate.now().plusDays(LIFESPAN_DAYS));
    }
}
