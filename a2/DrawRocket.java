// Yingyun(Alice) Miao
// 4/11/17
// CSE142
// TA: Daniel Wang Barnes
// Assignment #2
//
// This program will produce cool rocket ships of different sizes.

public class DrawRocket {
   
   public static final int SIZE = 3;
   
   public static void main(String[] args) {
      drawTip();
      drawSectionDivision();
      drawUpperPart();
      drawLowerPart();
      drawSectionDivision();
      drawLowerPart();
      drawUpperPart();
      drawSectionDivision();
      drawTip();
   }
   
   // prints the cone
   public static void drawTip() {
      for (int line = 1; line <= SIZE * 2 - 1; line++) {
         for (int space = SIZE * 2 - line; space >= 1; space--) {
            System.out.print(" ");
         }
         for (int slash = 1; slash <= line; slash++) {
            System.out.print("/");
         }
         System.out.print("**");
         for (int slash = 1; slash <= line; slash++) {
            System.out.print("\\");
         }
         System.out.println();
      }  
   }
   
   // prints the upper part of the cabin
   public static void drawUpperPart() {
      for (int line = 1; line <= SIZE; line++) {
         System.out.print("|");
         for (int dots = 1; dots <= SIZE - line; dots++) {
            System.out.print(".");
         }
         for (int arrow = line; arrow >= 1; arrow--) {
            System.out.print("/\\");
         }
         for (int dots = SIZE * 2 - line * 2; dots >= 1; dots--) {
            System.out.print(".");
         }
         for (int arrow = line; arrow >= 1; arrow--) {
            System.out.print("/\\");
         }
         for (int dots = SIZE - line; dots >= 1; dots--) {
            System.out.print(".");
         }
         System.out.println("|");
      }
   }
   
   // prints the lower part of the cabin
   public static void drawLowerPart() {
      for (int line = 1; line <= SIZE; line++) {
         System.out.print("|");
         for (int dots = 1; dots <= line - 1; dots++) {
            System.out.print(".");
         }
         for (int arrow = 1; arrow <= SIZE - line + 1; arrow++) {
            System.out.print("\\/");
         }
         for (int dots = 1; dots <= line * 2 - 2; dots++) {
            System.out.print(".");
         }
         for (int arrow = 1; arrow <= SIZE - line + 1; arrow++) {
            System.out.print("\\/");
         }
         for (int dots = 1; dots <= line - 1; dots++) {
            System.out.print(".");
         }
         System.out.println("|");
      }
   }

   // prints the line between different parts
   public static void drawSectionDivision() {
      System.out.print("+");
      for (int width = 0; width < SIZE * 2; width++) {
         System.out.print("=*");
      }
      System.out.println("+");
   }   
}