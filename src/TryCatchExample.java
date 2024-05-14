import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatchExample {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x, y;

        try {
            System.out.print("First Number: ");
            x = sc.nextInt();
            sc.nextLine();

            System.out.print("Second Number: ");
            y = sc.nextInt();
            sc.nextLine();

            int result = x/y;
            System.out.println("Division result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("You can't divide by 0");
            e.printStackTrace();
        } catch (InputMismatchException e) {
            System.out.println("Text is not number lol");
            e.printStackTrace();
        }
    }
}