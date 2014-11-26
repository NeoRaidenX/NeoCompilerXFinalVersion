/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package neocompilerxfinalversion;

import com.sun.media.jfxmedia.logging.Logger;
import java.io.BufferedReader;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import sun.rmi.runtime.Log;

/**
 * 
 * @author Neo Raiden X <neoraidenx@gmail.com>
 */
public class NeoLexicAnalyzerX {
    /*public String[] reserv ={"aborta","abs","abstracto","acepta","accesa","alias",
                                "todo","y","arreglo","at","inicia","cuerpo","caso","constante",
                                "declara","retraso","delta","digitos","hacer","sino",
                                "sinosi","fin","entrada","excepcion","salida","para",
                                "funcion","generico","vea","si","en","interface","es",
                                "limitado","ciclo","mod","nuevo","no","nulo","de","o",
                                "otros","fuera","sobrecarga","paquete","pragma","privado",
                                "procedimiento","protegido","eleva","rango","record","rem",
                                "renombra","rencola","regresa","reversa","selecciona",
                                "separa","algun","subtipo","sincronizado","etiqueta",
                                "tarea","terminado","luego","tipo","hasta","usa","cuando",
                                "mientras","con","xor"};*/
    private final int ACP = 86, ERR = -1;
    private final String[] keywords ={"con", "usar", "procedimiento", "constante", "es", "entero",
                                "decimal", "cadena", "lógico", "arreglo", "de", "tipo", 
                                "declara", "inicio", "fin", "si", "hacer", "sino", "regresa", 
                                "funcion", "entrada", "para", "ciclo", "mientras", "despliega", 
                                "nueva_linea", "lee", "elemento", "caso", "cuando", "otros"};
    private final int[][] neoLexAutomata = {
        //         0    1   2   3   4   5   6   7   8   9   10   11   12  13  14  15  16      17        18    19  20  21
        //       +*/%^ | < | > | = | : | y | o | n | m | d | " | 0-9 | . | , | ( | ) | ; | A-C E-L P-Z | _ | otro| - | & 
        /*q0*/ {   1   , 2 , 4 , 25 , 5 , 13, 13, 14, 16, 20, 8 ,  10 , 7 , 7 , 7 , 7 , 7 ,     20      ,ERR, ERR, 22, 24},
        /*q1*/ {  ACP  ,ACP,ACP,ACP,ACP,ACP,ACP,ACP,ACP,ACP,ACP, ACP ,ACP,ACP,ACP,ACP,ACP,     ACP     ,ACP, ACP,ACP,ACP},
        /*q2*/ {  ACP  ,ACP, 3 , 3 ,ACP,ACP,ACP,ACP,ACP,ACP,ACP, ACP ,ACP,ACP,ACP,ACP,ACP,     ACP     ,ACP, ACP,ACP,ACP},
        /*q3*/ {  ACP  ,ACP,ACP,ACP,ACP,ACP,ACP,ACP,ACP,ACP,ACP, ACP ,ACP,ACP,ACP,ACP,ACP,     ACP     ,ACP, ACP,ACP,ACP},
        /*q4*/ {  ACP  ,ACP,ACP, 3 ,ACP,ACP,ACP,ACP,ACP,ACP,ACP, ACP ,ACP,ACP,ACP,ACP,ACP,     ACP     ,ACP, ACP,ACP,ACP},
        /*q5*/ {  ACP  ,ACP,ACP, 6 ,ACP,ACP,ACP,ACP,ACP,ACP,ACP, ACP ,ACP,ACP,ACP,ACP,ACP,     ACP     ,ACP, ACP,ACP,ACP},
        /*q6*/ {  ACP  ,ACP,ACP,ACP,ACP,ACP,ACP,ACP,ACP,ACP,ACP, ACP ,ACP,ACP,ACP,ACP,ACP,     ACP     ,ACP, ACP,ACP,ACP},
        /*q7*/ {  ACP  ,ACP,ACP,ACP,ACP,ACP,ACP,ACP,ACP,ACP,ACP, ACP ,ACP,ACP,ACP,ACP,ACP,     ACP     ,ACP, ACP,ACP,ACP},
        /*q8*/ {  8  ,  8  , 8 , 8 , 8 , 8 , 8 , 8 , 8 , 8 , 9 ,  8  , 8 , 8 , 8 , 8 , 8 ,      8      , 8 ,  8 , 8 , 8 },
        /*q9*/ {  ACP  ,ACP,ACP,ACP,ACP,ACP,ACP,ACP,ACP,ACP,ACP, ACP ,ACP,ACP,ACP,ACP,ACP,     ACP     ,ACP, ACP,ACP,ACP},
        /*q10*/{  ACP  ,ACP,ACP,ACP,ACP,ACP,ACP,ACP,ACP,ACP,ACP,  10 , 11,ACP,ACP,ACP,ACP,     ACP     ,ACP, ACP,ACP,ACP},
        /*q11*/{  ERR  ,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,ERR,  12 ,ERR,ERR,ERR,ERR,ERR,     ERR     ,ERR, ERR,ERR,ERR},
        /*q12*/{  ACP  ,ACP,ACP,ACP,ACP,ACP,ACP,ACP,ACP,ACP,ACP,  12 ,ACP,ACP,ACP,ACP,ACP,     ACP     ,ACP, ACP,ACP,ACP},
        /*q13*/{  ACP  ,ACP,ACP,ACP,ACP, 18, 18, 18, 18, 18,ACP, ACP ,ACP,ACP,ACP,ACP,ACP,      18     , 17, ACP,ACP,ACP},
        /*q14*/{  ACP  ,ACP,ACP,ACP,ACP, 18, 15, 18, 18, 18,ACP, ACP ,ACP,ACP,ACP,ACP,ACP,      18     , 17, ACP,ACP,ACP},
        /*q15*/{  ACP  ,ACP,ACP,ACP,ACP, 18, 18, 18, 18, 18,ACP, ACP ,ACP,ACP,ACP,ACP,ACP,      18     ,ACP, ACP,ACP,ACP},
        /*q16*/{  ACP  ,ACP,ACP,ACP,ACP, 18, 19, 18, 18, 18,ACP, ACP ,ACP,ACP,ACP,ACP,ACP,      18     , 17, ACP,ACP,ACP},
        /*q17*/{  ERR  ,ERR,ERR,ERR,ERR, 18, 18, 18, 18, 18,ERR,  18 ,ERR,ERR,ERR,ERR,ERR,      18     ,ERR, ERR,ERR,ERR},
        /*q18*/{  ACP  ,ACP,ACP,ACP,ACP, 18, 18, 18, 18, 18,ACP,  18 ,ACP,ACP,ACP,ACP,ACP,      18     , 17, ACP,ACP,ACP},
        /*q19*/{  ACP  ,ACP,ACP,ACP,ACP, 18, 18, 18, 18, 21,ACP, ACP ,ACP,ACP,ACP,ACP,ACP,     ACP     ,ACP, ACP,ACP,ACP},
        /*q20*/{  ACP  ,ACP,ACP,ACP,ACP, 18, 18, 18, 18, 18,ACP, ACP ,ACP,ACP,ACP,ACP,ACP,      18     , 17, ACP,ACP,ACP},
        /*q21*/{  ACP  ,ACP,ACP,ACP,ACP, 18, 18, 18, 18, 18,ACP, ACP ,ACP,ACP,ACP,ACP,ACP,      18     ,ACP, ACP,ACP,ACP},
        /*q22*/{  ACP  ,ACP,ACP,ACP,ACP,ACP,ACP,ACP,ACP,ACP,ACP, ACP ,ACP,ACP,ACP,ACP,ACP,     ACP     ,ACP, ACP, 23,ACP},
        /*q23*/{   23  , 23, 23, 23, 23, 23, 23, 23, 23, 23, 23,  23 , 23, 23, 23, 23, 23,      23     , 23,  23, 23, 23},
        /*q24*/{  ACP  ,ACP,ACP,ACP,ACP,ACP,ACP,ACP,ACP,ACP,ACP, ACP ,ACP,ACP,ACP,ACP,ACP,     ACP     ,ACP, ACP,ACP,ACP},
        /*q25*/{  ACP  ,ACP, 26,ACP,ACP,ACP,ACP,ACP,ACP,ACP,ACP, ACP ,ACP,ACP,ACP,ACP,ACP,     ACP     ,ACP, ACP,ACP,ACP},
        /*q26*/{  ACP  ,ACP,ACP,ACP,ACP,ACP,ACP,ACP,ACP,ACP,ACP, ACP ,ACP,ACP,ACP,ACP,ACP,     ACP     ,ACP, ACP,ACP,ACP}
    };
    
