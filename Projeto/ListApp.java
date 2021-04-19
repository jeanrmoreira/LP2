import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import figures.*;



class ListApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Random rand = new Random();

    ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        ); 

              
        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
                    int x = rand.nextInt(350);
                    int y = rand.nextInt(350);
                    int w = rand.nextInt(50);
                    int h = rand.nextInt(50);
                    int anguloInicial = rand.nextInt(360);
                    int anguloArc = rand.nextInt(360);
                    
                  Color contorno = new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));
                   Color fill = new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));
                    if (evt.getKeyChar() == 'r') {
                        Rect r = new Rect(x,y, w,h, contorno, fill);
                        figs.add(r);
                    }  if (evt.getKeyChar() == 'e') {
                        figs.add(new Ellipse(x, y,w, h,contorno, fill));
                    }
                        if (evt.getKeyChar() == 'a') {
                        figs.add(new Arc(x, y,w, h,contorno, fill, anguloInicial, anguloArc));
                    }  else if (evt.getKeyChar() == 't') {
                         figs.add(new Trian(x, y, w, h, contorno, fill));
                    }
                    repaint();
                }
            }
        );

        this.setTitle("Lista de Figuras");
        this.setSize(350, 350);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Figure fig: this.figs) {
            fig.paint(g);
            
        }
        
    }
}

