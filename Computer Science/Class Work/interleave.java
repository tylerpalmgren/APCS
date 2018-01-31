import java.util.*;

public class interleave {
   public static void main(String[] args) {
      
      Scanner kb = new Scanner(System.in);
      System.out.println("Enter a word/letters: ");
      String first = kb.next();
      
      Scanner in = new Scanner(System.in);
      System.out.println("Enter another word/letters ");
      String second = in.next();
      
      interLeave(first, second);
   
   }
   
   public static void interLeave(String first, String second) {
   int length = first.length();
      for(int i = 0; i < length; i ++) {
//          System.out.print(first.substring(i, i + 1));
//          System.out.print(second.substring(i, i + 1));
         System.out.print(first.charAt(i));
         System.out.print(second.charAt(i));

      }
       System.out.println();
   }
}