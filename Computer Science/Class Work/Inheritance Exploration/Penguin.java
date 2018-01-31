public class Penguin extends Bird {
   public void fly(){
      System.out.println("The penguin tried to fly");
      happy = false;
      System.out.println("The penguin is unhappy");
   }
   public void swim(){
      System.out.println("The penguin swam");
      happy = true;
      System.out.println("The penguin is happy");
   }
   public void doStuff(){
      super.doStuff();
      swim();
   }
}