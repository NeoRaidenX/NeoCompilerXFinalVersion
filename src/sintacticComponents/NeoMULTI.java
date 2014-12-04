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
public class NeoMULTI {
    private NeoLexema lexObj;
    private boolean flag;
    private int backupIdx;
    
    public NeoMULTI(NeoLexema lexObj){
        this.lexObj = lexObj;
    }
    
    public boolean init(){
        while(true){
            backupIdx = NeoLexicAnalyzerX.currentSinIdx;
            if(new NeoEXPO(lexObj).init()){
                lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
                flag = true;
            }
            else{
                NeoLexicAnalyzerX.restoreIdx(backupIdx);
                lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
                NeoSyntacticAnalyzerX.printError("Se esperaba MULTI",lexObj.getCodeLine(), getClass().getName());
            }
            if(lexObj.getLexem().equals("*")||
                    lexObj.getLexem().equals("/")||
                    lexObj.getLexem().equalsIgnoreCase("mod")){
                lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
                flag = false;
            }
            else{
                break;
            }
        }
        return flag;
    }
}
