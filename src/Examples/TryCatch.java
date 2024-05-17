//programing.guide/java/list-of-java-exceptions.html
//Todas las exepciones que tiene el JDK de java

package Examples;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatch {
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

            int result = x / y;
            System.out.println("Division result: " + result);



//        } catch (ArithmeticException e) {
//            System.out.println("Cannot divide by 0");
//            e.printStackTrace();
//        } catch (InputMismatchException e) {
//            System.out.println("String cannot be parsed to number");
//            e.printStackTrace();
//        }
        } catch (ArithmeticException | InputMismatchException e) {
            System.out.println("Invalid Input");
            e.printStackTrace();
        }
    }
}