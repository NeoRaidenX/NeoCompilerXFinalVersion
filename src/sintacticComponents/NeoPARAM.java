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
public class NeoPARAM {
    private NeoLexema lexObj;
    private boolean flag;
    
    public NeoPARAM(NeoLexema lexObj){
        this.lexObj = lexObj;
    }
    
    public boolean init(){
        if(lexObj.getLexem().equals("("))
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        while(true){
            
            while(true){
                if(lexObj.getToken().equalsIgnoreCase("iden")){
                lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
            }else{
                NeoSyntacticAnalyzerX.printError("Se esperaba iden",lexObj.getCodeLine(), getClass().getName());
                break;
            }
            
            if(lexObj.getLexem().equals(","))
                lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
            else break;
            }
            
            if(lexObj.getLexem().equalsIgnoreCase(":")){
                lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
            }else{
                NeoSyntacticAnalyzerX.printError("Se esperaba :",lexObj.getCodeLine(), getClass().getName());
            }
            
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
            new NeoTIPO(lexObj).init();
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
            
            if(lexObj.getLexem().equals(";"))
                lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
            else
                break;
        }
        
        if(lexObj.getLexem().equals(")"))
            flag = true;
        else
            NeoSyntacticAnalyzerX.printError("Se esperaba )",lexObj.getCodeLine(), getClass().getName());
        return flag;
    }

}
