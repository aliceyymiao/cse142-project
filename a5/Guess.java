// Yingyun(Alice) Miao
// 5/2/17
// CSE142
// TA: Daniel Wang Barnes
// Assignment #5
//
// This program will run a guessing game that makes the players guess
// a number between 1 and 100 until they get the correct answer.

import java.util.*;

public class Guess {
   
   public static final int MAX = 100;
   
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      Random anyNumber = new Random();
      
      giveIntro();
      
      // initializes the integer values
      int numGames = 0;
      int totalGuesses = 0;
      int bestGuess = 100;
      // initializes the string value in order to "prime" the while loop
      String option = "Yes";
      
      // determines how many times the players want to play the game
      while (option.toUpperCase().startsWith("Y")) {
         int guess = playGame(console, anyNumber);
			totalGuesses += guess;
         bestGuess = Math.min(bestGuess, guess);
			numGames++;
			System.out.print("Do you want to play again? ");
			option = console.next();
		}

      results(numGames, totalGuesses, bestGuess);
   }

   // prints the introduction of the program
   public static void giveIntro() {
		System.out.println("This program allows you to play a guessing game.");
		System.out.println("I will think of a number between 1 and");
		System.out.println(MAX + " and will allow you to guess until");
		System.out.println("you get it.  For each guess, I will tell you");
		System.out.println("whether the right answer is higher or lower");
		System.out.println("than your guess.");
	}
   
   // hints the players about the number they are guessing, 
   // and returns the number of guesses of one game as a integer 
   // value, using 'console' Scanner and 'anyNumber' Random
   public static int playGame(Scanner console, Random anyNumber) {
	   System.out.println();
		System.out.println("I'm thinking of a number between 1 and " + MAX + "...");
		int answer = anyNumber.nextInt(MAX) + 1;
      int numGuesses = 1;
      System.out.print("Your guess? ");
      int yourGuess = console.nextInt();
      
      while (answer != yourGuess) {
         if (answer > yourGuess) {
            System.out.println("It's higher.");
         } else {
            System.out.println("It's lower.");
         }
         System.out.print("Your guess? ");
         yourGuess = console.nextInt();
         numGuesses++;
      }
   
      System.out.println("You got it right in " + numGuesses + " guesses");
      return numGuesses;
   }
   
   // prints the overall game result, which includes the total number
   // of games, the total number of guesses, and the best guess.
   public static void results(int numGames, int totalGuesses, int bestGuess) {
      System.out.println();
      System.out.println("Overall results:");
      System.out.println("    total games   = " + numGames);
      System.out.println("    total guesses = " + totalGuesses);
      System.out.println("    guesses/game  = " + rounded((totalGuesses * 1.0) 
                                                         / (numGames * 1.0)));
      System.out.println("    best game     = " + bestGuess);
   }
   
   // rounds the double 'x' into one decimal place and returns it as a
   // double value. It is used to round the double total number of 
   // guesses divided by the number of games in the result
   public static double rounded(double x) {
      return (Math.round(x * 10)) / 10.0;
   }
}