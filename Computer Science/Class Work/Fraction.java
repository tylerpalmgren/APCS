public class Fraction {
   private int numerator;
   private int denominator;
   
   public Fraction(int numerator, int denominator) {
      this.numerator = numerator;
      this.denominator = denominator;
   }
   
   public Fraction(int whole) {
      this.numerator = whole;
      this.denominator = 1;
   }
   
   public Fraction(int whole, int num, int denom) {
      this.numerator = (whole * denom + num);
      this.denominator = denom;
   }
   
   public Fraction(double real){
      double num = real;
      double denom = 1;
   
      while ((int)num != num) {
         num *= 10;
         denom *= 10;
      }
   
      this.numerator = (int)num;
      this.denominator = (int)denom;
   }
   
   
   public int getNumerator() {
      return numerator; }
   public int getDenominator() {
      return denominator; }

   public void setNumerator(int numerator) {
      this.numerator = numerator;
   }
   
   public void setDenominator(int denominator) {
      this.denominator = denominator;
   }   
   
   public Fraction moltiplyBy(Fraction frac) {
      int newNum = frac.getNumerator() * this.getNumerator();
      int newDenom = frac.getDenominator() * this.getDenominator();
      
      return new Fraction(newNum, newDenom);
   }
   
   public Fraction getReciprocal() {
      return new Fraction(this.getDenominator(), this.getNumerator());
   }
   
   public Fraction divideBy(Fraction that) {
      return this.multiplyBy(that.getReciproal());
   }
      
   public boolean equals(Fraction that) {
      return this.getNumerator() == that.getNumerator() &&
                this.getDenominator() == that.getDenominator();
   }
   
   public String toString() {
      return this.getNumerator() + "/" + this.getdenominator(); 
   }
}