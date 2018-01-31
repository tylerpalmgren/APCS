//double Version (AKA 'More accurate' Version)

import java.util.*;

public class Oct9 {
public static void main(String[] args) {
   String name; 
   Scanner in = new Scanner(System.in);
      System.out.println("Input first numerator: ");
      double n1 = in.nextDouble();
      System.out.println("Input first denominator: ");
      double d1 = in.nextDouble();
      System.out.println("Input second numerator: ");
      double n2 = in.nextDouble();
      System.out.println("Input second denominator: ");
      double d2 = in.nextDouble();
      //Product
      System.out.println("Product: \n" + (n1 * n2));
      System.out.println((d1 * d2));
      //Quotient
      System.out.println("Quotient: \n" + (n1 * d2));  
      System.out.println((d1 * n2));
      //Sum
      System.out.println("Sum: \n" + (((n1 * (d2 / d1)) + n2)));
      System.out.println((d1 * (d2 / d1)));
      //Difference
      System.out.println("Difference: \n" + (((n1 * (d2 / d1)) - n2)));
      System.out.println((d1 * (d2 / d1)));
   }
}

//int Version (AKA 'OK' Version)
/*
import java.util.*;

public class Oct9 {
public static void main(String[] args) {
   String name; 
   Scanner in = new Scanner(System.in);
      System.out.println("Input first numerator: ");
      int n1 = in.nextInt();
      System.out.println("Input first denominator: ");
      int d1 = in.nextInt();
      System.out.println("Input second numerator: ");
      int n2 = in.nextInt();
      System.out.println("Input second denominator: ");
      int d2 = in.nexInt();
      //Product
      System.out.println("Product: \n" + (n1 * n2));
      System.out.println((d1 * d2));
      //Quotient
      System.out.println("Quotient: \n" + (n1 * d2));  
      System.out.println((d1 * n2));
      //Sum
      System.out.println("Sum: \n" + (((n1 * (d2 / d1)) + n2)));
      System.out.println((d1 * (d2 / d1)));
      //Difference
      System.out.println("Difference: \n" + (((n1 * (d2 / d1)) - n2)));
      System.out.println((d1 * (d2 / d1)));
   }
}

*/