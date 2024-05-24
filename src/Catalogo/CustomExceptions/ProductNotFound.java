package Catalogo.CustomExceptions;

public class ProductNotFound extends Exception {

    public ProductNotFound(String message) {
        super(message);
        System.out.println(">>> Producto no encontrado :c");
    }
}
