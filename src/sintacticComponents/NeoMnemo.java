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
public class NeoMnemo {
    String mnemo, dir1, dir2;

    public NeoMnemo(String mnemo, String dir1, String dir2) {
        this.mnemo = mnemo;
        this.dir1 = dir1;
        this.dir2 = dir2;
    }

    public String getMnemo() {
        return mnemo;
    }

    public void setMnemo(String mnemo) {
        this.mnemo = mnemo;
    }

    public String getDir1() {
        return dir1;
    }

    public void setDir1(String dir1) {
        this.dir1 = dir1;
    }

    public String getDir2() {
        return dir2;
    }

    public void setDir2(String dir2) {
        this.dir2 = dir2;
    }
    
}
