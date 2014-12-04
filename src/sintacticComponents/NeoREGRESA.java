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
public class NeoREGRESA {
    private NeoLexema lexObj;
    private boolean flag;
    
    public NeoREGRESA(NeoLexema lexObj){
        this.lexObj = lexObj;
    }
    
    public boolean init(){
        if(lexObj.getLexem().equalsIgnoreCase("regresa")){
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
            flag = true;
        }
        else
            NeoSyntacticAnalyzerX.printError("Se esperaba regresa",lexObj.getCodeLine(), getClass().getName());
        
        if(new NeoEXPR(lexObj).init()){
            flag = true;
        }
        
        return flag;
    }
}
