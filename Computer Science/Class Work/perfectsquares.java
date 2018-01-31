import java.util.*;

public class perfectsquares {
   public static void main(String[] args) {
   
      Scanner in = new Scanner(System.in);
      System.out.println("Enter a value for n: ");
      int n = in.nextInt();
      printsquares(n);
   
   }
      public static void printsquares(int n) {
       for(int i = 1; i <= n; i++) { 
         System.out.println(i * i);
       }
      }
}