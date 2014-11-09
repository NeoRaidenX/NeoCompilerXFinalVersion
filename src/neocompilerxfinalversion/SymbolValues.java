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
public class SymbolValues {
    static final int NO = 0, YES = 1, DEFAULT = 2;
    String token, type;
    int init;
    public SymbolValues(String token, String type, int init){
        this.token = token;
        this.type = type;
        this.init = init;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getInit() {
        return init;
    }

    public void setInit(int init) {
        this.init = init;
    }
    
}
