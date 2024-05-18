package BankAccount.CustomExeptions;

public class InsufficientFundsException extends Exception {

    public InsufficientFundsException() {
        System.out.println(">>> Insufficient founds to withdraw...");
    }
}
