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
    private int fase;
    private int restantes=1;
    private boolean primera=true;
    private boolean siguiente=false;
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
    
    public void siguiente(){
        siguiente=true;
        fase++;
    }
    
    public int getrestantes(){
        return restantes;
    }
    
    public boolean golpe(int x, int y){
        boolean golpe=false;
        Ladrillo l;
        for (int i=0; i<ladrillos.size(); i++){
            l=ladrillos.get(i);
            if (l.isenabled()){
                if (y-l.gety()<=10 && y-l.gety()>=0){
                    if (x-l.getx()<=50 && x-l.getx()>=0){
                       golpe=true;
                       ladrillos.get(i).disable();
                       restantes--;
                    }
                }
            }
        }
        return golpe;
    }
    
    private void enladrillar(){
        ladrillos=new ArrayList<Ladrillo> ();
        for (int f=0; f<fase; f++){
            for (int i=10; i<this.getBounds().width-60; i+=60){
                ladrillos.add(new Ladrillo(i, 30+f*(20)));
            }
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.black);
        if (primera){
            fase=1;
            bolax=(this.getBounds().width/2)-7;
            bolay=this.getBounds().height-30;
            barrax=(this.getBounds().width/2)-25;
            punt=0;
            enladrillar();
            restantes=ladrillos.size();
            primera=false;
        }
        if (siguiente){
            bolax=(this.getBounds().width/2)-7;
            bolay=this.getBounds().height-30;
            barrax=(this.getBounds().width/2)-25;
            enladrillar();
            restantes=ladrillos.size();
            siguiente=false;
        }
        for (int i=0; i<ladrillos.size(); i++){
            int x=ladrillos.get(i).getx();
            int y=ladrillos.get(i).gety();
            g.setColor((ladrillos.get(i).isenabled())?Color.blue:Color.BLACK);
            g.fillRect(x, y, 50, 10);
        }
        g.setColor(Color.red);
        g.fillOval(bolax, bolay, 15, 15);
        g.setColor(Color.white);
        g.fillRect(barrax, this.getBounds().height-15, 50, 10);
        g.drawString("Fase: "+fase+" Puntuación: "+punt, 10, 10);
    }

}
