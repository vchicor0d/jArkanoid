/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arkanoid;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import sun.org.mozilla.javascript.internal.jdk11.VMBridge_jdk11;

/**
 *
 * @author Victor
 */
public class Hilobarra extends Thread{
    private Panel p;
    
    public Hilobarra (Panel p){
        this.p=p;
    }
    
    public boolean izda(){
        return (KeyEvent.KEY_PRESSED==37)?true:false;
    }
    
    public boolean dcha (){
        return (KeyEvent.KEY_PRESSED==39)?true:false;
    }
    
    public void run(){
        int x;
        boolean limX=false;
        while (true){
            x=p.getbarraX();
//            if (p.getBounds().width-50==x) limX=true;
//            if (x==0) limX=false;
//            x=(limX)?x-1:x+1;
//            p.setbarraX(x);
            p.repaint();
            try{
                sleep(10);
            } catch (InterruptedException ie){
                
            }
        }
    }
}
