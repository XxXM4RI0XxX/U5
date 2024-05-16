package BankAccount;

public class ThrowsExceptionExercise {

    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount(1000);

        acc1.deposit(500);
        acc1.withdraw(1000);
        acc1.withdraw(1000);
        acc1.deposit(300);

        System.out.println(acc1);
    }

}

class BankAccount{

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

