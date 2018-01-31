import java.util.*;

public class WhileLoopPractice {
   public static void main(String[] args) {
      
      
      Exercise1();
      Exercise2();
      
   }
      
   public static void Exercise1() {
      Scanner in = new Scanner(System.in);
      
      System.out.println("Enter a number: ");
      double n = in.nextDouble();
            
      in.nextLine();
      System.out.println("Enter an 'a' to add, or a 'p' to subtract: ");
      String command = in.nextLine();
         
      double A = n + 1;
      double P = n - 1;
         
      while (command.equals("a") && n < A) {
         n++;
         System.out.println(n);
      }
         
      while (command.equals("p") && n > P) {
         n--;
         System.out.println(n);
      }
         
   }
     
   public static void Exercise2() {
      Scanner kb = new Scanner(System.in);
      System.out.println("Enter a value for n: ");
       
      double n = kb.nextDouble();
      while (n >= 0) {
         double s = n;
          
         while (n >= 0) {
            System.out.println("Enter a value for n: ");
            n = kb.nextDouble();          
            s += n;
            if (n < 0) {
               s -= n;
            }
         }
         System.out.println(s);
      }
       
   }
}