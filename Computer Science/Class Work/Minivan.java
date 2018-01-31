public class Minivan {

   private static int passengers = 7;
   private static double milesDriven = 0;

   public Minivan(int passengers, double milesDriven){
      this.passengers = passengers;
      this.milesDriven = milesDriven;
   }

   public static String type () {
      return "Vehicle type: Minivan";
   }
   
   public static String passengers(){
      return "It can hold " + passengers + "people safely";
   }
   
   public static double milesDriven(double drive){
      return milesDriven += drive;
   }
}