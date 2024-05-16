import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
//Al inicio se tienen que importar google.code.gson en la libreria.
// File -> Project Structure -> Libraries -> + -> From Maven... -> google.code.gson -> Ok -> Apply
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Jayson {

    public static void main(String[] args) {

        HashMap<String, List<?>> uwu = createHashMap(); // List<?>; Admite List con cualquier tipo de dato.

        Gson json = new GsonBuilder().setPrettyPrinting().create(); //Con esta sintaxis se crea el archivo .json con un formato acomodado por columnas.
        //Gson json=new Gson(); con esta se crea el archivo .json sin formato
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Doc.json")); //Aqui se crea automaticamente el nuevo archivo .json
            json.toJson(uwu,writer);
            writer.close();//Siempre se tiene que cerrar el writer despues de utilizarlo.
        }catch (IOException e){
            System.out.println(e);
        }catch (Exception e){
            System.out.println(e);
        }

    }

    private static HashMap<String, List<?>> createHashMap() {
        HashMap<String, List<?>> uwu = new HashMap<>();

        Vector<Integer> uno = new Vector<>();
        uno.add(10);
        uno.add(20);
        uno.add(100);

        ArrayList<Character> dos = new ArrayList<>();
        dos.add('x');
        dos.add('y');
        dos.add('z');

        LinkedList<String> tres = new LinkedList<>();
        tres.add("Hola");
        tres.add("Que");
        tres.add("Adios");

        uwu.put("Vector",uno);
        uwu.put("ArrayList",dos);
        uwu.put("LinkedList",tres);
        return uwu;
    }

}
