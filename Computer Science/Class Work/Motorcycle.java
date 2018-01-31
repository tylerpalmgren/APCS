public class Motorcycle {

   private static int passengers = 2;
   private static double milesDriven = 0;

   public Motorcycle(int passengers, double milesDriven){
      this.passengers = passengers;
      this.milesDriven = milesDriven;
   }

   public static String type () {
      return "Vehicle type: Motorcycle";
   }
   
   public static String passengers(){
      return "It can hold " + passengers + "people safely";
   }
   
   public static double milesDriven(double drive){
      return milesDriven += drive;
   }
}