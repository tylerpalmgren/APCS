public class Exploration2 {
   public static void main(String [] args){ 
      Bird big = new Bird();
      Bird flappy = new Penguin();
      
      //((Penguin)big).swim();
   
   
      Penguin pFlappy = (Penguin)flappy;
      ((Penguin)flappy).swim();
      flappy.doStuff();
   }
}