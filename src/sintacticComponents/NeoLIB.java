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
public class NeoLIB {
    private boolean flag;
    NeoLexema lexObj;
    public NeoLIB(NeoLexema lexObj){
        this.lexObj = lexObj;
    }
    
    public boolean init(){
        //lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        while(true){
            if(lexObj.getLexem().equalsIgnoreCase("con")){
                lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
            }
            else{
                NeoSyntacticAnalyzerX.printError("se esperaba con");
                break;
            }
            if(lexObj.getToken().equalsIgnoreCase("iden")){
                lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
            }
            else{
                NeoSyntacticAnalyzerX.printError("se esperaba iden");
                break;
            }
            if(lexObj.getLexem().equalsIgnoreCase(".")){
                lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
            }
            else{
                NeoSyntacticAnalyzerX.printError("se esperaba .");
                break;
            }
            if(lexObj.getToken().equalsIgnoreCase("iden")){
                lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
            }
            else{
                NeoSyntacticAnalyzerX.printError("se esperaba iden");
                break;
            }
            if(lexObj.getLexem().equalsIgnoreCase(";")){
                //lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
                flag = true;
            }
            else{
                NeoSyntacticAnalyzerX.printError("se esperaba ;");
                break;
            }
            if(NeoLexicAnalyzerX.getNextSymbol().getLexem().equalsIgnoreCase("con")){
                lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
                flag = false;
            }
            else
                break;
        }
        return flag;
    }
}
