public class Cube extends Shape{
   private double length;
   private double width;
   private double height;
   
   public Cube(double length, double width, double height){
      super(length, width, height);
   }
   
   public double volume(double length, double width, double height){
     return super.volumeS(length, width, height);
   }
   
   public double surfaceArea(double length){
   return 6 * (Math.pow(length, 2));
   }
}