    public final HashSet reservSet = new HashSet(Arrays.asList(keywords));
    public ArrayList<NeoLexema> lexemList = new ArrayList();
    public LinkedHashMap<String, String> symbolTable = new LinkedHashMap();
    public int currentLine = 0, status = 0;
    public String lexem = "";
    
    public boolean NeoLexicAnalyzer(){
        //System.out.println(reservSet);
        /*JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto plano", "txt");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION)*/
        try(Stream<String> stream = Files.lines(Paths.get("/Users/NeoRaidenX/Desktop/TeTruena.txt"),Charset.defaultCharset())){
            stream.forEach(line -> NeoProcess(line));
                
        } catch (Exception e) {
            System.err.println("Error en proceso Léxico ");
        }
        return true;
    }
    
    private void NeoProcess(String line){
        ++currentLine;
        if(currentLine == 133)
            System.out.println(currentLine);
        char[] lineChars = line.toCharArray();
        int index = 0, column = 0;
        char currentToken;
        while(status != ERR && index < lineChars.length){
            currentToken = lineChars[index++];
            if((currentToken == ' '|| currentToken == '\t') && status != 8)
                continue;
            column = getColFromChar(currentToken);
            if(column == ERR)
                break;
            status = neoLexAutomata[status][column];
            if(status == 23){
                lexem = "";
                status = 0;
                break;
            }
            lexem += currentToken;
            if(futureSight(status,index,lineChars)){
                lexemList.add(new NeoLexema(lexem,getSymbolToken(status)));
                if(index >= lineChars.length)
                    lexemList.add(new NeoLexema("EOL","EOL"));
                lexem = "";
                status = 0;
                //index++;
            }  
        }
    }
    
    
    private int getColFromChar(char token){
        if(token == '+'||token == '*'||token == '/'||token == '%'||token == '^')
            return 0;
        else if(token == '<')
            return 1;
        else if(token == '>')
            return 2;
        else if(token == '=')
            return 3;
        else if(token == ':')
            return 4;
        else if(token == 'y'||token == 'Y')
            return 5;
        else if(token == 'o'||token == 'O')
            return 6;
        else if(token == 'n'||token == 'N')
            return 7;
        else if(token == 'm'||token == 'M')
            return 8;
        else if(token == 'd'||token == 'D')
            return 9;
        else if(token == '"')
            return 10;
        else if(Character.isDigit(token))
            return 11;
        else if(token == '.')
            return 12;
        else if(token == ',')
            return 13;
        else if(token == '(')
            return 14;
        else if(token == ')')
            return 15;
        else if(token == ';')
            return 16;
        else if(Character.isLetter(token))
            return 17;
        else if(token == '_')
            return 18;
        else if(token == ' ' || token == '\t')
            return 19;
        else if(token == '-')
            return 20;
        else if(token == '&')
            return 21;
        else
            return 19;
    }
    
