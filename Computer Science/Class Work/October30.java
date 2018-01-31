import java.util.*;

public class October30{
   public static void main(String[] args) {
      Scanner kb = new Scanner(System.in);
      
   //    System.out.print("Enter a base: ");
//       double base = kb.nextDouble();
//       System.out.print("Enter a power: ");
//       double exp = kb.nextDouble();
//       
//       System.out.println("The result is " + Math.pow(base, exp));
//       
  
      System.out.print("enter first leg: ");
      int leg1 = kb.nextInt();
      
      System.out.print("Enter the second leg: ");
      int leg2 = kb.nextInt();
      
      double result = hypotenuse(leg1, leg2);
      System.out.println("The hypotenuse is " + result);
      }
    
      
      public static double hypotenuse(int leg1, int leg2) {
         int leg1_2 = leg1 + leg1;
         int leg2_2 = leg2 + leg2;
         return Math.sqrt(leg1_2 + leg2_2);
          
      
      }
      }
      
      
      
      