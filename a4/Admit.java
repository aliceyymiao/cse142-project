// Yingyun(Alice) Miao
// 4/25/17
// CSE142
// TA: Daniel Wang Barnes
// Assignment #4
//
// This program is designed to compute an overall score that 
// consists of an SAT or ACT score and a GPA score for each 
// applicant for universities, and compares them and indicates
// which one is better.

import java.util.*;

public class Admit {
   
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      
      // prints the introduction of the program
      giveIntro();
      
      // computes exam, GPA, and overall scores of two applicants
      double overallScore1 = overallScore(console, 1);
      double overallScore2 = overallScore(console, 2);
      
      // compares the overall scores of the applicants
      compare(overallScore1, overallScore2);
   }
   
   // prints the introduction of the program
   public static void giveIntro() {
      System.out.println("This program compares two applicants to");
      System.out.println("determine which one seems like the stronger");
      System.out.println("applicant.  For each candidate I will need");
      System.out.println("either SAT or ACT scores plus a weighted GPA.");
      System.out.println();
   }
   
   // rounds the number 'x' into one decimal place 
   // and returns it as a double value
   public static double rounded(double x) {
		return (Math.round(x * 10)) / 10.0;
	}
   
   // computes the total score of the 'applicant', using 'console' Scanner,
   // and returns it as a double value
   public static double overallScore(Scanner console, int applicant) {
		System.out.println("Information for applicant #" + applicant + ":");
		System.out.print("    do you have 1) SAT scores or 2) ACT scores? ");
		int choose = console.nextInt();
      double examScore;
      if (choose == 1) {
         examScore = computeSATrange(console);
      } else {
         examScore = computeACTrange(console);
      }
		System.out.println("    exam score = " + rounded(examScore));
      double GPA = computeGPA(console);
		return examScore + GPA;
	}
   
   // computes the SAT score range, using 'console' Scanner,
   // and returns it as a double value
	public static double computeSATrange(Scanner console) {
		System.out.print("    SAT math? ");
		int mathScore = console.nextInt();
		System.out.print("    SAT critical reading? ");
		int readingScore = console.nextInt();
		System.out.print("    SAT writing? ");
		int writingScore = console.nextInt();
      double SATscore = (2 * mathScore + readingScore + writingScore) / 32.0;
		return SATscore;
	}
   
   // computes the ACT score range, using 'console' Scanner,
   // and returns it as a double value
	public static double computeACTrange(Scanner console) {
		System.out.print("    ACT English? ");
		int englishScore = console.nextInt();
		System.out.print("    ACT math? ");
		int mathScore = console.nextInt();
		System.out.print("    ACT reading? ");
		int readingScore = console.nextInt();
		System.out.print("    ACT science? ");
		int scienceScore = console.nextInt();
      double ACTscore = (englishScore + 2 * mathScore + readingScore + scienceScore) / 1.8;
		return ACTscore;
	}
   
   // computes the GPA range, using 'console' Scanner,
   // and returns it as a double value
	public static double computeGPA(Scanner console) {
		System.out.print("    overall GPA? ");
		double GPA = console.nextDouble();
		System.out.print("    max GPA? ");
		double maxGPA = console.nextDouble();
		System.out.print("    Transcript Multiplier? ");
		double multiplier = console.nextDouble();
		double GPAscore = (GPA / maxGPA) * 100 * multiplier;
		System.out.println("    GPA score = " + rounded(GPAscore));
		System.out.println();
		return GPAscore;
	}
   
   // compares the overall scores of two applicants by comparing 
   // 'overallscore1' and 'overallscore2' 
	public static void compare(double overallScore1, double overallScore2) {
		System.out.println("First applicant overall score  = " + rounded(overallScore1));
		System.out.println("Second applicant overall score = " + rounded(overallScore2));
      if (overallScore1 < overallScore2) {
			System.out.print("The second applicant seems to be better");
		} else if (overallScore1 > overallScore2) {
			System.out.print("The first applicant seems to be better");
		} else {
			System.out.println("The two applicants seem to be equal");
		}
	}
}   