import java.util.*;

public class Average {
   public static void main (String[] args){
     String name;
      Scanner in = new Scanner(System.in);
      System.out.println("Input first value: ");
      double f = in.nextDouble();
      System.out.println("Input second value: ");
      double s = in.nextDouble();
      System.out.println("Input third value: ");
      double t = in.nextDouble();
      System.out.println("Average: " + (f + s + t) / 3);
   }
}