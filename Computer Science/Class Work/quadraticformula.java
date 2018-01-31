import java.util.*;

public class quadraticformula {
   public static void main(String[] args) {
     String name;
      Scanner in = new Scanner(System.in);
      System.out.println("Input value for 'a' ");
      int num1 = in.nextInt();
      System.out.println("Input value for 'b' ");
      int num2 = in.nextInt();
      System.out.println("Input value for 'c' ");
      int num3 = in.nextInt();
      System.out.println("Positive Answer: " + ((-1 * num2) + (Math.sqrt((num2 * num2) - (4 * num1 * num3))) / (2 * num1)));
      System.out.println("Negative Answer: " + ((-1 * num2) - (Math.sqrt((num2 * num2) - (4 * num1 * num3))) / (2 * num1)));

   }
}