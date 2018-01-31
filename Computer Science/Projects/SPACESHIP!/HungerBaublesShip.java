import java.awt.Color;
import java.util.*;
import ihs.apcs.spacebattle.*;
import ihs.apcs.spacebattle.commands.*;
import ihs.apcs.spacebattle.games.*;

public class HungerBaublesShip implements Spaceship<TheHungerBaublesGameInfo> {

   private int thrustTime = 0;
   private int idleTime = 0;
   private double score = 0;
   private boolean initialThrust = false;
   private boolean initialRadar = false;
   private boolean newRadar = false;
   private RadarResults radar;
   private boolean full = false;
   private boolean allStop = false;
   private int deaths = 0;

   
   public static void main(String[] args){
      TextClient.run("10.40.30.41", new HungerBaublesShip());
      //TextClient.run("10.1.25.54", new HunterBaublesShip());
   }

   public RegistrationData registerShip(int numImages, int worldWidth, int worldHeight){
      return new RegistrationData("Pita Brett", Color.YELLOW, 10);
   }

   public ShipCommand getNextCommand(Environment <TheHungerBaublesGameInfo> env){   
            
      Point PlanetCrash = new Point(0,0);
      Point tem = PlanetCrash;
      ObjectStatus ship = env.getShipStatus();
      Point pos = ship.getPosition();
      
      System.out.println("Score: " + env.getGameInfo().getScore());
      System.out.println("Energy: " + ship.getEnergy());
      
      if(env.getGameInfo().getNumDeaths() > deaths){
         deaths++;
         initialThrust = false;
      }
      
      if(initialThrust == false){
         initialThrust = true;
         return new ThrustCommand('B', 4, 1);
      }
      
      if(allStop == true){
         allStop = false;
         newRadar = false;
         return new RotateCommand(180);
      }
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
      
      if(radar == null){
         return new RadarCommand(5);
      }
      
      List<ObjectStatus> Baubles = new ArrayList<ObjectStatus>();
      List<ObjectStatus> Ships = new ArrayList<ObjectStatus>();
      List<ObjectStatus> Planets = new ArrayList<ObjectStatus>(); 
      List<ObjectStatus> BlackHoles = new ArrayList<ObjectStatus>();
      List<ObjectStatus> WormHoles = new ArrayList<ObjectStatus>();
      List<ObjectStatus> Asteroids = new ArrayList<ObjectStatus>();
      List<ObjectStatus> Nebulas = new ArrayList<ObjectStatus>();
      List<ObjectStatus> Torpedos = new ArrayList<ObjectStatus>();
      List<ObjectStatus> Dragons = new ArrayList<ObjectStatus>();
      List<ObjectStatus> Stars = new ArrayList<ObjectStatus>();
      List<ObjectStatus> Solids = new ArrayList<ObjectStatus>();
      List<ObjectStatus> DANGER = new ArrayList<ObjectStatus>();
      
      ArrayList<ObjectStatus> DeathCone = new ArrayList<ObjectStatus>();
      
      if(newRadar == true && radar != null){
         newRadar = false;
         
         if(radar.getByType("Bauble") != null){
            Baubles.addAll((List<ObjectStatus>)radar.getByType("Bauble"));
         }
         
         if(radar.getByType("Ship") != null){
            Ships.addAll((List<ObjectStatus>)radar.getByType("Ship"));
            DANGER.addAll(Ships);
         }
         if(radar.getByType("Planet") != null){
            Planets.addAll((List<ObjectStatus>)radar.getByType("Planet"));
            DANGER.addAll(Planets);
         }
         if(radar.getByType("BlackHole") != null){
            BlackHoles.addAll((List<ObjectStatus>)radar.getByType("BlackHole"));
            DANGER.addAll(BlackHoles);
         }
         if(radar.getByType("WormHole") != null){
            WormHoles.addAll((List<ObjectStatus>)radar.getByType("WormHole"));
         }
         if(radar.getByType("Asteroid") != null){
            Asteroids.addAll((List<ObjectStatus>)radar.getByType("Asteroid"));
            DANGER.addAll(Asteroids);
         }
         if(radar.getByType("Nebula") != null){
            Nebulas.addAll((List<ObjectStatus>)radar.getByType("Nebula"));
         }
         if(radar.getByType("Torpedo") != null){
            Torpedos.addAll((List<ObjectStatus>)radar.getByType("Torpedo"));
            DANGER.addAll(Torpedos);
         }
         if(radar.getByType("Dragon") != null){
            Dragons.addAll((List<ObjectStatus>)radar.getByType("Dragon"));
            DANGER.addAll(Dragons);
         }
         if(radar.getByType("Star") != null){
            Stars.addAll((List<ObjectStatus>)radar.getByType("Star"));
            DANGER.addAll(Stars);
         } 
      }
      else {
         newRadar = true;
         return new RadarCommand(5);         
      } 
      
      if(Baubles.size() > 0){
         ObjectStatus bauble = Baubles.get(0);
         Point baublePos = Baubles.get(0).getPosition();
         for(int q = 1; q < Baubles.size(); q++){
            if(pos.getDistanceTo(Baubles.get(q).getPosition()) < pos.getDistanceTo(baublePos)){
               baublePos = Baubles.get(q).getPosition();
               bauble = Baubles.get(q);
            }
         }
         if(pos.getDistanceTo(baublePos) <= 48 /* && env.getGameInfo().getBaublesCarriedWeight() + bauble.getWeight() <= 25*/){
            return new CollectCommand(bauble.getId());
         }
      
      }
      
      if(Baubles.size() > 0 && env.getGameInfo().getNumBaublesCarried() < 25 && full == false){ //currently moving at 11 units or more  pos = ship.getPosition();
         ObjectStatus bauble = Baubles.get(0);
         Point baublePos = Baubles.get(0).getPosition();
         double cone = ship.getMovementDirection();
         for(int h = 1; h < Baubles.size(); h++){
            int angle = ship.getPosition().getAngleTo(Baubles.get(h).getPosition());
            if(pos.getDistanceTo(baublePos) > pos.getDistanceTo(Baubles.get(h).getPosition()) && (env.getGameInfo().getBaublesCarriedWeight() - bauble.getMass() > 0) && ((angle < cone + 25 && angle > cone - 25) || (pos.getDistanceTo(baublePos) <= 48))){
               bauble = Baubles.get(h);
               baublePos = Baubles.get(h).getPosition();
            }
         }
         if(ship.getPosition().getDistanceTo(baublePos) <= 48){
            return new CollectCommand(bauble.getId());
         }
      }
      
      System.out.println(Baubles.size());
    //  System.out.println("Angle: " + ship.getPosition().getAngleTo(Solids.get().getPosition()));
      System.out.println("Movement Direction: " + ship.getMovementDirection());
   
      if(Planets.size() > 0){
         pos = ship.getPosition();
         PlanetCrash = Planets.get(0).getPosition();
         for(int k = 1; k < Planets.size(); k++){
            if(pos.getDistanceTo(PlanetCrash) > pos.getDistanceTo(Planets.get(k).getPosition())){
               PlanetCrash = Planets.get(k).getPosition();
            }
         }
      }
      
      System.out.println(DANGER.size());
      if(DANGER.size() > 0){            //currently moving at 11 units or more 
         pos = ship.getPosition();
         double frontCone = ship.getMovementDirection();
         if(frontCone > 180){
            double backCone = frontCone + 180;
         } 
         else{
            double BackCone = frontCone - 180;
         }
         for(int h = 0; h < DANGER.size(); h++){
            int angle = ship.getPosition().getAngleTo(DANGER.get(h).getPosition());
            System.out.println("Ship movement direction: " + ship.getMovementDirection());
            System.out.println("Angle: " + angle);
            if(angle < frontCone + 90 && angle > frontCone - 90){
               DeathCone.add(DANGER.get(h));
            }
         }
         
         
         if(DeathCone.size() != 0){
            ObjectStatus closestObject = DeathCone.get(0);
         
            for(int h = 1; h < DeathCone.size(); h++){
               //int angle = ship.getPosition().getAngleTo(DeathCone.get(h).getPosition());
               //double cone = ship.getMovementDirection();
               if(pos.getDistanceTo(closestObject.getPosition()) > pos.getDistanceTo(DeathCone.get(h).getPosition()) /*&& (angle < cone + 90 && angle > cone - 90)*/){
                  closestObject = DeathCone.get(h);
               }
            }            
         
         
         
         
         
            if(ship.getSpeed() <= 90){
               return new ThrustCommand('B', 4, 1);
            }
            
            if(Baubles.size() > 0 && env.getGameInfo().getNumBaublesCarried() < 25 && full == false){ //currently moving at 11 units or more  pos = ship.getPosition();
               ObjectStatus bauble = Baubles.get(0);
               Point baublePos = Baubles.get(0).getPosition();
               double cone = ship.getMovementDirection();
               for(int h = 1; h < Baubles.size(); h++){
                  int angle = ship.getPosition().getAngleTo(Baubles.get(h).getPosition());
                  if(pos.getDistanceTo(baublePos) > pos.getDistanceTo(Baubles.get(h).getPosition()) && (env.getGameInfo().getBaublesCarriedWeight() - bauble.getMass() > 0) && ((angle < cone + 25 && angle > cone - 25) || (pos.getDistanceTo(baublePos) <= 48))){
                     bauble = Baubles.get(h);
                     baublePos = Baubles.get(h).getPosition();
                  }
               }
               if(ship.getPosition().getDistanceTo(baublePos) <= 48){
                  return new CollectCommand(bauble.getId());
               }
               int angleTo = pos.getAngleTo(baublePos) - (int)cone;
               System.out.println("X: " + baublePos.getX());
               System.out.println("Y: " + baublePos.getY());
               if(pos.getDistanceTo(baublePos) < (pos.getDistanceTo(closestObject.getPosition()) + 10)){
                  return new SteerCommand(angleTo, false);
               }
            } 
            else if(env.getGameInfo().getNumBaublesCarried() == 25){
               full = true;
               pos = ship.getPosition();
               ObjectStatus bauble = Baubles.get(0);
               Point baublePos = Baubles.get(0).getPosition();
               double cone = ship.getMovementDirection();
               for(int h = 1; h < Baubles.size(); h++){
                  int angle = ship.getPosition().getAngleTo(Baubles.get(h).getPosition());
                  if(pos.getDistanceTo(baublePos) > pos.getDistanceTo(Baubles.get(h).getPosition()) && (angle < cone + 25 && angle > cone - 25)){
                     bauble = Baubles.get(h);
                     baublePos = Baubles.get(h).getPosition();
                  }
               }
               if(ship.getPosition().getDistanceTo(baublePos) <= 48){
                  return new CollectCommand(bauble.getId());
               }
               int angleTo = pos.getAngleTo(baublePos) - (int)cone;
               System.out.println("X: " + baublePos.getX());
               System.out.println("Y: " + baublePos.getY());
               return new SteerCommand(angleTo, false);
            
            }
            else {
               initialRadar = true;
               newRadar = true;
               return new RadarCommand(5);
            }
         
         
         
         
         
         
         
         
            newRadar = false;
            DANGER.clear();
            System.out.println("I'm rotating!");
         
         
            
            
            System.out.println("Distance: " + pos.getDistanceTo(closestObject.getPosition()));
            if((closestObject.getType().equals("Planet")) && (!(closestObject.getType().equals("Dragon")) && !(closestObject.getType().equals("BlackHole")) && !(closestObject.getType().equals("Star")) &&  !(closestObject.getType().equals("Nebula")) &&  !(closestObject.getType().equals("WormHole")) && !(closestObject.getType().equals("Asteroids"))) && pos.getDistanceTo(closestObject.getPosition()) <= 75 && ship.getSpeed() != 0){
               //if(closestObject.getType() == "Planet"){
               allStop = true;
               System.out.println("STOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOP");  //Stopping at Black holes when shouldn't
               return new AllStopCommand();
            }
         
            int objectAngle = pos.getAngleTo(closestObject.getPosition());
            System.out.println(closestObject.getType());
            if(closestObject.getType().equals("Planet") || closestObject.getType().equals("Star")){
            
               if(pos.getAngleTo(closestObject.getPosition()) >= 180){
                  objectAngle -= 180;
               }
            
               if(objectAngle > 90){ //right side
                  int theda = pos.getAngleTo(closestObject.getPosition()) - 90;
                  double dis = Math.cos(theda) * pos.getDistanceTo(closestObject.getPosition());
                  double theda2 = Math.tan(100 / dis);
                  return new SteerCommand((int)-(theda2));
               } 
               else if (objectAngle < 90){ //left side
                  int theda = 90 - pos.getAngleTo(closestObject.getPosition());
                  double dis = Math.cos(theda) * pos.getDistanceTo(closestObject.getPosition());
                  double theda2 = Math.tan(100 / dis);
                  return new SteerCommand((int)theda2);
               }
               else { //dead center
                  int theda = 90 - objectAngle;
                  double dis = Math.cos(theda) * pos.getDistanceTo(closestObject.getPosition());
                  double theda2 = Math.tan(100 / dis);
                  return new SteerCommand((int)theda2);
               }
            } 
            else if(closestObject.getType().equals("Torpedo") || closestObject.getType().equals("Ship") || closestObject.getType().equals("Asteroid")){
               if(closestObject.getMovementDirection() - ship.getMovementDirection() > 180 && closestObject.getMovementDirection() - ship.getMovementDirection() < 270){
                  if(pos.getAngleTo(closestObject.getPosition()) == ship.getOrientation()){
                     return new FireTorpedoCommand('F');
                  } 
                  else {
                     return new SteerCommand(30);
                  }
               }
               else if(closestObject.getMovementDirection() <= ship.getMovementDirection()){ // turn right
                  if(pos.getAngleTo(closestObject.getPosition()) == ship.getOrientation()){
                     return new FireTorpedoCommand('F');
                  } 
                  else {                     
                     return new SteerCommand(-30);
                  } 
               }
               else {  //closestObject.getMovementDirection > ship.getMovementDirection() // turn left
                  if(pos.getAngleTo(closestObject.getPosition()) == ship.getOrientation()){
                     return new FireTorpedoCommand('F');
                  } 
                  else {                     
                     return new SteerCommand(30);
                  } 
               }
            } 
            else { // black hole or dragons
               System.out.println("");
            }
         }
      }
   
   
   
   
   
   
   
   
   
      if(ship.getEnergy() < 20 && pos.getDistanceTo(PlanetCrash) > 150 && PlanetCrash == tem){
         return new IdleCommand(3);
      }
      
      /*if(ship.getHealth() < 30){
         return new RepairCommand(20);
      }*/
      
      
      
      
      
      
    /*  
      
      if(ship.getSpeed() <= 99){
         return new ThrustCommand('B', 4, 1);
      }
      else if(Baubles.size() > 0 && env.getGameInfo().getNumBaublesCarried() < 25 && full == false){ //currently moving at 11 units or more  pos = ship.getPosition();
         ObjectStatus bauble = Baubles.get(0);
         Point baublePos = Baubles.get(0).getPosition();
         double cone = ship.getMovementDirection();
         for(int h = 1; h < Baubles.size(); h++){
            int angle = ship.getPosition().getAngleTo(Baubles.get(h).getPosition());
            if(pos.getDistanceTo(baublePos) > pos.getDistanceTo(Baubles.get(h).getPosition()) && (env.getGameInfo().getBaublesCarriedWeight() - bauble.getMass() > 0) && ((angle < cone + 25 && angle > cone - 25) || (pos.getDistanceTo(baublePos) <= 48))){
               bauble = Baubles.get(h);
               baublePos = Baubles.get(h).getPosition();
            }
         }
         if(ship.getPosition().getDistanceTo(baublePos) <= 48){
            return new CollectCommand(bauble.getId());
         }
         int angleTo = pos.getAngleTo(baublePos) - (int)cone;
         System.out.println("X: " + baublePos.getX());
         System.out.println("Y: " + baublePos.getY());
         return new SteerCommand(angleTo, false);
      } 
      else if(env.getGameInfo().getNumBaublesCarried() == 25){
         full = true;
         pos = ship.getPosition();
         ObjectStatus bauble = Baubles.get(0);
         Point baublePos = Baubles.get(0).getPosition();
         double cone = ship.getMovementDirection();
         for(int h = 1; h < Baubles.size(); h++){
            int angle = ship.getPosition().getAngleTo(Baubles.get(h).getPosition());
            if(pos.getDistanceTo(baublePos) > pos.getDistanceTo(Baubles.get(h).getPosition()) && (angle < cone + 25 && angle > cone - 25)){
               bauble = Baubles.get(h);
               baublePos = Baubles.get(h).getPosition();
            }
         }
         if(ship.getPosition().getDistanceTo(baublePos) <= 48){
            return new CollectCommand(bauble.getId());
         }
         int angleTo = pos.getAngleTo(baublePos) - (int)cone;
         System.out.println("X: " + baublePos.getX());
         System.out.println("Y: " + baublePos.getY());
         return new SteerCommand(angleTo, false);
      }
      else {
         initialRadar = true;
         newRadar = true;
         return new RadarCommand(5);
      }
   
   
   
   
   */
      return new IdleCommand(0.1);
   }
   
   public void shipDestroyed(String lastDestroyedBy){
      
   }
}