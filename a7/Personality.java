// Yingyun(Alice) Miao
// 5/23/17
// CSE142
// TA: Daniel Wang Barnes
// Assignment #7
//
// This program determines the personality types of people who take 
// the personality test known as the Keirsey Temperament Sorter. It
// takes files of name and personality answer pair and outputs it 
// to a file of choice. 
 
import java.util.*;
import java.io.*;
 
public class Personality {
 
   // This is a class constant to make the program more readable.
   public static final int DIMENSION = 4;
 
   public static void main(String[] args) 
           throws FileNotFoundException {
      intro();
      Scanner console = new Scanner(System.in);
      System.out.print("input file name? ");
      Scanner input = new Scanner(new File(console.next()));
      System.out.print("output file name? ");
      PrintStream output = new PrintStream(new File(console.next()));
      processFile(input, output);
 
   }
 
   // This method gives the introduction of the program.
   public static void intro() {
      System.out.println("This program processes a file of answers to the");
      System.out.println("Keirsey Temperament Sorter.  It converts the");
      System.out.println("various A and B answers for each person into");
      System.out.println("a sequence of B-percentages and then into a");
      System.out.println("four-letter personality type.");
      System.out.println();
   }
   
   // processes the given input file, sending a report to the given 
   // output, using 'input' Scanner and 'output' PrintStream
   public static void processFile(Scanner input, PrintStream output) {
      while (input.hasNextLine()) {
         output.print(input.nextLine() + ": ");
         String line = input.nextLine();
         int[] countA = countAnswers(line, 'A');
         int[] countB = countAnswers(line, 'B');
         int[] percentagesOfB = computePercentage(countA, countB);
         output.println(Arrays.toString(percentagesOfB) + " = " 
         + whichDimension(percentagesOfB));
      }
   }
 
   // counts the number of 'A' or 'B', and returns it as 
   // an array for a series of choice (A/B/-) stored in the
   // 'line' String. Parameter char choice stands for the 
   // choice of 'A' or 'B'
   public static int[] countAnswers(String line, char choice) {
      int[] countChoice = new int[DIMENSION];
      for (int i = 0; i < line.length(); i++) {
         char answer = line.toUpperCase().charAt(i);
         if (i % 7 == 0) {
            if (answer == choice) {
               countChoice[0]++;
            } 
         }
         for (int j = 1; j < DIMENSION; j++) {
            if (i % 7 == j * 2 || i % 7 == j * 2 - 1) {
               if (answer == choice) {
                  countChoice[j]++; 
               }
            }
         }
      }
      return countChoice;
   }
   
   // computes the percentage of 'B', taking in arrays int[] countA
   // and int[] countB, which are the number of 'A's and 'B's counted
   // in the countAnswers method, and returns the 'B' percentage as 
   // an integer array
   public static int[] computePercentage(int[] countA, int[] countB) {
      int[] bPercentages = new int[DIMENSION];
      for (int i = 0; i < DIMENSION; i++) {
         int total = countA[i] + countB[i];
         bPercentages[i] = (int) Math.round((double) countB[i] / total * 100);
      }
      return bPercentages;
   }
 
   // Determines the types of personality based on the 
   // percentage of 'B', using int[] percentagesOfB, which is
   // the array of percentage B. There are two dimensions of 
   // personality types: {"I", "N", "F", "P"} and {"E", "S", "T", "J"},
   // and returns the personality type of a given person as a String
   public static String whichDimension(int[] percentagesOfB) {
      String result = "";
      String [] dimensionA = {"I", "N", "F", "P"};
      String [] dimensionB = {"E", "S", "T", "J"};
      for (int i = 0; i < DIMENSION; i++) {
         if (percentagesOfB[i] > 50) {
            result += dimensionA[i];
         } else if (percentagesOfB[i] < 50) {
            result += dimensionB[i];
         } else {
            result += "X";
         }
      }
      return result;
   }
}