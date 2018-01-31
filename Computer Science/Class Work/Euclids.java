public class Euclids {
   public static void main(String[] args) {
      int numC = 50;
      int denC = 100;
      int GCD = gcd(numC, denC);
      System.out.println(GCD);
   }
   public static int gcd(int numC, int denC) {
      if (denC == 0) 
         return numC;
      else {
         return gcd(denC, numC % denC);
      }
   }
}