public class Sedan {

   private static int passengers = 5;
   private static double milesDriven = 0;

   public Sedan(int passengers, double milesDriven){
      this.passengers = passengers;
      this.milesDriven = milesDriven;
   }

   public static String type () {
      return "Vehicle type: Sedan";
   }
   
   public static String passengers(){
      return "It can hold " + passengers + "people safely";
   }
   
   public static double milesDriven(double drive){
      return milesDriven += drive;
   }
   
}