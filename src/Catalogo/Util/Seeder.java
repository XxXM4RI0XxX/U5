package Catalogo.Util;

import Catalogo.Catalog;
import Catalogo.CustomExceptions.BlankSpaceDetected;
import Catalogo.CustomExceptions.NegativeInputDetected;
import Catalogo.CustomExceptions.ProductNotFound;
import Catalogo.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Seeder {

    public static HashMap<Integer,Menu> getMenus(){

        HashMap<Integer,Menu> menus = new HashMap<>();

        menus.put(1, () -> { //Añadir producto


                System.out.println("<<<Añadiendo producto>>>");

                try {
                    System.out.print("Nombre: ");
                    String name = ConsoleReader.readString(0);
                    if(name.isBlank()){
                        throw new BlankSpaceDetected();
                    }
                    System.out.print("Precio: ");
                    double price = ConsoleReader.readDouble();
                    if(price<0) {
                        throw new NegativeInputDetected();
                    }
                    System.out.print("Descripcion: ");
                    String description = ConsoleReader.readString(0);
                    if(description.isBlank()){
                        throw new BlankSpaceDetected();
                    }

                    Product product = new Product(Catalog.getProductsSize() + 1, name, price, description);

                    Catalog.addProduct(product);
                    System.out.println("> Producto añadido existosamente");
                }catch (NegativeInputDetected | BlankSpaceDetected _){}

        });

        menus.put(2, () -> { //See products

            HashMap<Integer,Menu> subMenu = new HashMap<>();

            subMenu.put(1, () -> {
                
                System.out.print("ID del producto: ");
                int id = ConsoleReader.readInt();
                Product product = Catalog.findById(id);
                product.printProduct();;

            });
            subMenu.put(2, () ->{
                
                    System.out.print("Nombre del producto: ");
                    String name = ConsoleReader.readString(0);
                    Product product = Catalog.findByName(name);
                    System.out.printf("%2s%-2s|%8s%-8s|%10s%-10s|%s\n","I","D","Nom","bre","Pre","cio","Descripci�n");
                    product.printProduct();
                ;
            });
            subMenu.put(3, () ->{
               
                   System.out.print("Descripcion del producto: ");
                   String desc = ConsoleReader.readString(0);
                   Product[] products = Catalog.searchByDescription(desc);
                   System.out.printf("%2s%-2s|%8s%-8s|%10s%-10s|%s\n","I","D","Nom","bre","Pre","cio","Descripci�n");
                   for(Product product : products){
                       product.printProduct();
                   }

            });
            subMenu.put(4, () -> {
                System.out.println("Mostrando productos...");
                System.out.printf("%2s%-2s|%8s%-8s|%4s%-4s|%s\n","I","D","Nom","bre","Pre","cio","Descripci�n");
                Catalog.showAllProducts();
            });

            System.out.println("<<<Buscando producto>>>");

            System.out.println("""
                    1) Buscar por ID
                    2) Buscar por nombre
                    3) Buscar por descripcion
                    4) Ver todos""");

                int opt = ConsoleReader.readInt();

                Menu menu = subMenu.get(opt);
                menu.execute();


        });

        menus.put(3, () -> {

                System.out.println("<<<Quitando producto>>>");
                System.out.println("Elija el ID del producto a remover...");
                System.out.printf("%2s%-2s|%8s%-8s|%10s%-10s|%s\n", "I", "D", "Nom", "bre", "Pre", "cio", "Descripci�n");
                Catalog.showAllProducts();
                System.out.print("ID: ");
                int id = ConsoleReader.readInt() - 1;
                Catalog.removeProduct(id);
                System.out.println("> Producto removido exitosamente");

        });

         return menus;
    }

    public static void genProducts(){

        Product product = new Product(1,"Cloro",32.5,"limpieza hogar blanquea");
        Product product1 = new Product(2,"Pinol",25,"limpieza hogar desinfectante");
        Product product2 = new Product(3,"Galleta",20,"alimentos harina azucar");
        Product product3 = new Product(4,"Tofu",500,"alimentos vegetariano cocina");
        Product product4 = new Product(5,"Licuadora",200,"electrodomestico hogar cocina");
        Product product5 = new Product(6,"Ventilador",300,"electrodomestico hogar sala");
        Product product6 = new Product(7,"Bocina",234.1,"hogar musica electronico");
        Product product7 = new Product(8,"Telefono",100.5,"electronica personal comunicacion");
        Product product8 = new Product(9,"Cartera",150,"personal dinero accesorios");
        Product product9 = new Product(10, "Lapicero",7,"escuela util oficina");
        Product product10 = new Product(11,"Engrapadora",47.4,"oficina util");
        Product product11 = new Product(12,"Aretes",29.23,"personal accesorios ropa");
        Product product12 = new Product(13,"Bistek",240,"alimentos carne cocina");
        Product product13 = new Product(14,"Cuchillo",37.5,"cocina defensa arma");
        Product product14 = new Product(15,"Pistola",734.12,"arma personal defensa");


        Catalog.addProduct(product);
        Catalog.addProduct(product1);
        Catalog.addProduct(product2);
        Catalog.addProduct(product3);
        Catalog.addProduct(product4);
        Catalog.addProduct(product5);
        Catalog.addProduct(product6);
        Catalog.addProduct(product7);
        Catalog.addProduct(product8);
        Catalog.addProduct(product9);
        Catalog.addProduct(product10);
        Catalog.addProduct(product11);
        Catalog.addProduct(product12);
        Catalog.addProduct(product13);
        Catalog.addProduct(product14);

        // Prueba para llenar automaticamente una lista de productos con nombre indefinido
//        for (int i = 0; i < 10; i++) {
//            Product p  =  new Product();
//            p.generateRandom();
//
//            Catalog.addProduct(p);
//        }
    }

}
