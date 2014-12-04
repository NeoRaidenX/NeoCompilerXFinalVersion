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
public class NeoLEE {
    private NeoLexema lexObj;
    private boolean flag;
    
    public NeoLEE(NeoLexema lexObj){
        this.lexObj = lexObj;
    }
    
    public boolean init(){
        if(lexObj.getLexem().equalsIgnoreCase("lee"))
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        else
            NeoSyntacticAnalyzerX.printError("Se esperaba lee",lexObj.getCodeLine(), getClass().getName());
        
        if(lexObj.getLexem().equals("("))
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        else
            NeoSyntacticAnalyzerX.printError("Se esperaba (",lexObj.getCodeLine(), getClass().getName());
        
        if(lexObj.getLexem().equalsIgnoreCase("elemento"))
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        else
            NeoSyntacticAnalyzerX.printError("Se esperaba elemento",lexObj.getCodeLine(), getClass().getName());
        
        if(lexObj.getLexem().equals("=>"))
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        else
            NeoSyntacticAnalyzerX.printError("Se esperaba =>",lexObj.getCodeLine(), getClass().getName());
        
        if(lexObj.getToken().equalsIgnoreCase("iden"))
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        else
            NeoSyntacticAnalyzerX.printError("Se esperaba iden",lexObj.getCodeLine(), getClass().getName());
        
        if(lexObj.getLexem().equals(")"))
            flag = true;
        else
            NeoSyntacticAnalyzerX.printError("Se esperaba )",lexObj.getCodeLine(), getClass().getName());
        
        
        return flag;
    }
}
