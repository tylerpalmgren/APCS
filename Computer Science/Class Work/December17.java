import java.util.*;

public class December17 {
   public static void main(String[] args) {
      double[] num = {1, 2, 3, 4, 5, 6, 7};  
      
      System.out.println("Before call: " + Arrays.toString(num));  
      doubleEm(num);
      System.out.println("In main: " + Arrays.toString(num));
   }
      
   public static double[] doubleEm(double[] num) {
   double[] num2 = new double[num.length];
      for (int i =0; i < num.length; i++) {
         num[i] *= 2;
      }
      //System.out.println("In method: " + Arrays.toString(num2));
      System.out.println("int method: ");
      printArray(num2);
      return num2;
   }
   
   public static void printArray(double[] arr) {
   System.out.print("[");
   //for (int i = 0;i < arr.length; i++) {
   for (double val : arr) {
   System.out.print(val + ", ");
   }
   System.out.println("]");
}
}