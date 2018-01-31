public class SemiTrailerTruck {

   private static int passengers = 2;
   private static double milesDriven = 0;
   private static double weightLimit = 105500;

   public SemiTrailerTruck(int passengers, double milesDriven){
      this.passengers = passengers;
      this.milesDriven = milesDriven;
   }

   public static String type () {
      return "Vehicle type: 53ft. Semi-Trailer Truck";
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