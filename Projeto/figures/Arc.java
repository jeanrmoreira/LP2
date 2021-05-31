package figures;

import java.awt.*;

public class Arc extends Figure {
   
       public int anguloInicial, anguloArc;
    

    public Arc (int x, int y, int w, int h, Color contorno, Color fundo, int anguloInicial, int anguloArc) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.contorno = contorno;
        this.fundo = fundo;
        this.anguloInicial = anguloInicial;
        this.anguloArc = anguloArc;
    }

    public void print () {
        System.out.format("Arco de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setColor(fundo);
        g2d.fillArc(this.x,this.y, this.w,this.h, this.anguloInicial, this.anguloArc);
        g2d.setColor(contorno);
        g2d.drawArc(this.x,this.y, this.w,this.h, this.anguloInicial, this.anguloArc);
    }
}
