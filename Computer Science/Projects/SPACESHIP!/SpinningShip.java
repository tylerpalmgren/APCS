import java.awt.Color;
import ihs.apcs.spacebattle.*;
import ihs.apcs.spacebattle.commands.*;

public class SpinningShip extends BasicSpaceship {
   public static void main(String[] args){
      TextClient.run("10.40.30.41", new SpinningShip());
   }

   public RegistrationData registerShip(int numImages, int worldWidth, int worldHeight){
   
      return new RegistrationData("SPACESHIP!!", Color.YELLOW, 10);
   }
   public ShipCommand getNextCommand(BasicEnvironment env){
      return new RotateCommand(30);
   }
}