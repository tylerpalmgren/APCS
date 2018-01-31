public class Sedan2 extends Vehicle {
public static final String TYPE = "Sedan";
public static final int NUM_PASS = 5;

   public Sedan() {
      super(TYPE, NUM_PASS);
   }
   
   public void popTrunk(){
      System.out.println(getType() + ": The trunk is open.");
   }
}