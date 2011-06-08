/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arkanoid;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class Hilobola extends Thread{
    
    private Panel p;
    
    public Hilobola (Panel p){
        this.p=p;
    }
    
    public void run(){
        int x;
        int y;
        int vel=10;
        boolean limX=false, limY=false;
        while (true){
            x=p.getbolaX();
            y=p.getbolaY();
            if (p.getBounds().width-15==x){
                limX=true;
            }
            if (x==0){
                limX=false;
            }
            if (p.getBounds().height-25==y && p.getbarraX()-x>=-50 && p.getbarraX()-x<=15){
                limY=true;
                p.setpunt(p.getpunt()+1);
            }
            if (y==0){
                limY=false;
            }
            x=(limX)?x-1:x+1;
            y=(limY)?y-1:y+1;
            p.setbolaX(x);
            p.setbolaY(y);
            p.repaint();
            if (y>p.getBounds().height){
                int opcion=JOptionPane.showConfirmDialog(p, "Jugar de nuevo?", "Has perdido!", JOptionPane.YES_NO_OPTION);
                if (opcion==1){
                    super.interrupt();
                    return;
                } else {
                    p.setbolaX(0);
                    p.setbolaY(0);
                    p.setbarraX((p.getBounds().width/2)-25);
                    p.setpunt(0);
                }
            }
            try{
                sleep(vel);
            } catch (InterruptedException ie){
                
            }
        }
    }
}
