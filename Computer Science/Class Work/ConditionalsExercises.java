import java.util.*;

public class ConditionalsExercises {
   public static void main(String[] args) { 
   
   
   LetterE();
   Subtraction();
   Max();
   Vowels();
  
  }
  
  public static void LetterE() {
  Scanner in = new Scanner(System.in);
  
  System.out.println("Enter a word");
   String h = in.next();
   int n = h.indexOf("e");
   if (n >= 0) {
   System.out.println("Your word has an 'e' in it.");
   } else {
   System.out.println("Your word does not have an 'e' in it.");
   
//public static boolean testMethod(int num) {   
   //if (num < 0)
   // return true;
   
   //if(num >= 0)
      //return false;
  //}
   }
   }
   
   public static void Subtraction() {
   Scanner it = new Scanner(System.in);
   
      System.out.println("Enter first number");
      int f = it.nextInt();
      System.out.println("Enter second number");
      int s = it.nextInt();
      int result = f - s;
      if (result < 0) {
      result *= -1;
      }
      System.out.println("The answer is " + result);
   }
   
   public static void Max() { 
   Scanner kb = new Scanner(System.in);
   
      System.out.println("Enter first number");
      long first = kb.nextLong();
      System.out.println("Enter second number");
      long second = kb.nextLong();
      System.out.println("Enter third number");
      long third = kb.nextLong();
      
      if (first > second && first > third) { 
         System.out.println(first + " is the greatest value");
      }
      
      if (second > first && second > third) {
         System.out.println(second + " is the greatest value");
      } 
      
      if (third > first && third > second) {
        System.out.println(third + " is the greatest value");
         }
    }


     public static void Vowels() {
      Scanner v = new Scanner(System.in);
      
      System.out.println("Enter a word ");
      String Vowel = v.next();
      
      Vowel = Vowel.replaceAll("[aeiouAEIOU]", ""); 
      System.out.println(Vowel);
    }
   }
   