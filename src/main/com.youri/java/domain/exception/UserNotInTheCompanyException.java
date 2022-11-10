package domain.exception;

public class UserNotInTheCompanyException extends Throwable {

    public UserNotInTheCompanyException(String message) {
        super(message);
    }
}
