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
public class NeoLprocAsigna {
    private NeoLexema lexObj;
    private boolean flag;
    private int backupIdx;
    
    public NeoLprocAsigna(NeoLexema lexObj){
        this.lexObj = lexObj;
    }
    
    public boolean init(){
        if(lexObj.getToken().equalsIgnoreCase("iden"))
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        else
            NeoSyntacticAnalyzerX.printError("Se esperaba iden",lexObj.getCodeLine(), getClass().getName());
        backupIdx = NeoLexicAnalyzerX.currentSinIdx;
        if(new NeoUDimenParam(lexObj).init()){
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        }
        else{
            NeoLexicAnalyzerX.restoreIdx(backupIdx);
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        }
        if(lexObj.getLexem().equals(":=")){
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
            backupIdx = NeoLexicAnalyzerX.currentSinIdx;
            if(new NeoEXPR(lexObj).init()){
                flag = true;
            }
            else{
                NeoLexicAnalyzerX.restoreIdx(backupIdx);
                NeoSyntacticAnalyzerX.printError("Se esperaba EXPR",lexObj.getCodeLine(), getClass().getName());
            }
                
        }
        else
            flag = true;
            
        return flag;
    }
}
