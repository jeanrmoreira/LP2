package figures;

import java.awt.Graphics;
import java.awt.Color;

public abstract class Figure {
      public int x, y;
      public int w, h;
      public Color contorno, fundo;
      
      
      
      public void drag (int dx, int dy) {
        x += dx;
        y += dy;
    }

    public abstract void paint (Graphics g);
    
      
}
