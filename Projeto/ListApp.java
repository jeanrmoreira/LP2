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
    
Figure focus = null;
Point ponto;

   
    ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        ); 
        this.addMouseListener
        (
            new MouseAdapter()
            {
                public void mousePressed(MouseEvent evt)
                {    Point ponto = getMousePosition();
                     int px = ponto.x; 
                     int py = ponto.y;
                 
                    focus = null;
                    for (Figure fig: figs)
                    {
                        if (fig.clicked(evt.getX(), evt.getY()))    
                        {   focus = fig;
                            figs.remove(focus);
			    figs.add(focus);
                            repaint();
                            break;
                        }
                        else
                        { 
                            focus = null;
                            repaint();
                        }
                    }
                }
            }
        );
        
        this.addMouseMotionListener
        ( 
            new MouseMotionAdapter()
            {
                public void mouseDragged (MouseEvent evt)
                {       if (focus != null) 
                        {   focus.x = evt.getX() - focus.w/2;
        		    focus.y = evt.getY() - focus.h/2;
        		    repaint();
                        }
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
                    }  if (evt.getKeyChar() == 't') {
                         figs.add(new Trian(x, y, w, h, contorno, fill));
                    }
                       if(evt.getKeyCode() == 127){
                                figs.remove(focus);
                                focus = null;
                    }
                       if(evt.getKeyChar() == '-'){
		         for(Figure fig: figs){
                             if(focus == fig){
				fig.w--;
				fig.h--;
			      }
			}
		       }
						 
			if(evt.getKeyChar() == '+'){
			  for(Figure fig: figs){
                              if(focus == fig){
				fig.w++;
				fig.h++;
			       }
			   }
			} 
		        if (evt.getKeyCode() == 37) {
			  for(Figure fig: figs){
			      if(focus == fig){
			        fig.x -= 5;     
			      }
			  }
					   
			}
					   
			if (evt.getKeyCode() == 38) {
			  for(Figure fig: figs){
			      if(focus == fig){
			        fig.y -= 5;     
			      }
			   }
					   
			}
					   
			if (evt.getKeyCode() == 39) {
			  for(Figure fig: figs){
			      if(focus == fig){
				fig.x += 5;     
			      }
			  }
					   
			}
					   
			if (evt.getKeyCode() == 40) {
			  for(Figure fig: figs){
			      if(focus == fig){
			        fig.y += 5;     
			      }
			  }
					   
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
            Graphics2D g2d = (Graphics2D) g;
            
            if (focus != null)
        {       g2d.setColor(Color.RED);
                g2d.drawRect(focus.x-1, focus.y-1, focus.w+1, focus.h+2);
            }
            
        }
        
    }
}

