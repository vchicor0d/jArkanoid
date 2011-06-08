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
    private ArrayList<Ladrillo> ladrillos;

    public Panel() {
        super();
        this.bolax=0;
        this.bolay=0;
        this.punt=0;
        ladrillos=new ArrayList<Ladrillo> ();
        //this.barrax=(526/2)-25;
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
    
    private void enladrillar(){
        for (int i=10; i<this.getBounds().width-60; i+=60){
            ladrillos.add(new Ladrillo(this, i, 30, Color.blue));
        }
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.black);
        if (primera){
            barrax=(this.getBounds().width/2)-25;
            enladrillar();
        }
        for (int i=0; i<ladrillos.size(); i++){
            int x=ladrillos.get(i).getx();
            int y=ladrillos.get(i).gety();
            java.awt.Color c = ladrillos.get(i).getColor();
            //System.out.println("x:"+x+" y:"+y+" color:"+c);
            g.setColor(c);
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
