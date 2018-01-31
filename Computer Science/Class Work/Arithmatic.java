public class Arithmatic {
   public static void main(String[] args) {
   
      fahrenheittoCelsius(); 
      celsiustoFahrenheit();              
      milestoKilometers();   
      reverse();
   }
   
   public static void fahrenheittoCelsius() {  
      System.out.println((70-32.0) * 5.0 / 9);    //replace 70 with any temp in F
   }
   public static void celsiustoFahrenheit() {
   System.out.println(-30 / 2);  //F=(32+1.8c)   //replace 
   }
   public static void milestoKilometers() {
   System.out.println(1 * 1.60934); //m * 1.60934  replace 1 with any distance in Miles
   }
   public static void reverse() {
   System.out.print(867 % 10);
   System.out.print((867 % 100) / 10);
   System.out.println(867 % 1000 / 100);
   } 
  // public static void inchesToCentimeters() {
   //System.out.println(1 * 2.54); 
   //}
   
}