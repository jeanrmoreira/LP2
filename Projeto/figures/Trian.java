package figures;

import java.awt.*;

public class Trian extends Figure {

    Polygon p = new Polygon();
    
    public Trian (int x, int y, int w, int h, Color contorno, Color fundo) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.contorno = contorno;
        this.fundo = fundo;
        
        p.npoints = 3;
        p.xpoints[0] = x;
        p.xpoints[1] = w/2+x;
        p.xpoints[2] = w+x;
        
        p.ypoints[0] = y+h;
        p.ypoints[1] = y;
        p.ypoints[2] = y+h;
        
        
    }

    public void print () {
        System.out.format("Triângulo de tamanho (%d,%d) na posicao (%d,%d).\n",
             this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setColor(fundo);
        g2d.fillPolygon(p.xpoints, p.ypoints, 3);
        g2d.setColor(contorno);
        g2d.drawPolygon(p.xpoints, p.ypoints, 3);
        
        
    }
}
