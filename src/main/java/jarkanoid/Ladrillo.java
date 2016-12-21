/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jarkanoid;

import java.awt.Color;

/**
 *
 * @author Victor
 */
public class Ladrillo {

    private boolean enabled;
    private int x;
    private int y;

    public Ladrillo(int x, int y){
        this.enabled=true;
        this.x=x;
        this.y=y;
    }

    public void disable(){
        enabled=false;
    }

    public boolean isenabled(){
        return enabled;
    }

    public int getx (){
        return x;
    }

    public int gety (){
        return y;
    }

}
