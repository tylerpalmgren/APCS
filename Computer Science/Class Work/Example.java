public class Example {
   public static void main(String[] args) {
   
   scientific (6.23, 5.0);
   
   }
   
   public static double scientific (double base, double sci) {
      int k = 0;
      double x = 0;
      
      if (sci > 0) {
      for (int i = 0; i <= sci; k++) {
         x = (base *= 10);
         return x;
      }
      }
      
      if (sci < 0) {
      for (int i = 0; i >= sci; k++) {
      x = (base /= 10);
      return x;
      }
      }
      
      if (sci == 0) {
         x += base;
       }
       System.out.print(x);
       return x;
       }
       }