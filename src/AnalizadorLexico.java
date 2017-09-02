
import java.util.ArrayList;


public class AnalizadorLexico {
    private SuperClaseHiperMegaPro clase = new SuperClaseHiperMegaPro();
    private String identRegex = "(a|b|c|d|e|f|g|h|i|j|k|l|m|n|o|p|q|r|s|t|u|v|w|x|y|z|A|B|C|D|E|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|T|U|V|W|X|Y|Z)(a|b|c|d|e|f|g|h|i|j|k|l|m|n|o|p|q|r|s|t|u|v|w|x|y|z|A|B|C|D|E|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|T|U|V|W|X|Y|Z|0|1|2|3|4|5|6|7|8|9)*";
    private Automata ident;

    public AnalizadorLexico(){
        clase.determinarAlfabeto(identRegex);
        ident = clase.analizador(RegExConverter.infixToPostfix(identRegex));

    }
    public boolean probarIdent(String string_ident){
        boolean resutlado = clase.simuladorNFA(ident, string_ident);
        return resutlado;
    }

    public void analizadorDeTexto(ArrayList<String > s){
        System.out.println(s);
        cocolAnalizer(s);
    }
    public void cocolAnalizer(ArrayList<String > texto){
        boolean[] banderas = new boolean[3];
        String compilerWord, endWord, identWord, identWord2;
        compilerWord = texto.get(0);
        identWord = texto.get(1);
        identWord2 = texto.get(texto.size()-1);
        endWord = texto.get(texto.size()-2);
        //revisa sintaxis de inicio de cocol
        if (compilerWord.equals("COMPILER") && endWord.equals("END")){
            banderas[0] = true;
        }
        else{
            System.out.println("Syntax error! --> COCOL block: COMPILER or END missing");
        }
        if (!identWord2.endsWith(".")){
            System.out.println("Syntax error! --> COCOL block: close ident error");
        }
        if (identWord.equals(identWord2.replace(".",""))){
            banderas[1] = true;
            if(probarIdent(identWord)){
                banderas[2] = true;
            }
            else {
                System.out.println("Syntax error! --> COCOL block: ident, bad expression");
            }
        }
        else{
            System.out.println("Syntax error! --> COCOL block: ident  mach");
        }
    }
}
