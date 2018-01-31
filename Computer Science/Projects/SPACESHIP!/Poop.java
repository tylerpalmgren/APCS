import java.awt.Color;
import java.util.*;
import ihs.apcs.spacebattle.*;
import ihs.apcs.spacebattle.commands.*;

public class Poop extends BasicSpaceship{

   private int thrustTime = 0;
   private int idleTime = 0;
   private double score = 0;
   private boolean initialThrust = false;
   private boolean initialRadar = false;
   private boolean newRadar = false;
   private RadarResults radar;
   private boolean emergency = false;
   private boolean allStop = false;
   
   public static void main(String[] args){
      //TextClient.run("10.40.30.54", new SurvivorShip());
      TextClient.run("10.164.129.101", new Poop());
   }

   public RegistrationData registerShip(int numImages, int worldWidth, int worldHeight){
      return new RegistrationData("There be dragons", Color.YELLOW, 10);
   }
   
   public ShipCommand getNextCommand(BasicEnvironment env){    
      ObjectStatus ship = env.getShipStatus();
      Point pos = ship.getPosition();
      emergency = false;
      
      if(allStop == true){
         allStop = false;
         newRadar = false;
         return new RotateCommand(180);
      }
   
     // System.out.println("Speed: " + ship.getSpeed());
      //System.out.println("Score: " + env.getGameInfo().getScore());
      if(newRadar == true) {
         radar = env.getRadar();
      } 
          
      if(env.getGameInfo().getScore() == 0 && initialRadar == true){
         newRadar = true;
         System.out.println("1");
      
         return new RadarCommand(5);
      }
           
      if(newRadar == false){
         newRadar = true;
         System.out.println("2");
         return new RadarCommand(5);
      }
      
      /*if(initialRadar == false){
         initialRadar = true;
         newRadar = true;
         System.out.println("3");
      
         return new RadarCommand(5);
      }*/
      
      if(ship.getPosition().getX() - pos.getX() > 192 || ship.getPosition().getY() - pos.getY() > 192){
         newRadar = true;
         return new RadarCommand(5);
      }
   
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
      
      if(radar == null){
         System.out.println("====");
         return new RadarCommand(5);
      }
      
      if(newRadar == true && radar != null){
         newRadar = false;
         
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
         else {
            newRadar = true;
            return new RadarCommand(5);
         }
      }
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
            //System.out.println("Ship movement: " + ship.getMovementDirection());
            //System.out.println("Angle: " + angle);
            if(angle < frontCone + 90 && angle > frontCone - 90){
               DeathCone.add(DANGER.get(h));
            }
         }
         
         newRadar = false;
         DANGER.clear();
         System.out.println("I'm rotating!");
         
         if(DeathCone.size() != 0){
            ObjectStatus closestObject = DeathCone.get(0);
         
            for(int h = 1; h < DeathCone.size(); h++){
               //int angle = ship.getPosition().getAngleTo(DeathCone.get(h).getPosition());
               //double cone = ship.getMovementDirection();
               if(pos.getDistanceTo(closestObject.getPosition()) > pos.getDistanceTo(DeathCone.get(h).getPosition()) /*&& (angle < cone + 90 && angle > cone - 90)*/){
                  closestObject = DeathCone.get(h);
               }
            }
         
            System.out.println("1: " + closestObject.getType());
         
         
            if(pos.getDistanceTo(closestObject.getPosition()) <= 100 && ship.getSpeed() != 0){
               if((closestObject.getType() != "Dragon" && closestObject.getType() != "BlackHole" && closestObject.getType() != "Star")){
                  System.out.println("stop");
                  return new AllStopCommand();
               }
            }
            
            int objectAngle = pos.getAngleTo(closestObject.getPosition());
            System.out.println(closestObject.getType());
            if(closestObject.getType() == "Planet" || closestObject.getType() == "Star"){
            
            
               if(pos.getAngleTo(closestObject.getPosition()) >= 180){
                  objectAngle -= 180;
               }
            
               if(objectAngle > 90){ //right side
                  int theda = pos.getAngleTo(closestObject.getPosition()) - 90;
                  double dis = Math.cos(theda) * pos.getDistanceTo(closestObject.getPosition());
                  double theda2 = Math.tan(100 / dis);
                  return new SteerCommand(-(theda2));
               } 
               else if (objectAngle < 90){ //left side
                  int theda = 90 - pos.getAngleTo(closestObject.getPosition());
                  double dis = Math.cos(theda) * pos.getDistanceTo(closestObject.getPosition());
                  double theda2 = Math.tan(100 / dis);
                  return new SteerCommand(theda2);
               }
               else { //dead center
                  int theda = 90 - objectAngle;
                  double dis = Math.cos(theda) * pos.getDistanceTo(closestObject.getPosition());
                  double theda2 = Math.tan(100 / dis);
                  return new SteerCommand(theda2);
               }
            } 
            else if(closestObject.getType() == "Torpedo" || closestObject.getType() == "Ship" || closestObject.getType() == "Asteroid"){
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
               emergency = true;
               if(ship.getSpeed() < 99){
                  return new ThrustCommand('B', 1, 1);
               }
            }
         }
      }
      
      return new IdleCommand(.1);
   }
}