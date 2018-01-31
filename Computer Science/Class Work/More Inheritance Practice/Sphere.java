public class Sphere extends Shape implements Comparable<Sphere>, Scalable {

   private double radius;
   private double height = 4;
   private double power = 3;
   private double power2 = 2;
   
   public Sphere(double radius, double height){
      super(radius, height);
   }
   
   public double volume(double raidus, double height, double power) {
      return super.volumeC(radius, height, power);
   }
   
   public double surfaceArea(double radius, double height, double power2){
      return super.surfaceAreaC(radius, height, power2);
   }
   
   public int compareTo(Sphere s) {
      if(this.volume() < s.volume()) {
         return 1;
      } 
      else if(this.volume > s.volume()){
         return 2;
      } 
      else {
         return 0;
      }
   }
   
   public Scalable scaleBy(int factor) {
      return new Sphere(getRadius() * factor);
   }
}

