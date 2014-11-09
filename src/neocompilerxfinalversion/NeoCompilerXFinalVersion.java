/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package neocompilerxfinalversion;

/**
 *
 * @author Neo Raiden X <neoraidenx@gmail.com>
 */
public class NeoCompilerXFinalVersion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        NeoLexicAnalyzerX NeoLex = new NeoLexicAnalyzerX();
        if(NeoLex.NeoLexicAnalyzer()){
            for(String lexem : NeoLex.lexemList)
                System.out.println(lexem);
        }
    }
    
}
