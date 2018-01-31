import java.awt.Color;
import java.util.*;
import ihs.apcs.spacebattle.*;
import ihs.apcs.spacebattle.commands.*;

public class BaubleShip extends BasicSpaceship{

   private int thrustTime = 0;
   private int idleTime = 0;
   private double score = 0;
   private boolean initialThrust = false;
   private boolean initialRadar = false;
   private boolean newRadar = false;
   private RadarResults radar;
   
   public static void main(String[] args){
      TextClient.run("10.40.30.41", new BaubleShip());
      //TextClient.run("10.1.30.165", new BaubleShip());
   }

   public RegistrationData registerShip(int numImages, int worldWidth, int worldHeight){
      return new RegistrationData("Mr.Wortzman don't go!", Color.YELLOW, 10);
   }

   public ShipCommand getNextCommand(BasicEnvironment env){    
      ObjectStatus ship = env.getShipStatus();
      System.out.println("Score: " + env.getGameInfo().getScore());
      if(newRadar == true) {
         radar = env.getRadar();
      }      
         
      if(initialRadar == false){
         initialRadar = true;
         newRadar = true;
         return new RadarCommand(5);
      }
      
      score = env.getGameInfo().getScore();
      double temp = score;
      if(env.getGameInfo().getScore() != temp){
         newRadar = true;
         return new RadarCommand(5);
      }
      
      List<ObjectStatus> Baubles = new ArrayList<ObjectStatus>();
      List<ObjectStatus> Solids = new ArrayList<ObjectStatus>();
      
      if(newRadar == true){
         newRadar = false;
         Baubles.addAll((List<ObjectStatus>)radar.getByType("Bauble"));
         Solids.addAll((List<ObjectStatus>)radar.getByType("Planet"));
         Solids.addAll((List<ObjectStatus>)radar.getByType("Ship"));
      
      } 
      System.out.println(Baubles.size());
    //  System.out.println("Angle: " + ship.getPosition().getAngleTo(Solids.get().getPosition()));
      System.out.println("Movement Direction: " + ship.getMovementDirection());
      if(ship.getEnergy() < 20) {
         return new IdleCommand(4);
      }
               
      if(ship.getSpeed() <= 99){
         return new ThrustCommand('B', 0.15, 1);
      }
      else if(Baubles.size() > 0){ //currently moving at 11 units or more 
         Point pos = ship.getPosition();
         Point bauble = Baubles.get(0).getPosition();
         double cone = ship.getMovementDirection();
         for(int h = 1; h < Baubles.size(); h++){
            int angle = ship.getPosition().getAngleTo(Baubles.get(h).getPosition());
            if(pos.getDistanceTo(bauble) > pos.getDistanceTo(Baubles.get(h).getPosition()) && (angle < cone + 25 && angle > cone - 25)){
               bauble = Baubles.get(h).getPosition();
            }
         }
         int angleTo = pos.getAngleTo(bauble) - (int)cone;
         System.out.println("X: " + bauble.getX());
         System.out.println("Y: " + bauble.getY());
         return new SteerCommand(angleTo, false);
      }
      else {
         initialRadar = true;
         newRadar = true;
         return new RadarCommand(5);
      }
   }
}