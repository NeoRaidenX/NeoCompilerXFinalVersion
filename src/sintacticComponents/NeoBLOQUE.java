/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sintacticComponents;

import neocompilerxfinalversion.NeoLexema;
import neocompilerxfinalversion.NeoSyntacticAnalyzerX;

/**
 * 
 * @author Neo Raiden X <neoraidenx@gmail.com>
 */
public class NeoBLOQUE {
    private NeoLexema lexObj;
    private boolean flag;
    
    public NeoBLOQUE(NeoLexema lexObj){
        this.lexObj = lexObj;
    }
    
    public boolean init(){
        if(!lexObj.getLexem().equalsIgnoreCase("fin"))
            new NeoESTATUTOS(lexObj).init();
        if(lexObj.getLexem().equalsIgnoreCase("fin"))
            flag = true;
        else
            NeoSyntacticAnalyzerX.printError("Se esperaba fin",lexObj.getCodeLine(), getClass().getName());
            
        return flag;
    }
    
}
