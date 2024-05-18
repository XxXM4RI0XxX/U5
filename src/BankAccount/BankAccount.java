package BankAccount;

import BankAccount.CustomExeptions.InsufficientFundsException;
import BankAccount.CustomExeptions.NoNegativeOperationException;

public class BankAccount{

    double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) throws NoNegativeOperationException {
        if(amount<0){
            throw new NoNegativeOperationException();
        }
        balance+=amount;
        System.out.println(">>> Successfully deposit $"+amount);
    }

    public void withdraw (double amount) throws InsufficientFundsException, NoNegativeOperationException {
            if (amount>balance) {
                throw new InsufficientFundsException();
            } else if (amount<0) {
                throw new NoNegativeOperationException();
            }
        balance-=amount;
        System.out.println(">>> Successfully withdraw $"+amount);
    }

    @Override
    public String toString() {
        return "Balance: $"+balance;
    }
}
