public class Player {
   int life = 10;
   public boolean alive = true;
   public void damage() {
      life--;
   }

   public void checkDeath() {
      if(life > 0){
         System.out.println("Player is still alive");
      } 
      else {
         System.out.println("Player is dead");
         alive = false;
      }
   }
}