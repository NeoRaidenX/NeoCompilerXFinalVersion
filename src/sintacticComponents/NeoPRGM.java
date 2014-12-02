/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sintacticComponents;
/**
 * 
 * @author Neo Raiden X <neoraidenx@gmail.com>
 */
import neocompilerxfinalversion.NeoLexema;
import neocompilerxfinalversion.NeoLexicAnalyzerX;
import neocompilerxfinalversion.NeoSyntacticAnalyzerX;
public class NeoPRGM {
    NeoLexema lexObj;
    public NeoPRGM(){
        execute();
    }
    public void execute(){
        new NeoLIB().init();
        new NeoUSO().init();
        lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        
        if(lexObj.getLexem().equalsIgnoreCase("procedimiento")){
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        }else
            NeoSyntacticAnalyzerX.printError("Se esperaba procedimiento");
        if(lexObj.getToken().equalsIgnoreCase("iden")){
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        }else
            NeoSyntacticAnalyzerX.printError("Se esperaba iden");
        
        while(lexObj.getLexem().equalsIgnoreCase("es")){
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
            if(lexObj.getToken().equalsIgnoreCase("iden")){
                new NeoVARS().init();
            }else if(lexObj.getToken().equalsIgnoreCase("Cadena")||lexObj.getToken().equalsIgnoreCase("Entero")||
                    lexObj.getToken().equalsIgnoreCase("Decimal")||lexObj.getToken().equalsIgnoreCase("Logico")||
                    lexObj.getToken().equalsIgnoreCase("Tipo")){
                new NeoTIPO();
            }
        }
        
        if(lexObj.getLexem().equalsIgnoreCase("inicio")){
            new NeoFUNPROC();
        }
        
        new NeoBLOQUE();
        lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        
        if(lexObj.getToken().equalsIgnoreCase("iden"))
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        else
            NeoSyntacticAnalyzerX.printError("Se esperaba iden");
        
        if(lexObj.getLexem().equalsIgnoreCase(";"))
            NeoSyntacticAnalyzerX.printError("FIN NeoPRGM");
            //lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        else
            NeoSyntacticAnalyzerX.printError("Se esperaba ;");
        
            
            
    }

}
