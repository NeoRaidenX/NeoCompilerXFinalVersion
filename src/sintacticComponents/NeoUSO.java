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
        if(lexObj.getLexem().equalsIgnoreCase("usar")){
                lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        }
        else{
            NeoSyntacticAnalyzerX.printError("se esperaba usar",lexObj.getCodeLine(), getClass().getName());
        }
        if(lexObj.getToken().equalsIgnoreCase("iden")){
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        }
        else{
            NeoSyntacticAnalyzerX.printError("se esperaba iden",lexObj.getCodeLine(), getClass().getName());
        }
        if(lexObj.getLexem().equalsIgnoreCase(".")){
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        }
        else{
            NeoSyntacticAnalyzerX.printError("se esperaba .",lexObj.getCodeLine(), getClass().getName());
        }
        if(lexObj.getToken().equalsIgnoreCase("iden")){
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        }
        else{
            NeoSyntacticAnalyzerX.printError("se esperaba iden",lexObj.getCodeLine(), getClass().getName());
        }
        if(lexObj.getLexem().equalsIgnoreCase(";")){
            flag = true;
        }
        else{
            NeoSyntacticAnalyzerX.printError("se esperaba ;",lexObj.getCodeLine(), getClass().getName());
        }
        return flag;
    }

}
