public class triangularPrism extends Shape {
   private double baseSideA;
   private double baseSideB;
   private double baseSideC;
   private double height;

   // public triangularPrism(double baseSideA, double baseSideB, double baseSideC, double height) {
      // super(baseSideA, baseSideB, baseSideC, height);
   // }
   
   public triangularPrism(double baseSideA, double baseSideB, double baseSideC, double height) {
      this.baseSideA = baseSideA;
      this.baseSideB = baseSideB;
      this.baseSideC = baseSideC;
      this.height = height;
   }
   
   public double volume(double baseSideA, double baseSideB, double baseSideC, double height){
      return ((1 / 4) * height * (Math.sqrt((-1 * Math.pow(baseSideA, 4)) + Math.pow((2 * (baseSideA * baseSideB)), 2) + 2 * (Math.pow((baseSideA * baseSideC), 2) - Math.pow(baseSideB, 4) + 2 * (Math.pow((baseSideB * baseSideC), 2) - Math.pow(baseSideC, 4))))));
   }
   
   public String surfaceArea(){
      return "Easier said than done...";
   }
}