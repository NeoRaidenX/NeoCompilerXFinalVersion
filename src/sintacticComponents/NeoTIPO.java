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
    
    public void init(){
        lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        if(lexObj.getToken().equalsIgnoreCase("Cadena")||lexObj.getToken().equalsIgnoreCase("Entero")
                ||lexObj.getToken().equalsIgnoreCase("Decimal")||lexObj.getToken().equalsIgnoreCase("Logico"))
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        else if(lexObj.getLexem().equalsIgnoreCase("tipo")){
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
            if(lexObj.getToken().equalsIgnoreCase("iden"))
                lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
            else
                NeoSyntacticAnalyzerX.printError("Se esperaba iden");
            
            if(lexObj.getLexem().equalsIgnoreCase("es"))
                lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
            else
                NeoSyntacticAnalyzerX.printError("Se esperaba es");
            
            new NeoRANGO().init();
            
            if(lexObj.getLexem().equalsIgnoreCase("de"))
                lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
            else
                NeoSyntacticAnalyzerX.printError("Se esperaba de");
            
            new NeoTIPO().init();
        }
    }

}
