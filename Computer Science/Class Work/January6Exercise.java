public class January6Exercise {
   public static void main(String[] args) {
      January6ExerciseClass point1 = new January6ExerciseClass();
      point1.xCoordinate = 97.25;
      point1.yCoordinate = 18.72;
      
      January6ExerciseClass point2 = new January6ExerciseClass();
      point2.xCoordinate = 35.21;
      point2.yCoordinate = -58.98;
      
      double Slope = slope(point1, point2);
      String Midpoint = midpoint(point1, point2);
      double Distance = distance(point1, point2);
      
      System.out.println("Slope is: " + Slope);
      System.out.println("Midpoint is: " + Midpoint);
      System.out.println("Distance is: " + Distance);
   }
   
   public static double slope(January6ExerciseClass point1, January6ExerciseClass point2) {
      double m = (point2.yCoordinate - point1.yCoordinate) / (point2.xCoordinate - point1.xCoordinate);
      return m;
   
   }
   
   public static String midpoint(January6ExerciseClass point1, January6ExerciseClass point2) {
      January6ExerciseClass Midpoint = new January6ExerciseClass();
      Midpoint.xCoordinate = (point1.xCoordinate + point2.xCoordinate)/2;
      Midpoint.yCoordinate = (point1.yCoordinate + point2.yCoordinate)/2;
      
      return ConvertToPoint(Midpoint);
   
   }
   
   public static double distance(January6ExerciseClass point1, January6ExerciseClass point2){
      double d = Math.sqrt(((point2.xCoordinate - point1.xCoordinate) * (point2.xCoordinate - point1.xCoordinate)) + ((point2.yCoordinate - point1.yCoordinate) * (point2.yCoordinate - point1.yCoordinate)));
      return d;
   }
   
   public static String ConvertToPoint(January6ExerciseClass Midpoint){
      return "(" + Midpoint.xCoordinate + ", " + Midpoint.yCoordinate + ")";
   
   }

   public static double perimeter(Triangle t) {
      double perim = 0;
      perim += distance(t.vertex1, t.vertex2);
      perim += distance(t.vertex2, t.vertex3);
      perim += distance(t.vertex3, t.vertex1);
      return perim;
      }
}