/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arkanoid;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Panel extends JPanel{
    private int bolax;
    private int bolay;
    private int barrax;
    private int punt;
    private boolean primera=true;
    private ArrayList<Ladrillo> ladrillos=new ArrayList<Ladrillo> ();;

    public Panel() {
        super();
        this.punt=0;
    }

    public int getbolaX() {
        return bolax;
    }

    public void setbolaX(int x) {
        this.bolax = x;
    }

    public int getbolaY() {
        return bolay;
    }

    public void setbolaY(int y) {
        this.bolay = y;
    }
    
    public int getbarraX(){
        return barrax;
    }
    
    public void setbarraX(int barrax){
        this.barrax=barrax;
    }
    
    public void setpunt(int punt){
        this.punt=punt;
    }
    
    public int getpunt(){
        return punt;
    }
    
    public void setprimera(){
        primera=true;
    }
    
    public boolean ladrillo(int x, int y){
        boolean golpe=false;
        Ladrillo l;
        for (int i=0; i<ladrillos.size(); i++){
            l=ladrillos.get(i);
            if (l.isenabled() && l.getx()-x<-50 && l.getx()-x>=0 && l.gety()-y<-10 && l.gety()-y>=0){
                golpe=true;
                ladrillos.get(i).disable();
            }
        }
        return golpe;
    }
    
    private void enladrillar(){
        ladrillos=new ArrayList<Ladrillo> ();
        for (int i=10; i<this.getBounds().width-60; i+=60){
            ladrillos.add(new Ladrillo(i, 30));
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.black);
        if (primera){
            bolax=(this.getBounds().width/2)-7;
            bolay=this.getBounds().height-30;
            barrax=(this.getBounds().width/2)-25;
            enladrillar();
        }
        for (int i=0; i<ladrillos.size(); i++){
            int x=ladrillos.get(i).getx();
            int y=ladrillos.get(i).gety();
            //System.out.println("x:"+x+" y:"+y+" color:"+c);
            g.setColor((ladrillos.get(i).isenabled())?Color.blue:Color.BLACK);
            g.fillRect(x, y, 50, 10);
        }
//        for (int i=10; i<this.getBounds().width-60; i+=60){
//            g.setColor(Color.blue);
//            g.fillRect(i, 30, 50, 10);
//        }
        primera=false;
        g.setColor(Color.red);
        g.fillOval(bolax, bolay, 15, 15);
        g.setColor(Color.white);
        g.fillRect(barrax, this.getBounds().height-15, 50, 10);
        g.drawString("Puntuación: "+punt, 10, 10);
    }

}
