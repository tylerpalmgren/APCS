public class Problem {
   public static void main(String[] args) {
   
      scientific (1.9, -2.0);
   
   }
   
   public static double scientific (double base, double exp) {
   
      double x = 1;
      if (exp > 0) {
         for(int i = 0; i < exp; i ++) {
            x *= 10;
         }
         double A = base * x;
      }
      if (exp < 0) {
         for(int i = 0; i > exp; i--) {
            x /= 10;
         }
      }
      if (exp == 0) {
         System.out.print(base);
      }
      double A = base * x;
      
      System.out.println(A);
      return A;
   }
}