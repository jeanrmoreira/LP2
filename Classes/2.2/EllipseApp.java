import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

class EllipseApp {
    public static void main (String[] args) {
        EllipseFrame frame = new EllipseFrame();
        frame.setVisible(true);
    }
}

class EllipseFrame extends JFrame {
    Ellipse e1, e2, e3, e4;

    EllipseFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Ellipse");
        this.setSize(350, 350);
        this.e1 = new Ellipse(50,50, 200,200, Color.black, Color.white);
        this.e2 = new Ellipse(100,100, 100,100, Color.blue, Color.green);
        this.e3 = new Ellipse(125,125, 50,50, Color.black, Color.black);
        this.e4 = new Ellipse(125,125, 15,15, Color.gray, Color.white);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.e1.paint(g);
        this.e2.paint(g);
        this.e3.paint(g);
        this.e4.paint(g);
    }
}


class Ellipse {
    int x, y;
    int w, h;
    Color contorno;
    Color fundo;

    Ellipse (int x, int y, int w, int h, Color contorno, Color fundo) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.contorno = contorno;
        this.fundo = fundo;
    }

    void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(fundo);
        g2d.fill(new Ellipse2D.Double(this.x, this.y, this.w, this.h));
         g2d.setColor(contorno);
        g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
    }
}
