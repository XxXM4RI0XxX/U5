package Catalogo.Util;

import Catalogo.Catalog;
import Catalogo.CustomExceptions.*;
import Catalogo.Product;
import java.io.*;
import java.util.HashMap;

public class Seeder {


    public static void genProducts(){

        TextManager.writeFile("seeder.csv","""
                        1,Cloro,32.5,Limpieza hogar blanquea
                        2,Pinol,25,limpieza hogar desinfectante
                        3,Galleta,20,alimentos harina azucar
                        4,Tofu,500,alimentos vegetariano cocina
                        5,Licuadora,200,electrodomestico hogar cocina
                        6,Ventilador,300,electrodomestico hogar sala
                        7,Bocina,234.1,hogar musica electronico
                        8,Telefono,100.5,electronica personal comunicacion
                        9,Cartera,150,personal dinero accesorios
                        10,Lapicero,7,escuela util oficina
                        11,Engrapadora,47.4,oficina util
                        12,Aretes,29.23,personal accesorios ropa
                        13,Bistek,240,alimentos carne cocina
                        14,Cuchillo,37.5,cocina defensa arma
                        15,Pistola,734.12,arma personal defensa
                        """);

        try (
                BufferedReader reader = new BufferedReader(new FileReader("seeder.csv"))
        ){
            String line;
            while ((line = reader.readLine())!= null){

                String[] product = line.split(",");

                Catalog.addProduct(new Product(Integer.parseInt(product[0]),product[1],Double.parseDouble(product[2]),product[3]));
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }



    public static HashMap<Integer,Menu> getMenus(){

        HashMap<Integer,Menu> menus = new HashMap<>();



        menus.put(1, () -> { //Añadir producto


                System.out.println("<<<Agregando producto>>>");

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

                    Product product = new Product(Catalog.getProducts().getLast().getId()+1, name, price, description);

                    Catalog.addProduct(product);
                    System.out.println("> Producto agregado existosamente");
                }catch (NegativeInputDetected | BlankSpaceDetected _){}

        });

        menus.put(2, () -> { //See products

            HashMap<Integer,Menu> subMenu = new HashMap<>();

            subMenu.put(1, () -> {

                System.out.print("ID del producto: ");
                int id = ConsoleReader.readInt();
                Product product = Catalog.findById(id);
                product.printProduct();

            });
            subMenu.put(2, () ->{

                    System.out.print("Nombre del producto: ");
                    String name = ConsoleReader.readString(0);
                    Product product = Catalog.findByName(name);
                    System.out.printf("%2s%-2s|%8s%-8s|%10s%-10s|%s\n","I","D","Nom","bre","Pre","cio","Descripcion");
                    product.printProduct();
            });
            subMenu.put(3, () ->{

                   System.out.print("Descripcion del producto: ");
                   String desc = ConsoleReader.readString(0);
                   Product[] products = Catalog.searchByDescription(desc);
                   System.out.printf("%2s%-2s|%8s%-8s|%10s%-10s|%s\n","I","D","Nom","bre","Pre","cio","Descripcion");
                   for(Product product : products){
                       product.printProduct();
                   }

            });
            subMenu.put(4, () -> {
                System.out.println("Mostrando productos...");
                System.out.printf("%2s%-2s|%8s%-8s|%4s%-4s|%s\n","I","D","Nom","bre","Pre","cio","Descripcion");
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
                System.out.printf("%2s%-2s|%8s%-8s|%10s%-10s|%s\n", "I", "D", "Nom", "bre", "Pre", "cio", "Descripcion");
                Catalog.showAllProducts();
                System.out.print("ID: ");
                int id = ConsoleReader.readInt();
                Catalog.removeProduct(id);
                System.out.println("> Producto removido exitosamente");

        });

         return menus;
    }

}
