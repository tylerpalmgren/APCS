import java.util.*;

public class Shopping {
   public static void main(String[] args) {
     String name;
      Scanner in = new Scanner(System.in);
      double total = 0;
      System.out.println("Input cost of item 1: ");
      double q = in.nextDouble();
      total = q;
      System.out.println("Input cost of item 2: ");
      double w = in.nextDouble();
      total = total + w;
      System.out.println("Input cost of item 3: ");
      double e = in.nextDouble();
      total = total + e;
      System.out.println("Input cost of item 4: ");
      double r = in.nextDouble();
      total = total + r;
      System.out.println("Input cost of item 5: ");
      double t = in.nextDouble(); 
      total = total + t;
      double u = total + ( total * 0.10 );
      double i = u + 7.95;
      
      System.out.println("Your total is $" + i);   
   }

  
   }