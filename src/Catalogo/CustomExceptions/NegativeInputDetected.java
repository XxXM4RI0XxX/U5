package Catalogo.CustomExceptions;

public class NegativeInputDetected extends RuntimeException{

    public NegativeInputDetected() {
        System.out.println(">>> Negative not supported...");
    }
}
