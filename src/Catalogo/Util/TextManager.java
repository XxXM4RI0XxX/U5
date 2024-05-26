package Catalogo.Util;

import java.io.*;

public class TextManager {

    public static String readFile(String fileName) {
        try (
                FileReader fileReader = new FileReader(fileName);
                BufferedReader reader = new BufferedReader(fileReader)
        ) {
            String text = "", line;
            while ((line = reader.readLine()) != null) {
                text = text.concat(line);
            }
            return text;
        } catch (IOException e) {
            System.out.println("Archivo no encontrado...");
        }
        return "";
    }

    public static void writeFile(String fileName,String newContent){

        try(
                FileWriter fileWriter = new FileWriter(fileName);
                PrintWriter writer = new PrintWriter(fileWriter)
        )
        {
            writer.write(newContent);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
