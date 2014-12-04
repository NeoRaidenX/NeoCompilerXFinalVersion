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
public class NeoSI {
    private NeoLexema lexObj;
    private boolean flag;
    
    public NeoSI(NeoLexema lexObj){
        this.lexObj = lexObj;
    }
    
    public boolean init(){
        if(lexObj.getLexem().equalsIgnoreCase("si"))
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        else
            NeoSyntacticAnalyzerX.printError("Se esperaba si",lexObj.getCodeLine(), getClass().getName());
        
        new NeoEXPR(lexObj).init();
        lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        
        if(lexObj.getLexem().equalsIgnoreCase("hacer"))
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        else
            NeoSyntacticAnalyzerX.printError("Se esperaba hacer",lexObj.getCodeLine(), getClass().getName());
        
        new NeoESTATUTOS(lexObj).init();
        lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        
        if(lexObj.getLexem().equalsIgnoreCase("sino")){
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
            new NeoESTATUTOS(lexObj).init();
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        }else if(lexObj.getLexem().equalsIgnoreCase("fin")){
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        }else{
            NeoSyntacticAnalyzerX.printError("Se esperaba sino o fin",lexObj.getCodeLine(), getClass().getName());
        }
        
        if(lexObj.getLexem().equalsIgnoreCase("si"))
            flag = true;
        else
            NeoSyntacticAnalyzerX.printError("Se esperaba si",lexObj.getCodeLine(), getClass().getName());
            
        return flag;
    }
}
