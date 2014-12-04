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
public class NeoOPREL {
    private NeoLexema lexObj;
    private boolean flag;
    private int backupIdx;
    
    public NeoOPREL(NeoLexema lexObj){
        this.lexObj = lexObj;
    }
    
    public boolean init(){
        backupIdx = NeoLexicAnalyzerX.currentSinIdx;
        if(lexObj.getLexem().equals("<")){
            flag = true;
        }else if(lexObj.getLexem().equals(">")){
            flag = true;
        }else if(lexObj.getLexem().equals("<=")){
            flag = true;
        }else if(lexObj.getLexem().equals(">=")){
            flag = true;
        }else if(lexObj.getLexem().equals("<>")){
            flag = true;
        }else if(lexObj.getLexem().equals("=")){
            flag = true;
        }else if(new NeoOPSUM(lexObj).init()){
            flag = true;
        }
        else{
            NeoLexicAnalyzerX.restoreIdx(backupIdx);
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
            NeoSyntacticAnalyzerX.printError("Se esperaba EXPR",lexObj.getCodeLine(), getClass().getName());
        }
        return flag;
    }
}
