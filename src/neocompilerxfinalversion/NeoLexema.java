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
public class NeoLexema {
    String lexem, token;
    int codeLine;
    public NeoLexema(String lexem, String lexemType, int codeLine){
        this.lexem = lexem;
        this.token = lexemType;
        this.codeLine = codeLine;
    }

    public String getLexem() {
        return lexem;
    }

    public void setLexem(String lexem) {
        this.lexem = lexem;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String lexemType) {
        this.token = lexemType;
    }

    public int getCodeLine() {
        return codeLine;
    }

    public void setCodeLine(int codeLine) {
        this.codeLine = codeLine;
    }
    
    
    

}
