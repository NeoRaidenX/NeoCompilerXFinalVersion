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
public class NeoPARA {
    private NeoLexema lexObj;
    private boolean flag;
    
    public NeoPARA(NeoLexema lexObj){
        this.lexObj = lexObj;
    }
    
    public boolean init(){
        if(lexObj.getLexem().equalsIgnoreCase("para"))
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        else
            NeoSyntacticAnalyzerX.printError("Se esperaba para",lexObj.getCodeLine(), getClass().getName());
        
        if(lexObj.getToken().equalsIgnoreCase("iden"))
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        else
            NeoSyntacticAnalyzerX.printError("Se esperaba iden",lexObj.getCodeLine(), getClass().getName());
        
        if(lexObj.getLexem().equalsIgnoreCase("en"))
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        else
            NeoSyntacticAnalyzerX.printError("Se esperaba en",lexObj.getCodeLine(), getClass().getName());
        
        if(lexObj.getToken().equalsIgnoreCase("iden")||lexObj.getToken().equalsIgnoreCase("CteEnt"))
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        else
            NeoSyntacticAnalyzerX.printError("Se esperaba iden o CteEnt",lexObj.getCodeLine(), getClass().getName());
        
        if(lexObj.getLexem().equals("."))
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        else
            NeoSyntacticAnalyzerX.printError("Se esperaba .",lexObj.getCodeLine(), getClass().getName());
        
        if(lexObj.getLexem().equals("."))
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        else
            NeoSyntacticAnalyzerX.printError("Se esperaba .",lexObj.getCodeLine(), getClass().getName());
        
        if(lexObj.getToken().equalsIgnoreCase("iden")||lexObj.getToken().equalsIgnoreCase("CteEnt"))
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        else
            NeoSyntacticAnalyzerX.printError("Se esperaba iden o CteEnt",lexObj.getCodeLine(), getClass().getName());
        
        if(lexObj.getLexem().equalsIgnoreCase("ciclo"))
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        else
            NeoSyntacticAnalyzerX.printError("Se esperaba ciclo",lexObj.getCodeLine(), getClass().getName());
        
        new NeoESTATUTOS(lexObj).init();
        lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        
        if(lexObj.getLexem().equalsIgnoreCase("fin"))
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        else
            NeoSyntacticAnalyzerX.printError("Se esperaba fin",lexObj.getCodeLine(), getClass().getName());
        
        if(lexObj.getLexem().equalsIgnoreCase("ciclo"))
            flag = true;
        else
            NeoSyntacticAnalyzerX.printError("Se esperaba ciclo",lexObj.getCodeLine(), getClass().getName());
        return flag;
    }

}
