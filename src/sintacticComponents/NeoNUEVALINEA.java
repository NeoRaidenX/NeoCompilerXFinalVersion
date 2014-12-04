/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sintacticComponents;

import neocompilerxfinalversion.NeoLexema;

/**
 * 
 * @author Neo Raiden X <neoraidenx@gmail.com>
 */
public class NeoNUEVALINEA {
    private NeoLexema lexObj;
    private boolean flag;
    
    public NeoNUEVALINEA(NeoLexema lexObj){
        this.lexObj = lexObj;
    }
    
    public boolean init(){
        if(lexObj.getLexem().equalsIgnoreCase("nueva_linea"))
            flag = true;
        return flag;
    }
}
