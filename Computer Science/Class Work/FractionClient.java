public class FractionClient {
   public static void main(String[] args) {
      Fraction frac1 = new Fraction(1, 2);
      Fraction frac2 = new Fraction(2, 3);
      
      Fraction frac2 = new Fraction();
      frac2.setNumerator(2);
      frac2.setDenominator(3);
      
      Fraction product = multiply (frac1, frac2);
   }
   
   public static Fraction multiply(Fraction f1, Fraction f2) {
      int newNum = f1.getNumerator * f2.getNumerator;
      int newDenon = f1.getDenominator() * f2.getDenominator();
      
      return new Fraction(newNum, newDenom);
   }
}