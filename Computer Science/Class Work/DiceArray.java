import java.util.*;

public class DiceArray {

   public static void main(String [] args) {
   
      Scanner kb = new Scanner(System.in);
      int number = kb.nextInt();
   
      int one = 0;
      int two = 0;
      int three = 0;
      int four = 0;
      int five = 0;
      int six = 0;
         
      Dice(number, one, two, three, four, five, six);
      
   }
   
   public static int Dice(int number, int one, int two, int three, int four, int five, int six) {
     
      for (int i = 0; i < number; i++) {
      
         int roll = (int)(Math.random()*6) + 1;
          
         int[] arr = new int[number];
         arr[i] = roll;
          
         if (arr[i] == 1) {
            one++;
         } 
         else if (arr[i] == 2) {
            two++;
         } 
         else if (arr[i] == 3) {
            three++;
         } 
         else if (arr[i] == 4) {
            four++;
         } 
         else if (arr[i] == 5) {
            five++;
         } 
         else {
            six++;
         }
      }
      System.out.println("One appears " + one + " times");
      System.out.println("Two appears " + two + " times");
      System.out.println("Three appears " + three + " times");
      System.out.println("Four appears " + four + " times");
      System.out.println("Five appears " + five + " times");
      System.out.println("Six appears " + six + " times");
   
      int x = 0;
      return x;
   }

}
