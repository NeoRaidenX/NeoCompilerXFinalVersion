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
public class NeoTERMINO {
    private NeoLexema lexObj;
    private boolean flag;
    private int backupIdx;
    
    public NeoTERMINO(NeoLexema lexObj){
        this.lexObj = lexObj;
    }
    
    public boolean init(){
        if(lexObj.getLexem().equals("(")){
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
            new NeoEXPR(lexObj).init();
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
            if(lexObj.getLexem().equals(")"))
                flag = true;
            else{
                NeoSyntacticAnalyzerX.printError("Se esperaba )",lexObj.getCodeLine(), getClass().getName());
            }
        }
        else if(lexObj.getToken().equalsIgnoreCase("iden")){
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
            backupIdx = NeoLexicAnalyzerX.currentSinIdx;
            if(new NeoUDimenParam(lexObj).init()){
                flag = true;
            }else{
                NeoLexicAnalyzerX.restoreIdx(backupIdx);
                lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
                flag = true;
            }
        }
        else if(new NeoCTE(lexObj).init()){
            flag = true;
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        }
        else{
            NeoSyntacticAnalyzerX.printError("Se esperaba TERMINO",lexObj.getCodeLine(), getClass().getName());
        }
            
        return flag;
    }
}
