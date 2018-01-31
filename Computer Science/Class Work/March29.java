public class March29 {
   public static void main(String[] args){
   
      int x = factorial(3);
      int y = factorial(6);
      int z = factorial(0);
      System.out.println(x + " " + y + " " + z);
      
      x = fact2(3);
      y = fact2(6);
      z = fact2(0);
      System.out.println(x + " " + y + " " + z);
   }

   public static int factorial(int n){
      int result = n;
      if(n == 0){
         return 1;
      }
      for(int i = n - 1; i >= 1; i--){
         result *= i;
      }
      return result;
   }
   
   
   public static int fact2(int n){    //recursion  
      if (n == 0) {
         return 1;
      }
      return n * fact2(n - 1);
   }
}