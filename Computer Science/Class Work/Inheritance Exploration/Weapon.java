public class Weapon {

   Weapon lance = new Weapon();
   int strength  = 1 + (int)(Math.random() * 5); 

   public void hitPlayer(Player player) {
         player.life = player.life - strength;
   }
}