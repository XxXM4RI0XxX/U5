package BankAccount;

import BankAccount.CustomExeptions.InsufficientFundsException;
import BankAccount.CustomExeptions.NoNegativeOperationException;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ThrowsExceptionExerciseMain {

    public static void main(String[] args) {
        Scanner q = new Scanner(System.in);

        BankAccount account = new BankAccount(1000);

        HashMap<Integer,Menu> menus = Seeder.seedMenus(account);

        boolean flag = true;
        do {
            try {
                System.out.printf("---OPERATIONS---\nBalance: $%.2f\n",account.balance);
                System.out.println("1) Deposit\n2) Withdraw\n0) Exit");
                int opt = q.nextInt();

                if (opt != 0) {
                    Menu menu = menus.get(opt);
                    menu.execute();
                } else flag = false;

            } catch (NullPointerException | InputMismatchException e) {
                System.out.println(">>> Invalid input...");
                q.nextLine();
            }
        }while (flag);

        System.out.println("-----Bai :3-----");
    }

}

class Seeder {

    public static HashMap<Integer,Menu> seedMenus(BankAccount account){
        Scanner q = new Scanner(System.in);
        HashMap<Integer,Menu> menus = new HashMap<>();

        menus.put(1, () -> {
                try {
                    System.out.print("How much you want to deposit?\n> $");
                    account.deposit(q.nextDouble());
                }catch (NoNegativeOperationException e){
                    q.nextLine();
                }catch (InputMismatchException _){
                    System.out.println(">>> Invalid input...");
                    q.nextLine();
                }

        });
        menus.put(2, () -> {
                    try {
                        System.out.print("How much you want to withdraw?\n> $");
                        account.withdraw(q.nextDouble());
                    } catch (NoNegativeOperationException | InsufficientFundsException _) {
                    } catch (InputMismatchException _) {
                        System.out.println(">>> Invalid input...");
                        q.nextLine();
                    }
                }
        );

        return menus;
    }

}

