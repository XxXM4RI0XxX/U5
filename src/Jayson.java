import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Jayson {

    public static void main(String[] args) {

        HashMap<String, List<?>> uwu = createHashMap();

        Gson json = new GsonBuilder().setPrettyPrinting().create();
        //Gson json=new Gson();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Doc.json"));
            json.toJson(uwu,writer);
            writer.close();
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
