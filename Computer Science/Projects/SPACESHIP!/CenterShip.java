import java.awt.Color;
import ihs.apcs.spacebattle.*;
import ihs.apcs.spacebattle.commands.*;

public class CenterShip extends BasicSpaceship{

   private int worldWidth;
   private int worldHeight;
   private int thrustTime = 0;
   private int idleTime = 0;
   private Point middle;
   private double midPoint;
   private double currentSpeed;
   private double score = 0;
   private boolean distCheck = true;
   private boolean hasReachedMidpoint = false;
   
   
   public static void main(String[] args){
     // TextClient.run("10.1.24.234", new CenterShip());
      //TextClient.run("10.40.30.54", new CenterShip());
   TextClient.run("10.1.30.165", new CenterShip());
   }

   public RegistrationData registerShip(int numImages, int worldWidth, int worldHeight){
      this.worldWidth = worldWidth;
      this.worldHeight = worldHeight;
      this.middle = new Point(((double) worldWidth / 2), ((double) worldHeight / 2));
      return new RegistrationData("SPACESHIP!!", Color.YELLOW, 10);
   }
   
   public ShipCommand getNextCommand(BasicEnvironment env){
   
      ObjectStatus ship = env.getShipStatus();
      int orientation = (int)env.getShipStatus().getOrientation();
      
      Point pos = ship.getPosition();
      
      double maxSpeed = ship.getMaxSpeed();
      int midDir = pos.getAngleTo(middle);
      
      currentSpeed = ship.getSpeed();
      
      double temp = score;
      temp = env.getGameInfo().getScore();
       
      System.out.println(middle);
      System.out.println(pos);
       
      if(score != temp){
         distCheck = true;
         hasReachedMidpoint = false;
      }
       
      double distance = pos.getDistanceTo(middle);
      if(distCheck == true){
         midPoint = distance / 2;
         distCheck = false;
      }
      
      if(distance <= 150 && currentSpeed != 0){
         return new BrakeCommand(0.0);
      }
      else if (currentSpeed <= 0.1 && distance <= 1){
         return new IdleCommand(3);
      }
      
      if(orientation != midDir){
         orientation = (int)env.getShipStatus().getOrientation();
         return new RotateCommand(midDir - orientation);
      }
      
      if(midPoint == distance){
         hasReachedMidpoint = true;
      }
         
      if(midPoint < distance && maxSpeed != currentSpeed && hasReachedMidpoint == false){
         thrustTime++;
         return new ThrustCommand('B', 0.05, 1);
      }
      else if (hasReachedMidpoint == true){
         for(int i = 0; i <= idleTime; i++){
            return new IdleCommand(0.05);
         }
      }
         
      for(int j = -5; j <= thrustTime; j++){
         return new ThrustCommand('F', 0.05, 1);
      }
         
      return new IdleCommand(0.000000000000001);
   }
}