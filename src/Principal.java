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
//lee la cadena que contiene la exprexion regular
        Scanner teclado = new Scanner(System.in);
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
        //analiza la
    analizadorLexico.analizadorDeTexto(arreglo);
    }
}
