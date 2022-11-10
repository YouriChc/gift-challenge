package domain.exception;

public class CompanyNotEnoughBalanceException extends Throwable {

    public CompanyNotEnoughBalanceException(String message) {
        super(message);
    }
}
