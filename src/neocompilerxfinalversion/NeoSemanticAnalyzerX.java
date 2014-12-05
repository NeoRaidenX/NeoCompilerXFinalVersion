/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package neocompilerxfinalversion;

import java.util.ArrayList;
import sintacticComponents.NeoMnemo;
import sintacticComponents.NeoSymbol;

/**
 * 
 * @author Neo Raiden X <neoraidenx@gmail.com>
 */
public class NeoSemanticAnalyzerX {
    public static ArrayList<NeoSymbol> symTab = new ArrayList();
    public static ArrayList<NeoMnemo> codTab = new ArrayList();
    public static String ambito;

    public static String getAmbito() {
        return ambito;
    }

    public static void setAmbito(String ambito) {
        NeoSemanticAnalyzerX.ambito = ambito;
    }
    
    

}
