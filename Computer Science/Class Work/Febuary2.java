public class Febuary2 {
   public static void main(String[] args){
   
   System.out.println("# of lines: " + practiceWithClasses.getCount());
      practiceWithClasses line = new practiceWithClasses(3, 7);
         System.out.println("# of lines: " + line.getCount());

      System.out.println("This slope is " + line.getSlope());
   
      double x = -6;
      double y = 34;
      System.out.println(line.isOnLine(x, y));
      
      practiceWithClasses otherLine = new practiceWithClasses(2.5, -1);
         System.out.println("# of lines: "+  practiceWithClasses.getCount());

      System.out.println(line.isOnLine(0, 0) && 
                         otherLine.isOnLine(0, 0));
                         
   }
}