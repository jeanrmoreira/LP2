import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class PaintApp {
    public static void main (String[] args) {
        PaintFrame frame = new PaintFrame();
        frame.setVisible(true);
    }
}

class PaintFrame extends JFrame {
    Rect r1,r2,r3;

    PaintFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Painting Figures");
        this.setSize(350, 350);
        this.r1 = new Rect(90,100, 200,80,Color.black, Color.red);
        this.r2 = new Rect(180,230, 120,40,Color.green, Color.blue);
        this.r3 = new Rect(70,260, 70,60,Color.orange, Color.yellow);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.r2.paint(g);
        this.r3.paint(g);
    }
}

class Rect {
    int x, y;
    int w, h;
    Color contorno;
    Color fundo;

    Rect (int x, int y, int w, int h, Color contorno, Color fundo) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.contorno =  contorno;
        this.fundo = fundo;
    }

    void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setColor(fundo);
        g2d.fillRect(this.x,this.y, this.w,this.h);
        g2d.setColor(contorno);
        g2d.drawRect(this.x,this.y, this.w,this.h);
    }
}
