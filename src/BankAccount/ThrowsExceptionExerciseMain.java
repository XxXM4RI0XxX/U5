package BankAccount;

import java.util.HashMap;
import java.util.Scanner;

public class ThrowsExceptionExerciseMain {

    public static void main(String[] args) {
        Scanner q = new Scanner(System.in);

        BankAccount account = new BankAccount(1000);

        HashMap<Integer,Menu> menu = new HashMap<>();

        menu.put(1, new Menu() {
            @Override
            public void execute() {
                account.deposit(q.nextInt());
            }
        });
        menu.put(2, new Menu() {
            @Override
            public void execute() {
                account.withdraw(q.nextInt());
            }
        });

        boolean flag = true;

        do {
            System.out.println("---OPERATIONS---\nBalance: $"+account.balance);
            System.out.println("1) Deposit\n2) Withdraw\n0) Exit");
            int opt = q.nextInt();

            if(opt!=0){
                menu.get(opt);
            }else flag=false;
        }while (flag);

        //uwu
    }

}

