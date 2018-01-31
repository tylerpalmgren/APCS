import java.util.*;

public class righttriangle {
   public static void main(String[] args) {
   Scanner in = new Scanner(System.in);
    
   System.out.println("Enter length of side 1: ");
   double s1 = in.nextDouble();
   
   System.out.println("Enter length of side 2: ");
   double s2 = in.nextDouble();
   
   System.out.println("Enter length of side 3: ");
   double h = in.nextDouble();
   
   double result1 = perimeter(s1, s2, h);
   System.out.println("The perimeter is " + result1);
   
   double result2 = area(s1, s2, h);
   System.out.println("The area is " + result2);
   
   double result3 = angleA(s1, s2, h);
   double AngleA = Math.toDegrees(result3);
   
   double result4 = angleB(s1, s2, h);
   double AngleB = Math.toDegrees(result4);
   
   double result5 = angleC(s1, s2, h);
   double AngleC = Math.toDegrees(result5);
   
   System.out.println("Angle A is: " + AngleA);
   System.out.println("Angle B is: " + AngleB);
   System.out.println("Angle C is: " + AngleC);
   }
   
   public static double perimeter(double s1, double s2, double h) {
   
      double a = s1;
      double b = s2;
      double c = h;
      
      return a + b + c;
      
   }
   
   public static double area(double s1, double s2, double h) {
      
     double s = ((s1 + s2 + h) / 2);
      return Math.sqrt(s * (s - s1) *(s - s2) * (s - h));
   }
   
   public static double angleA(double s1, double s2, double h) {
   
   double a = s1;
   double b = s2;
   double c = h;
   
   return Math.acos(((c * c) + (b * b) - (a * a)) / (2 * c * b));
   }
   
   public static double angleB(double s1, double s2, double h) {
   
   double a = s1;
   double b = s2;
   double c = h;
   
   return Math.acos(((c * c) + (a * a) - (b * b)) / (2 * a * c));
   }
   
   public static double angleC(double s1, double s2, double h) {
   
   double a = s1;
   double b = s2;
   double c = h;
   
   return Math.acos(((a* a) + (b * b) - (c * c)) / (2 * a * b));
   
   }
}