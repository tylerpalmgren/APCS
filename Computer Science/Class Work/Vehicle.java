public class Vehicle {
   private String type;
   private int passengers;
   private double miles;
   
   public Vehicle(String type, int numPassengers){
      this.miles = 0;
      this.type = type;
      this.passengers = numPassengers;
   }
   
   public String gettype() { return this.type; }
   public int getPassengers() { return this.passengers; }
   public double milesDriven() { return this.miles; }
   
   public void drive(double that) {
   miles += that;
   }
}