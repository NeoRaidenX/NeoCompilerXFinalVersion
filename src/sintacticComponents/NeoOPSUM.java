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
public class NeoOPSUM {
    private NeoLexema lexObj;
    private boolean flag;
    private int backupIdx;
    
    public NeoOPSUM(NeoLexema lexObj){
        this.lexObj = lexObj;
    }
    
    public boolean init(){
        while(true){
            backupIdx = NeoLexicAnalyzerX.currentSinIdx;
            if(new NeoMULTI(lexObj).init()){
                lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
                flag = true;
            }
            else{
                NeoLexicAnalyzerX.restoreIdx(backupIdx);
                lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
                NeoSyntacticAnalyzerX.printError("Se esperaba OPSUM",lexObj.getCodeLine(), getClass().getName());
            }
            if(lexObj.getLexem().equals("+")||
                    lexObj.getLexem().equals("-")||
                    lexObj.getLexem().equals("&")){
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
