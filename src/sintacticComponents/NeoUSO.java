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
public class NeoUSO {
    private boolean flag;
    private NeoLexema lexObj;
    
    public NeoUSO(NeoLexema lexObj){
        this.lexObj = lexObj;
    }

    public boolean init() {
        if(lexObj.getLexem().equalsIgnoreCase("con")){
                lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        }
        else{
            NeoSyntacticAnalyzerX.printError("se esperaba con");
        }
        if(lexObj.getToken().equalsIgnoreCase("iden")){
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        }
        else{
            NeoSyntacticAnalyzerX.printError("se esperaba iden");
        }
        if(lexObj.getLexem().equalsIgnoreCase(".")){
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        }
        else{
            NeoSyntacticAnalyzerX.printError("se esperaba .");
        }
        if(lexObj.getToken().equalsIgnoreCase("iden")){
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        }
        else{
            NeoSyntacticAnalyzerX.printError("se esperaba iden");
        }
        if(lexObj.getLexem().equalsIgnoreCase(";")){
            flag = true;
        }
        else{
            NeoSyntacticAnalyzerX.printError("se esperaba ;");
        }
        return flag;
    }

}
