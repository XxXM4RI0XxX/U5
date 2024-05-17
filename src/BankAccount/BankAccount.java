package BankAccount;

public class BankAccount{

    double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount){
        if(amount<0){
            throw new IllegalArgumentException(">>>Invalid deposit...");
        }
        balance+=amount;
        System.out.println("Succesfully deposit $"+amount);
    }

    public void withdraw (double amount) {
            if (amount>balance||amount<0) {
                throw new IllegalArgumentException(">>>Invalid withdraw");
            }
            balance-=amount;
        System.out.println("Successfully withdrawed $"+amount);
    }

    @Override
    public String toString() {
        return "Balance: $"+balance;
    }
}
