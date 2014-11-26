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
    String lexem, lexemType;
    public NeoLexema(String lexem, String lexemType){
        this.lexem = lexem;
        this.lexemType = lexemType;
    }

    public String getLexem() {
        return lexem;
    }

    public void setLexem(String lexem) {
        this.lexem = lexem;
    }

    public String getLexemType() {
        return lexemType;
    }

    public void setLexemType(String lexemType) {
        this.lexemType = lexemType;
    }
    

}
