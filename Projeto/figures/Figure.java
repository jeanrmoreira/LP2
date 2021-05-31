package figures;

import java.awt.Graphics;
import java.awt.Color;
import ivisible.IVisible;
import java.io.Serializable;
import ivisible.IVisible;

public abstract class Figure implements IVisible, Serializable {
      public int x, y;
      public int w, h;
      public Color contorno, fundo;
      
      
      
      public void drag (int dx, int dy) {
        x += dx;
        y += dy;
    }

public boolean clicked (int x, int y) {
        return (this.x<=x && x<=this.x+this.w && this.y<=y && y<=this.y+this.h);
    }
    public abstract void paint (Graphics g, boolean focused);
    
      
}
