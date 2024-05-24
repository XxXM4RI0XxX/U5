package Catalogo.Util;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ConsoleReader {

    private static final Random r = new Random();
    private static final Scanner q = new Scanner(System.in);

    public static int genRandomInt(){
        return r.nextInt();
    }
    public static int genRandomInt(int origin, int bound){
        return r.nextInt(origin,bound);
    }
    public static double genRandomDecimal(){
        return r.nextDouble();
    }
    public static double genRandomDecimal(double origin, double bound){
        return r.nextDouble(origin,bound);
    }

    public static byte readByte(){
        byte number = 0;
        boolean flag=true;

        do {
            try {
                number = q.nextByte();
                return number;
            } catch (InputMismatchException e) {
                System.out.println(">>> Enter a valid number...");
                q.nextLine();
            }
        }while(flag);

        return number;
    }


    public static int readInt(){
        int number = 0;
        boolean flag=true;

        do {
            try {
                float x = q.nextFloat();
                q.nextLine();
                number = (int) x;
                return number;
            } catch (InputMismatchException e) {
                System.out.println(">>> Enter a valid number...");
                q.nextLine();
            }
        }while(flag);

        return number;
    }

    public static long readLong(){
        long number = 0;
        boolean flag=true;

        do {
            try {
                float x = q.nextFloat();
                number = (long) x;
                return number;
            } catch (InputMismatchException e) {
                System.out.println(">>> Enter a valid number...");
                q.nextLine();
            }
        }while(flag);

        return number;
    }

    public static float readFloat(){
        float number = 0;
        boolean flag = true;

        do{
            try {
                number = q.nextFloat();
                return number;
            } catch (InputMismatchException e){
                System.out.println(">>> Enter a valid number...");
                q.nextLine();
            }
        }while (flag);

        return number;
    }

    public static double readDouble(){
        double number = 0;
        boolean flag = true;

        do{
            try {
                number = q.nextDouble();
                q.nextLine();
                return number;
            } catch (InputMismatchException e){
                System.out.println(">>> Enter a valid number...");
                q.nextLine();
            }
        }while (flag);

        return number;
    }

    public static char readChar(){
        char character = ' ';
        boolean flag = true;

        do {
            String value = q.nextLine();
            if(value.length()>2){
                System.out.println(">>> Enter a valid character...");
            } else if (value.isEmpty()) {
                value = q.nextLine();
                return  value.charAt(0);
            } else {
                return value.charAt(0);
            }
        }while (flag);

        return character;
    }

    public static String readString(int maxLength){ //maxLength = 0 for any length
        String line;

        if(maxLength>0){
            do{
                line = q.nextLine();
                if(line.length()>maxLength)
                    System.out.println(">>> Invalid length...");
                else return line;
            }while (line.length()>maxLength);
        }
        else{
            line = q.nextLine();
            return line;
        }return line;
    }

}
