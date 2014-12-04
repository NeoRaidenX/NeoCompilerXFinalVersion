/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package neocompilerxfinalversion;

import sintacticComponents.NeoPRGM;

/**
 * 
 * @author Neo Raiden X <neoraidenx@gmail.com>
 */
public class NeoSyntacticAnalyzerX {

    public NeoSyntacticAnalyzerX(){
        
    }
    
    public void init(){
        new NeoPRGM().execute();
    }
    
    public static void printError(String errorString, int currentLine, String classError){
        System.err.println("Debug: " + classError);
        System.err.print("[Error SINTACTICO en linea: " + currentLine + "] -> ");
        System.err.println(errorString);
    }
}
