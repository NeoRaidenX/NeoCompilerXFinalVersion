/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sintacticComponents;

import neocompilerxfinalversion.NeoLexema;
import neocompilerxfinalversion.NeoLexicAnalyzerX;

/**
 * 
 * @author Neo Raiden X <neoraidenx@gmail.com>
 */
public class NeoESTATUTOS {
    private NeoLexema lexObj;
    private boolean flag;
    
    public NeoESTATUTOS(NeoLexema lexObj){
        this.lexObj = lexObj;
    }
    
    public boolean init(){
        while(true){
            if(lexObj.getLexem().equalsIgnoreCase("para")||lexObj.getLexem().equalsIgnoreCase("regresa")||
                    lexObj.getLexem().equalsIgnoreCase("si")||lexObj.getLexem().equalsIgnoreCase("mientras")||
                    lexObj.getLexem().equalsIgnoreCase("despliega")||lexObj.getLexem().equalsIgnoreCase("lee")||
                    lexObj.getLexem().equalsIgnoreCase("caso")||lexObj.getLexem().equalsIgnoreCase("nueva_linea")||
                    lexObj.getToken().equalsIgnoreCase("iden")){
                new NeoCOMANDO(lexObj).init();
                lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
                flag = false;
            }
            else if(lexObj.getLexem().equalsIgnoreCase(";")){
                lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
                flag = true;
            }
            else
                break;
        }
        return flag;
    }
}
