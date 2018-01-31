public class January6 {
   public static void main(String[] args) {
      Fraction frac1 = new Fraction();
      frac1.numerator = 1;
      frac1.denominator = 2;
      
      Fraction frac2 = new Fraction();
      frac2.numerator = 2;
      frac2.denominator = 3;
      
      Fraction product = multiply(frac1, frac2);
      System.out.println(fractionString(frac1) + " * " + 
                          fractionString(frac2) + " = " + 
                          product);
   }
  
   public static String fractionString(Fraction i) {
      return f.numerator + "/" + f.denominator;
   }
}