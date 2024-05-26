package Catalogo;

import java.util.HashMap;

import Catalogo.CustomExceptions.NegativeInputDetected;
import Catalogo.CustomExceptions.ProductNotFound;
import Catalogo.Util.*;

public class Main {

    public static void main(String[] args) {
        HashMap<Integer,Menu> menus = Seeder.getMenus();
        Seeder.genProducts();

        System.out.println("Bienvenido al catalogo :D!");
        boolean flag = true;
        do {
        try {

                System.out.println("\t>>>MENU<<<\n1) Agregar prodcuto\n2) Buscar prodcuto\n3) Remover producto\n0) Salir");
                int opt = ConsoleReader.readInt();

                if (opt != 0) {
                    Menu menu = menus.get(opt);
                    menu.execute();
                } else flag = false;


        }catch (IndexOutOfBoundsException | NullPointerException _){
            System.out.println(">>> Invalid input...");
        }catch (ProductNotFound | NegativeInputDetected _){}
    } while (flag);
        System.out.println("Adio :c");

    }

}


