package Catalogo;

import java.util.Random;

public class Product {
//    static Random ran = new Random();

    private int id;
    private String name;
    private double price;
    private String description;

    public Product(int id, String name, double price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // Prueba para llenar automaticamente los productos
//    public Product(){
//
//    }
//
//    public void generateRandom(){
//        id = ran.nextInt(0, 3000);
//        name = "nombre" + ran.nextInt(0, 3000);
//        description = "desc" + ran.nextInt(0, 3000);
//        price = ran.nextDouble(30, 501);
//    }
//

    public void printProduct(){
        if(id<10) System.out.printf("  %s | %-14s | %.2f | %s\n",id,name,price,description);
        else if(id<100) System.out.printf(" %s | %-14s | %.2f | %s\n",id,name,price,description);
        else System.out.printf("%s | %-14s | %.2f | %s\n",id,name,price,description);
    }

    public String toString() {
        return id+" | "+name+" | "+price+" | "+description;
    }

    //GETTERS

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
