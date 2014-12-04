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
    }
    public void execute(){
        lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        new NeoLIB(lexObj).init();
        lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        new NeoUSO(lexObj).init();
        lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        
        if(lexObj.getLexem().equalsIgnoreCase("procedimiento")){
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        }else
            NeoSyntacticAnalyzerX.printError("Se esperaba procedimiento",lexObj.getCodeLine(), getClass().getName());
        if(lexObj.getToken().equalsIgnoreCase("iden")){
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        }else
            NeoSyntacticAnalyzerX.printError("Se esperaba iden",lexObj.getCodeLine(), getClass().getName());
        if(lexObj.getLexem().equalsIgnoreCase("es")){
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
            while(true){
                if(lexObj.getToken().equalsIgnoreCase("iden")){
                    new NeoVARS(lexObj).init();
                }else if(lexObj.getToken().equalsIgnoreCase("Cadena")||lexObj.getToken().equalsIgnoreCase("Entero")||
                        lexObj.getToken().equalsIgnoreCase("Decimal")||lexObj.getToken().equalsIgnoreCase("Logico")||
                        lexObj.getToken().equalsIgnoreCase("Tipo")){
                    new NeoTIPO(lexObj).init();
                }
                else
                    NeoSyntacticAnalyzerX.printError("se esperaba iden o tipo de dato",lexObj.getCodeLine(), getClass().getName());
            }
        }
        
        if(lexObj.getLexem().equalsIgnoreCase("inicio")){
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
            if(lexObj.getLexem().equalsIgnoreCase("declara")){
                lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
                new NeoFUNPROC(lexObj).init();
            }else
                new NeoBLOQUE(lexObj).init();
        }
        else
            NeoSyntacticAnalyzerX.printError("Se esperaba inicio",lexObj.getCodeLine(), getClass().getName());
        
        lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        
        if(lexObj.getToken().equalsIgnoreCase("iden"))
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        else
            NeoSyntacticAnalyzerX.printError("Se esperaba iden",lexObj.getCodeLine(), getClass().getName());
        
        if(lexObj.getLexem().equalsIgnoreCase(";"))
            NeoSyntacticAnalyzerX.printError("FIN NeoPRGM",lexObj.getCodeLine(), getClass().getName());
            //lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        else
            NeoSyntacticAnalyzerX.printError("Se esperaba ;",lexObj.getCodeLine(), getClass().getName());
        
            
            
    }

}
