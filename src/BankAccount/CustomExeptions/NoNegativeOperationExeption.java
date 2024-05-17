package BankAccount.CustomExeptions;

public class NoNegativeOperationExeption extends Exception{

    public NoNegativeOperationExeption(String message) {
        super(message);
    }
}
