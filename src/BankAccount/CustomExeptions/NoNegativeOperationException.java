package BankAccount.CustomExeptions;

public class NoNegativeOperationException extends Exception{

    public NoNegativeOperationException() {
        System.out.println(">>> Negative operator detected, try again...");
    }

}
