package Examples;

public class Throws {

    public static void main(String[] args) {
        try {
            double result = sqrt(-5);
            System.out.println("RESULT: " + result);
        } catch(IllegalArgumentException e) {
            System.out.println("Not valid argument");
        } finally {
            System.out.println("END OF EXECUTION");
        }

    }

    public static double sqrt(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Negative numbers don't have square roots");
        }
        return Math.sqrt(num);
    }

}
