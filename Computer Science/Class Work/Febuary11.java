public class Febuary11 {
   public static void main(String[] args) {
      Sedan2 hundai = new Sedan2();
      Motorcycle2 harley = new Motorcycle2(true);
      
      System.out.println("The " + hundai.getType() + " holds " + hundai.getPassengers() + " passengers");
      System.out.println("The " + harley.getType() + " holds " + harley.getPassengers() + " passengers");
      
      hundai.drive(6);
      hundai.drive(13.7);
      hundai.drive(23.2);
      hundai.drive(9);
      
      harley.drive(39.6);
      
      System.out.println("The " + hundai.getType() + " drove " + hundai.milesDriven());
      System.out.println("The " + harley.getType() + " drove " + harley.milesDriven());
      
      hundai.popTrunk();
      harley.wheelie();
   }
}