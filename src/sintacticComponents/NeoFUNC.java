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
public class NeoFUNC {
    private NeoLexema lexObj;
    private boolean flag;
    
    public NeoFUNC(NeoLexema lexObj){
        this.lexObj = lexObj;
    }
    
    public boolean init(){
        if(lexObj.getLexem().equalsIgnoreCase("funcion"))
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        else
            NeoSyntacticAnalyzerX.printError("Se esperaba funcion",lexObj.getCodeLine(), getClass().getName());
        if(lexObj.getToken().equalsIgnoreCase("iden"))
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        else
            NeoSyntacticAnalyzerX.printError("Se esperaba iden",lexObj.getCodeLine(), getClass().getName());
        if(lexObj.getLexem().equals("(")){
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
            new NeoPARAM(lexObj).init();
        }
        else if(lexObj.getLexem().equalsIgnoreCase("regresa"))
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        else
            NeoSyntacticAnalyzerX.printError("Se esperaba regresa o PARAM",lexObj.getCodeLine(), getClass().getName());
        new NeoTIPO(lexObj).init();
        lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        
        if(lexObj.getLexem().equalsIgnoreCase("es"))
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        else
            NeoSyntacticAnalyzerX.printError("Se esperaba es",lexObj.getCodeLine(), getClass().getName());
        
        if(lexObj.getToken().equalsIgnoreCase("iden"))
            new NeoVARS(lexObj).init();
        
        lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        new NeoBLOQUE(lexObj).init();
        lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        
        if(lexObj.getToken().equalsIgnoreCase("iden"))
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        else
            NeoSyntacticAnalyzerX.printError("Se esperaba iden",lexObj.getCodeLine(), getClass().getName());
        
        if(lexObj.getLexem().equals(";"))
            flag = true;
        else
            NeoSyntacticAnalyzerX.printError("Se esperaba ;",lexObj.getCodeLine(), getClass().getName());
        
        return flag;
    }
}
