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
public class NeoUDimenParam {
    private NeoLexema lexObj;
    private boolean flag;
    
    public NeoUDimenParam(NeoLexema lexObj){
        this.lexObj = lexObj;
    }
    
    public boolean init(){
        if(lexObj.getLexem().equals("(")){
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        }else{
            NeoSyntacticAnalyzerX.printError("Se esperaba (",lexObj.getCodeLine(), getClass().getName());
        }
        
        while(true){
            new NeoEXPR(lexObj).init();
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
            if(lexObj.getLexem().equals(",")){
                lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
            }
            else{
                lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
                break;
            }
        }
        
        if(lexObj.getLexem().equals(")"))
            flag = true;
        else
            NeoSyntacticAnalyzerX.printError("Se esperaba )",lexObj.getCodeLine(), getClass().getName());
        
        return flag;
    }
}
