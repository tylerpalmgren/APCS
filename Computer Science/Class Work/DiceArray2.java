import java.util.*;

public class DiceArray2 {
   public static void main(String[] args) {
      Scanner kb = new Scanner(System.in);
      int number = kb.nextInt();
      
      int two = 0;
      int three = 0;
      int four = 0;
      int five = 0;
      int six = 0;
      int seven = 0;
      int eight = 0;
      int nine = 0;
      int ten = 0;
      int eleven = 0;
      int twelve = 0;
      
      Dice2(number, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve);
      
      }
      
      public static int Dice2 (int number, int two, int three, int four, int five, int six, int seven, int eight, int nine, int ten, int eleven, int twelve) {
      for(int i = 0; i < number; i++) {
      
      int roll = (int)(Math.random()*6) + 1;
      int roll2 = (int)(Math.random()*6) + 1;
      
      int[] arr = new int[number];
         arr[i] = roll + roll2;
         
         if (arr[i] == 2) {
            two++;
         } else if (arr[i] == 3) {
            three++;
         } else if (arr[i] == 4) {
            four++;
         } else if (arr[i] == 5) {
            five++;
         } else if (arr[i] == 6){
            six++;
         } else if (arr[i] == 7) {
            seven++;
         } else if (arr[i] == 8) {
            eight++;
         } else if (arr[i] == 9) {
            nine++;
         } else if (arr[i] == 10) {
            ten++;
         } else if (arr[i] == 11) {
            eleven++;
         } else {
            twelve++;
         }
       }
        System.out.println("Two appears " + two + " times");
        System.out.println("Three appears " + three + " times");
        System.out.println("Four appears " + four + " times");
        System.out.println("Five appears " + five + " times");
        System.out.println("Six appears " + six + " times");
        System.out.println("Seven appears " + seven + " times");
        System.out.println("Eight appears " + eight + " times");
        System.out.println("Nine appears " + nine + " times");
        System.out.println("Ten appears " + ten + " times");
        System.out.println("Eleven appears " + eleven + " times");
        System.out.println("Twelve appears " + twelve + " times");

         int x = 0;
         return x;
      }  
   }