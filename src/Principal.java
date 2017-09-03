import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.Scanner;


/**
 * @author Jonnathan Juarez
 * @version 1.0 02/08/2017
 */
public class Principal {
    public static void main(String args[]) {

        AnalizadorLexico analizadorLexico = new AnalizadorLexico();
// lee el archivo
        Scanner s = null;
        ArrayList<String> arreglo = new ArrayList<>();
        try {
            s = new Scanner(new BufferedReader(new FileReader("test.txt")));
            while (s.hasNext())
            {
                String str = s.next();
                arreglo.add(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (s != null) {
                s.close();
            }
        }
        //analiza la estructura de cocol
        analizadorLexico.cocolAnalizer(arreglo);

        ArrayList<String> arreglodeDeLineas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if(!line.equals(""))
                arreglodeDeLineas.add(line);
            }
        }
        catch (IOException e){

        }
        //System.out.println(arreglodeDeLineas);
        analizadorLexico.analizador(arreglodeDeLineas);
    }
}
