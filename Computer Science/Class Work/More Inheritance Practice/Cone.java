public class Cone extends Shape {
private double radius;
private double heigth;
   public Cone(double radius, double height){
      super(radius, height);
   }
   public double volume(double radius, double height){
      return (Math.PI) * (Math.pow(radius, 2)) * (height / 3);
   }
   
   public double surfaceArea(double raduis, double height){
   return ((Math.PI) * radius) * (radius + Math.sqrt((Math.pow(height, 2)) + (Math.pow(radius, 2))));
   }
}