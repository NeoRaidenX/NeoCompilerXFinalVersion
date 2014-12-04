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
public class NeoCOMANDO {
    private NeoLexema lexObj;
    private boolean flag;
    
    public NeoCOMANDO(NeoLexema lexObj){
        this.lexObj = lexObj;
    }
    
    public boolean init(){
            if(lexObj.getLexem().equalsIgnoreCase("para")){
                if(new NeoPARA(lexObj).init())
                    flag = true;
            }
            else if(lexObj.getLexem().equalsIgnoreCase("regresa")){
               if(new NeoREGRESA(lexObj).init())
                   flag = true;
            }
            else if(lexObj.getLexem().equalsIgnoreCase("si")){
                if(new NeoSI(lexObj).init())
                    flag = true;
            }
            else if(lexObj.getLexem().equalsIgnoreCase("despliega")){
                if(new NeoDESPLIEGA(lexObj).init())
                    flag = true;
            }
            else if(lexObj.getLexem().equalsIgnoreCase("lee")){
                if(new NeoLEE(lexObj).init())
                    flag = true;
            }
            else if(lexObj.getLexem().equalsIgnoreCase("nueva_linea")){
                if(new NeoNUEVALINEA(lexObj).init())
                    flag = true;
            }
            else if(lexObj.getToken().equalsIgnoreCase("iden")){
                if(new NeoLprocAsigna(lexObj).init())
                    flag = true;
            }
            else 
                NeoSyntacticAnalyzerX.printError("Se esperaba COMANDO",lexObj.getCodeLine(), getClass().getName());
        return flag;
    }
    
}
