package Catalogo.CustomExceptions;

public class BlankSpaceDetected extends RuntimeException{

    public BlankSpaceDetected() {
        System.out.println(">>> Fill with somehing...");
    }
}
