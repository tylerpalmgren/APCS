import java.util.*;

public class Arrays {
   public static void main(String [] args) {
   
   Exercise1();
   }
   
   public static void Exercise1(){
   Scanner kb = new Scanner(System.in);
   
   System.out.println("Input number of days: ");
   int days = kb.nextInt();
   
   int aboveAvg = 0;
   double[] sales = new double[days];
   double total = 0;
   
      for(int i = 1; i <= days; i++) {
        System.out.println("What was day " + i + " sales?");
        double today = kb.nextDouble();
       // a = kb.nextDouble();
        total += today;
        sales[i] = today;
      }
   double average = total / days;
   System.out.println("Total sales: " + total);
   System.out.println("Average sales = " + average);
   
   for (int day = 0; day < sales.length; day++) {
      if (sales[day] > average) {
         aboveAvg++;
         }
   }
   System.out.println("There were " + aboveAvg + " days above");
   }
}