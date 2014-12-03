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
                NeoSyntacticAnalyzerX.printError("Se esperaba iden");
            
            if(lexObj.getLexem().equalsIgnoreCase("es"))
                lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
            else
                NeoSyntacticAnalyzerX.printError("Se esperaba es");
            
            new NeoRANGO(lexObj).init();
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
            
            if(lexObj.getLexem().equalsIgnoreCase("de"))
                lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
            else
                NeoSyntacticAnalyzerX.printError("Se esperaba de");
            
            if(new NeoTIPO(lexObj).init())
                flag = true;
            else
                NeoSyntacticAnalyzerX.printError("Se esperaba TIPO");
        }
        return flag;
    }

}
