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
public class NeoFUNPROC {
    private NeoLexema lexObj;
    private boolean flag;
    
    public NeoFUNPROC(NeoLexema lexObj){
        this.lexObj = lexObj;
    }
    
    public boolean init(){
        while(true){
            if(lexObj.getLexem().equalsIgnoreCase("procedimiento")){
                //lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
                flag = new NeoPROC(lexObj).init();
            }else if(lexObj.getLexem().equalsIgnoreCase("funcion")){
                //lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
                flag = new NeoFUNC(lexObj).init();
            }
            else{
                break;
            }
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        }
        return flag;
    }
}

