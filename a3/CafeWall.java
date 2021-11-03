// Yingyun(Alice) Miao
// 4/18/17
// CSE142
// TA: Daniel Wang Barnes
// Assignment #3
//
// This program will produce a Cafe Wall illusion.

import java.awt.*;

public class CafeWall {
   
   public static final int MORTAR = 2;
   
   public static void main(String[] args) {
      DrawingPanel p = new DrawingPanel(650, 400);
      p.setBackground(Color.GRAY);
      Graphics g = p.getGraphics();
      
      drawRow(g, 0, 0, 20, 4);
		drawRow(g, 50, 70, 30, 5);
		drawGrid(g, 10, 150, 25, 4, 0);
		drawGrid(g, 250, 200, 25, 3, 10);
		drawGrid(g, 425, 180, 20, 5, 10);
		drawGrid(g, 400, 20, 35, 2, 35);
	}
   
   // draws black and white boxes of 'size' width and height,
   // starting at coordinates 'x' and 'y', using 'g' Graphics
	public static void drawRow(Graphics g, int x, int y, int size, int numberOfPairs) {
		for (int i = 0; i < numberOfPairs; i++) {
			g.setColor(Color.BLACK);
			g.fillRect(x + 2 * i * size, y, size, size);
			g.setColor(Color.WHITE);
			g.fillRect(x + (2 * i + 1) * size, y, size, size);
         g.setColor(Color.BLUE);
			g.drawLine(x + 2 * i * size, y, x + (2 * i + 1) * size, y + size);
			g.drawLine(x + 2 * i * size, y + size, x + (2 * i + 1) * size, y);
		}
	}
	
   // draws the girds that are made of rows consisting of black and white boxes of
   // 'size' width and height, starting at coordinates 'x' and 'y', using 'g' Graphics
	public static void drawGrid(Graphics g, int x, int y, int size, 
                               int numberOfPairs, int rowOffset) {
		for(int line = 0; line < numberOfPairs * 2; line++) {
		   drawRow(g, x + (line + 2) % 2 * rowOffset, y + line * (size + MORTAR), 
                 size, numberOfPairs); 	
      }
	}   
}
   
