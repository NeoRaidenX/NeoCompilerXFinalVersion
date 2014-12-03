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
public class NeoRANGO {
    private boolean flag;
    private NeoLexema lexObj;
    
    public NeoRANGO(NeoLexema lexObj){
        this.lexObj = lexObj;
    }
    
    public boolean init(){
        if(lexObj.getLexem().equals("("))
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        else
            NeoSyntacticAnalyzerX.printError("se esperaba (");
        while(true){
            if(lexObj.getToken().equalsIgnoreCase("CteEnt"))
                lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
            else
                NeoSyntacticAnalyzerX.printError("se esperaba CteEnt");
            if(lexObj.getLexem().equals("."))
                lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
            else
                NeoSyntacticAnalyzerX.printError("se esperaba .");
            if(lexObj.getLexem().equals("."))
                lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
            else
                NeoSyntacticAnalyzerX.printError("se esperaba .");
            if(lexObj.getToken().equalsIgnoreCase("CteEnt"))
                lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
            else
                NeoSyntacticAnalyzerX.printError("se esperaba CteEnt");
            if(lexObj.getLexem().equals(","))
                lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
            else
                break;
        }
        if(lexObj.getLexem().equals(")"))
            flag = true;
        else
            NeoSyntacticAnalyzerX.printError("se esperaba )");
        
        return flag;
    }
    
    

}
