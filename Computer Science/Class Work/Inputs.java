import java.util.*;

public class Inputs {
   public static void main(String[] args) {
      Scanner kb = new Scanner(System.in);
      System.out.print("Input numbers: ");
      System.out.println(kb.nextLine());
      System.out.println("Accepted");

      System.out.print("Enter an integer: ");
      int num = kb.nextInt();
      System.out.println("You entered " + (num + 2));
      


   }
}