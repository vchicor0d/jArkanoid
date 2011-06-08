/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arkanoid;

import java.awt.Color;

/**
 *
 * @author Victor
 */
public class Ladrillo {
    
    private Panel p;
    private boolean enabled;
    private int x;
    private int y;
    private java.awt.Color c;
    
    public Ladrillo(Panel p, int x, int y, java.awt.Color c){
        this.p=p;
        this.enabled=true;
        this.x=x;
        this.y=y;
        c=Color.BLUE;
        System.out.println(c);
    }
    
    public void disable(){
        enabled=false;
    }
    
    public int getx (){
        return x;
    }
    
    public int gety (){
        return y;
    }
    
    public java.awt.Color getColor(){
        return c;
    }
    
    public void setColor (){
        c= Color.black;
    }
    
}
