package domain;

public class Balance {

    private Long mealBalance;

    private Long giftBalance;

    public Balance() {
        this.mealBalance = 0L;
        this.giftBalance = 0L;
    }

    public Long getMealBalance() {
        return mealBalance;
    }

    public void setMealBalance(Long mealBalance) {
        this.mealBalance = mealBalance;
    }

    public Long getGiftBalance() {
        return giftBalance;
    }

    public void setGiftBalance(Long giftBalance) {
        this.giftBalance = giftBalance;
    }
}
