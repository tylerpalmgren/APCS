public class Shape {
   private double height;
   private double length;
   private double width;
   private double radius;
   
   public Shape(double length, double width, double height) {
      this.length = length;
      this.width = width;
      this.height = height;
   }
   
   public Shape(double radius, double height){
      this.radius = radius;
      this.height = height;
   }
   
   // public Shape(double baseSideA, double baseSideB, double baseSideC, double height) {
//       this.baseSideA = baseSideA;
//       this.baseSideB = baseSideB;
//       this.baseSideC = baseSideC;
//       this.height = height;
//    }
   
   public double getHeight(){
      return height;
   }
   
   public double getLength(){
      return length;
   }
   
   public double getWidth(){
      return width;
   }
   
   public double getRadius(){
      return radius;
   }
   
   public double volumeS(double length, double width, double height){ //box-like shapes
   return length * width * height;
   }
   
   public double surfaceAreaS(double length, double width, double height){ // box-like shapes
   return 2 *(width * length + height * length + height * width);
   }
   
   public double volumeC(double height, double raduis, double power) { //
      return (height / 3.0) * (Math.pow(radius, power)) * (Math.PI);
   }
   
   public double surfaceAreaC(double height, double raduis, double power){
      return 4 * Math.PI * (radius * radius);
   }
   

}