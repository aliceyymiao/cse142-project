// Yingyun(Alice) Miao
// 4/11/17
// CSE142
// TA: Daniel Wang Barnes
// Assignment #2
// 
// This program will produce a 5-year-old child's birthday cake.

public class AsciiArt {
   public static void main(String[] args) {
      drawCandles();
      drawCream();
      drawCake();
      drawBottom();
   }
  
   // prints the candles
   public static void drawCandles() {
      for (int space = 1; space <= 6; space++) {
         System.out.print(" ");
      }
      for (int i = 1; i <= 5; i++) {
         System.out.print("|");
      }   
      System.out.println();
   }
   
   // prints the cream
   public static void drawCream() {
      for (int space = 1; space <= 4; space++) {
         System.out.print(" ");
      }
      for (int i = 1; i <= 10; i++) {
         System.out.print("=");
      }
      System.out.println();
   }
   
   // prints the body
   public static void drawCake() {
      for (int line = 1; line <= 4; line++) {
         for (int space = 1; space <= 5 - line; space++) {
            System.out.print(" ");
         }
         System.out.print("|*  ");
         for (int star = 1; star <= 2 * line; star++) {
            System.out.print("*");
         }
         System.out.println("  *|");
      }
   }
   
   // prints the bottom line
   public static void drawBottom() {
      for (int dash = 1; dash <= 18; dash++) {
         System.out.print("-");
      }
   }
}
         

   