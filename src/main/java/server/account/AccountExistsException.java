package server.account;

public class AccountExistsException extends RuntimeException {
    public AccountExistsException() {
        super("account is exists");
    }
}
