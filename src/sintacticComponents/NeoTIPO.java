/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sintacticComponents;

import neocompilerxfinalversion.NeoLexema;
import neocompilerxfinalversion.NeoLexicAnalyzerX;
import neocompilerxfinalversion.NeoSyntacticAnalyzerX;

/**
 * 
 * @author Neo Raiden X <neoraidenx@gmail.com>
 */
public class NeoTIPO {
    private boolean flag;
    private NeoLexema lexObj;
    
    public NeoTIPO(NeoLexema lexObj){
        this.lexObj = lexObj;
    }
    
    public boolean init(){
        //lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        if(lexObj.getToken().equalsIgnoreCase("cadena")||lexObj.getToken().equalsIgnoreCase("entero")
                ||lexObj.getToken().equalsIgnoreCase("decimal")||lexObj.getToken().equalsIgnoreCase("logico"))
            flag = true;
        else if(lexObj.getLexem().equalsIgnoreCase("tipo")){
            
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
            if(lexObj.getToken().equalsIgnoreCase("iden"))
                lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
            else
                NeoSyntacticAnalyzerX.printError("Se esperaba iden",lexObj.getCodeLine(), getClass().getName());
            
            if(lexObj.getLexem().equalsIgnoreCase("es"))
                lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
            else
                NeoSyntacticAnalyzerX.printError("Se esperaba es",lexObj.getCodeLine(), getClass().getName());
            
            if(lexObj.getToken().equalsIgnoreCase("palRes"))
                lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
            else
                NeoSyntacticAnalyzerX.printError("Se esperaba arreglo",lexObj.getCodeLine(), getClass().getName());
            
            new NeoRANGO(lexObj).init();
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
            
            if(lexObj.getLexem().equalsIgnoreCase("de"))
                lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
            else
                NeoSyntacticAnalyzerX.printError("Se esperaba de",lexObj.getCodeLine(), getClass().getName());
            
            if(new NeoTIPO(lexObj).init())
                flag = true;
            else
                NeoSyntacticAnalyzerX.printError("Se esperaba TIPO",lexObj.getCodeLine(), getClass().getName());
        }
        return flag;
    }

}
