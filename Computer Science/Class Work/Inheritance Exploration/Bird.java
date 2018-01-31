public class Bird extends Animal{ 
   protected boolean happy = false;
   //System.out.println("The bird is unhappy");
   public void fly(){
      System.out.println("The bird flies"); 
      happy = true;
      System.out.println("The bird is happy");
   }
   public void swim(){
   System.out.println("The bird swam");
   happy = false;
   System.out.println("The bird is unhappy");
   }
   public void layEgg(){ 
      System.out.println("The bird layed an egg.");     
   }

   public void doStuff(){
      System.out.println("Doing some stuff...");
      fly();
      layEgg();
   }
}