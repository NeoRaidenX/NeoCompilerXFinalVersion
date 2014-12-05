/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sintacticComponents;

/**
 * 
 * @author Neo Raiden X <neoraidenx@gmail.com>
 */
public class NeoSymbol {
    private String name, classType, type, dimen1, dimen2;

    public NeoSymbol(String name, String classType, String type, String dimen1, String dimen2) {
        this.name = name;
        this.classType = classType;
        this.type = type;
        this.dimen1 = dimen1;
        this.dimen2 = dimen2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDimen1() {
        return dimen1;
    }

    public void setDimen1(String dimen1) {
        this.dimen1 = dimen1;
    }

    public String getDimen2() {
        return dimen2;
    }

    public void setDimen2(String dimen2) {
        this.dimen2 = dimen2;
    }
    
    
}
