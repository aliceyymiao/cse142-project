// Yingyun(Alice) Miao
// 4/4/17
// CSE142
// TA: Daniel Wang Barnes
// Assignment #1
// 
// This program will produce a cumulative song about an old woman.

public class Song {
   
   public static void main(String[] args) {
      verse1();
      System.out.println();
      verse2();
      System.out.println();
      verse3();
      System.out.println();
      verse4();
      System.out.println();
      verse5();
      System.out.println();
      verse6();
      System.out.println();
      verse7();
   }
   
   // prints out the first verse of the cumulative song
   public static void verse1() {
      System.out.println("There was an old woman who swallowed a fly.");
      repeat6();
   }
   
   // prints out the second verse of the song
   public static void verse2() {
      System.out.println("There was an old woman who swallowed a spider,");
      System.out.println("That wriggled and iggled and jiggled inside her.");
      repeat5();
   }
   
   // prints out the third verse of the song
   public static void verse3() {
      System.out.println("There was an old woman who swallowed a bird,");
      System.out.println("How absurd to swallow a bird.");
      repeat4();
   }
   
   // prints out the fourth verse of the song
   public static void verse4() {
      System.out.println("There was an old woman who swallowed a cat,");
      System.out.println("Imagine that to swallow a cat.");
      repeat3();
   }
   
   // prints out the fifth verse of the song
   public static void verse5() {
      System.out.println("There was an old woman who swallowed a dog,");
      System.out.println("What a hog to swallow a dog.");
      repeat2();
   }
   
   // prints out my custom sixth verse
   public static void verse6() {
      System.out.println("There was an old woman who swallowed a donkey,");
      System.out.println("It's a bit rocky to swallow a donkey.");
      repeat1();
   }
 
   // prints out the last verse of the song
   public static void verse7() {
      System.out.println("There was an old woman who swallowed a horse,");
      System.out.println("She died of course.");
   }
   
   // prints out the part that first appears in the first verse
   // and repeats six times in the song
   public static void repeat6() {
      System.out.println("I don't know why she swallowed that fly,");
      System.out.println("Perhaps she'll die.");
   }
   
   // prints out the part that builds on the previous repetitive part
   // and repeats five times in the song
   public static void repeat5() {
      System.out.println("She swallowed the spider to catch the fly,");
      repeat6();
   }
   
   // prints out the part that repeats four times in the song
   public static void repeat4() {
      System.out.println("She swallowed the bird to catch the spider,");
      repeat5();
   }
   
   // prints out the part that repeats three times in the song
   public static void repeat3() {
      System.out.println("She swallowed the cat to catch the bird,");
      repeat4();
   }
   
   // prints out the part that repeats twice in the song
   public static void repeat2() {
      System.out.println("She swallowed the dog to catch the cat,");
      repeat3();
   }
   
   // prints out the part that only shows up once in the song
   public static void repeat1() {
      System.out.println("She swallowed the donkey to catch the dog,");
      repeat2();
   }
}
