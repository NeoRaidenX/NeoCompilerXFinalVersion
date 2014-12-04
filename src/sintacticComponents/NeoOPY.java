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
public class NeoOPY {
    private NeoLexema lexObj;
    private boolean flag;
    private int backupIdx;
    
    public NeoOPY(NeoLexema lexObj){
        this.lexObj = lexObj;
    }
    
    public boolean init(){
        while(true){
            backupIdx = NeoLexicAnalyzerX.currentSinIdx;
            if(new NeoOPNO(lexObj).init()){
                lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
                flag = true;
            }
            else{
                NeoLexicAnalyzerX.restoreIdx(backupIdx);
                lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
                NeoSyntacticAnalyzerX.printError("Se esperaba EXPR",lexObj.getCodeLine(), getClass().getName());
            }
            if(lexObj.getLexem().equalsIgnoreCase("y")){
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
