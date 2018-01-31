public class practiceWithClasses {

   // private double slope;
//    private double yIntercept;
   private static int count = 0;
   private Point p1;
   private Point p2;
   
   public practiceWithClasses(double slope, double yInter) {
   //       this.slope = slope;
   //       this.yIntercept = yInter;
   count++;
      this.p1 = new Point (0, yInter);
      this.p2 = new Point(-yInter / slope, 0);
   }
   
   public static int getCount() { return count; }
   
   public practiceWithClasses(Point p1, Point p2){
   count++;
      this.p1 = p1;
      this.p2 = p2;
   }
   
   public double getSlope(){
      return (p2.getY() - p1.getY()) / (p2.getX() - p1.getX());
   }
   
   public double getYIntercept(){
      return p1.getY() - getSlope() * p1.getX();
   }
   
   public boolean isOnLine(double x, double y){
      return y == this.getSlope() * x + this.getYIntercept();
   }
   
   public double getYForX(double x){
      double y = x * this.getSlope() + this.getYIntercept();
      return y;
   }
   
   public double getXForY(double y){
      return (y - this.getYIntercept()) / this.getSlope();
   }
}