package BankAccount.CustomExeptions;

public class InsufficientFundsExeption extends Exception {

    public InsufficientFundsExeption(String message) {
        super(message);
    }
}
