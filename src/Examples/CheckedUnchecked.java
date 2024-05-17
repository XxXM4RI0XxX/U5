package Examples;

import java.io.FileNotFoundException;
import java.io.FileReader;

/*
    Toda exepción que herede de Exeption esta obligada a ser manejada ya sea declarandolas, con try catch, etc.
    Toda exepcion que herede de RunTimeExeption puede ser no manejada
 */

public class CheckedUnchecked {
    public static void main(String[] args) {
        try {
            readFile();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }

    public static void readFile() throws FileNotFoundException {
        FileReader fileReader = new FileReader("C:/db/index.txt"); //Buscar un archivo
//        try {
//            FileReader fileReader = new FileReader("C:/db/index");
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found");
//        }
    }
}