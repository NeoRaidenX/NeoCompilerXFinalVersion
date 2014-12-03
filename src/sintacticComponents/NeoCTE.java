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
public class NeoCTE {
    private NeoLexema lexObj;
    private boolean flag;
    
    public NeoCTE(NeoLexema lexObj){
        this.lexObj = lexObj;
    }
    
    public boolean init(){
        if(lexObj.getToken().equalsIgnoreCase("CteEnt")||lexObj.getToken().equalsIgnoreCase("CteCad")||lexObj.getToken().equalsIgnoreCase("CteDec"))
            flag = true;
        else if(lexObj.getLexem().equalsIgnoreCase("falso")||lexObj.getLexem().equalsIgnoreCase("verdadero"))
            flag = true;
        else
            NeoSyntacticAnalyzerX.printError("Se esperaba CTE");
        return flag;
    }

}
