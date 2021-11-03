// Yingyun(Alice) Miao
// 4/18/17
// CSE142
// TA: Daniel Wang Barnes
// Assignment #3
//
// This program will produce a staircase, a box and a ball.

import java.awt.*;

public class Doodle {
 
   public static void main(String[] args) {
      DrawingPanel p = new DrawingPanel(600, 500);
      p.setBackground(Color.RED);
      Graphics g = p.getGraphics();
 
      drawSquare(g, 500, 400, 100, 100);
      drawStairs(g, 0, 250, 50, 50);
      drawBall(g, 375, 275, 100, 100);
   }
 
   // draws a black box of 'width' width and 'height' height,
   // starting at coordinates 'x' and 'y', using 'g' Graphics
   public static void drawSquare(Graphics g, int x, int y, int width, int height) {
      g.setColor(Color.BLACK);
      g.fillRect(x, y, width, height);
   }   
 
   // draws a staircase made up of black boxes of 'width' width and 'height'
   // height, starting at coordinates 'x' and 'y', using 'g' Graphics
   public static void drawStairs(Graphics g, int x, int y, int width, int height) {
      for (int line = 0; line < 5; line++) {
         drawSquare(g, x, y + height * line, width + height * line, height);
      }
   }
 
   // draws a ball of 'width' width and 'height' height, starting at coordinates
   // 'x' and 'y', using 'g' Graphics
   public static void drawBall(Graphics g, int x, int y, int width, int height) {
      g.setColor(Color.PINK);
      g.fillOval(x, y, width, height);
      g.setColor(Color.YELLOW);
      g.drawOval(x + width / 4, y + width / 4, width / 2, height / 2);
      g.setColor(Color.BLUE);
      g.fillOval(x + 3 * width / 8, y + 3 * width / 8, width / 4, height / 4);
   }
}
