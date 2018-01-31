public class Pickup {

   private static int passengers = 3;
   private static double milesDriven = 0;
   private static double weightLimit = 11000;

   public Pickup(int passengers, double milesDriven){
      this.passengers = passengers;
      this.milesDriven = milesDriven;
   }

   public static String type () {
      return "Vehicle type: Pickup Truck";
   }
   
   public static String passengers(){
      return "It can hold " + passengers + "people safely";
   }
   
   public static double milesDriven(double drive){
      return milesDriven += drive;
   }
   
   public static String weightLimit(){
   return "This vehicle can tow " + weightLimit + " lbs safely.";
   }
}