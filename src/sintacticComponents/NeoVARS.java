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
public class NeoVARS {
    private boolean flag;
    private NeoLexema lexObj;
    
    public boolean init(){
        do{ 
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
            if(lexObj.getToken().equalsIgnoreCase("iden")){
                lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
            }else
                NeoSyntacticAnalyzerX.printError("Se esperaba iden");
        }while(lexObj.getLexem().equalsIgnoreCase(","));
        
        if(lexObj.getLexem().equalsIgnoreCase(":")){
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        }else{
            NeoSyntacticAnalyzerX.printError("Se esperaba :");
        }
        
        if(lexObj.getLexem().equalsIgnoreCase("constante")){
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
            new NeoTIPO().init();
            if(lexObj.getLexem().equalsIgnoreCase(":=")){
                lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
                new NeoCTE().init();
            }else{
                NeoSyntacticAnalyzerX.printError("Se esperaba := ya que es definido como CONSTANTE");
            }
        }
        
        new NeoTIPO().init();
        
        if(lexObj.getLexem().equalsIgnoreCase(":=")){
                lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
                new NeoCTE().init();
        }else if(lexObj.getLexem().equalsIgnoreCase(";"))
            lexObj = NeoLexicAnalyzerX.getCurrentSymbol();
        else{
            NeoSyntacticAnalyzerX.printError("Se esperaba := o ;");
        
        
    }

}
