public class rectangularPrism extends Shape{
   private double length;
   private double width;
   private double height;
   
   public rectangularPrism(double length, double width, double height){
   super(length, width, height);
   }
   
   public double volume(){
     return super.volumeS(length, width, height);
   }
   public double surfaceAreaS(){
      return super.surfaceAreaS(length, width, height);
   }
}