    private String getSymbolToken(int status){
        switch(status){
            case 1: case 21: case 22:
                return "Aritmetico";
            case 2: case 3: case 4: case 25:
                return "Relacional";
            case 5: case 7:
                return "Delim";
            case 6:
                return "Asignacion";
            case 9:
                return "String";
            case 10:
                return "Entero";
            case 12:
                return "Decimal";
            case 13: case 15:
                return "Logico";
            case 14: case 16: case 18: case 19: case 20:
                return "Identi";
            case 23:
                return "Comentario";
            case 24:
                return "Concatenador";
            case 26:
                return "Flecha";
            default:
                return "ERR";
        }
    }
    
    private boolean futureSight(int currentStatus, int currentIndex, char[]lineChars){
        
        if(currentIndex >= lineChars.length && currentStatus != 8)
            return true;
        if(currentIndex == lineChars.length && currentStatus == 8)
            return false;
        int col = getColFromChar(lineChars[currentIndex]);
        if(col == -1)
            return true;
        if(neoLexAutomata[currentStatus][col]==ERR
                ||neoLexAutomata[currentStatus][col]==ACP
                ||(lineChars[currentIndex] == ' ' && currentStatus != 8)
                ||lineChars[currentIndex] == '\t'
                )
            return true;
        return false;
    }
    
    public static String nextSymbol(){
        
        return "";
    }
    
    //TODO: modificar grafo para aceptar caracter &
}
