package figures;

import java.awt.Graphics;
import java.awt.Color;

public abstract class Figure {
      int x, y;
      int w, h;
      Color contorno, fundo;

    public abstract void paint (Graphics g);
      
}
