// Yingyun(Alice) Miao
// 5/16/17
// CSE142
// TA: Daniel Wang Barnes
// Assignment #6
//
// This program will search data in a file obtained from the Social Security 
// Administration that shows the popularity of a given name for children over
// the last 130 years in the US, prompt the user for a name and gender, and then 
// display the name's meaning and popularity as console text and as a graphical
// bar chart.
 
import java.util.*;
import java.awt.*;
import java.io.*;
 
public class BabyNames {
   
   public static final int HEIGHT = 30;
   public static final int START_YEAR = 1890;
   public static final int WIDTH = 60;
   public static final int NUM_DECADES = 13;
 
   public static void main(String[] args) throws FileNotFoundException {
 
      Scanner console = new Scanner(System.in);
 
      // scanner that reads the names and meanings files
      Scanner names = new Scanner(new File("names.txt"));
      Scanner meaningF = new Scanner(new File("meanings.txt"));
      
      // prints the introduction of the program
      intro();
      // let the user search for the name and gender
      System.out.print("Name: ");
      String name = console.next();
      System.out.print("Gender (M or F): ");
      String gender = console.next();
      // stores the lines returned from the readInfo method
      String rankLine = readInfo(names, name, gender);
      String meaning = readInfo(meaningF, name, gender);
 
      // if statement that decides whether or not to draw the graph
      // and give the information based on the search keywords from the user
      if (rankLine == null) {
         System.out.println("\"" + name + "\"" + " not found.");
      } else {
         DrawingPanel p = new DrawingPanel(780, 560);
         Graphics g = p.getGraphics();
         drawBackground(g, meaning);
         drawGraph(g, rankLine); 
      }
   }
 
   // prints the introduction of the program   
   public static void intro(){
      System.out.println("This program allows you to search through the");
      System.out.println("data from the Social Security Administration");
      System.out.println("to see how popular a particular name has been");
      System.out.println("since " + START_YEAR + ".");
      System.out.println();    
   }
 
   // goes through the names and meanings files, using
   // 'console' Scanner, 'name' and 'gender' Strings to
   // search for the information from the files. Returns
   // the line that the name is at in the names file
   // and the meanings file
   public static String readInfo(Scanner console, String name,
                                 String gender) {
      
      while(console.hasNextLine()) {
         String nextLine = console.nextLine();
         Scanner word = new Scanner(nextLine);
         String findName = word.next();
         String findGender = word.next();
         if (findName.toLowerCase().equals(name.toLowerCase())
             && findGender.toLowerCase().equals(gender.toLowerCase())) {
            System.out.println(nextLine);
            return nextLine;
         }
      }
      return null;// if cannot find the name or gender will return nothing
   }
 
   // draws the settings for the graph, including the gray legend
   // rectangles and the meaning of the name, using 'g' Graphics and 
   // 'meaning' String
   public static void drawBackground(Graphics g, String meaning) {
      g.setColor(Color.LIGHT_GRAY);
      g.fillRect(0, 560 - HEIGHT, 780, 560);
      g.fillRect(0, 0, 780, HEIGHT);
      g.setColor(Color.BLACK);
      g.drawString("" + meaning, 0, 16);
      g.drawLine(0, HEIGHT, 780, HEIGHT);
      g.drawLine(0, 560 - HEIGHT, 780, 560 - HEIGHT);
      // labels the years
      for (int i = 0; i <= NUM_DECADES; i++) {
         g.drawString("" + (START_YEAR + (10 * i)), WIDTH * i, 552);
      }
   }
   
   // draws the bars and ranks, using 'g' Graphics and 'rankLine'
   // String, which is the line from the file
   public static void drawGraph(Graphics g, String rankLine) {
      Scanner line = new Scanner(rankLine);
      
      // defines the string value and initializes the integer values
      // in order to draw the bar graph
      String details = line.next() + " " + line.next();
      int x = 0;
      int y = 0;
      int rank = 0;
 
      // for loop that draws the bars based on the data, and labels
      // the bars using the rank of the name of that particular year
      for (int i = 0; i < NUM_DECADES; i++) {
         rank = line.nextInt();
         if (rank > 0) {
            y = rank / 2 + 30;
         } else {
            y = 530;
         }
         g.setColor(Color.GREEN);
         g.fillRect(x + (60 * i), y, WIDTH / 2, 530 - y);
         g.setColor(Color.BLACK);
         g.drawString("" + rank, x + (60 * i), y);
      }
   }
}