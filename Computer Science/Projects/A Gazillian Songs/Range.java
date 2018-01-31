import java.io.*;

public class Range{
   
   private int max;
   private int min;
   
   public Range(int min, int max){
      this.min = min;
      this.max = max;
   }
   //Parse a string of the form "-" or "" and create a Range representing those values
   public static Range parse(String s){
      String[] delim = s.split("-");
      int min = Integer.parseInt(delim[0]);
      int maxPoint = delim.length - 1;
      int max = Integer.parseInt(delim[maxPoint]);
      
      Range range = new Range(min, max);
      return range;
   }
   
   //Returns true if the given value is in this range, and false otherwise
   public boolean contains(int n){  
      if(n >= getMin() && n <= getMax()){  //check if n is in between the max and min values
         return true;
      }
      else {
         return false;
      }
   }
   
   //Return the minimum value in this range
   public int getMin(){
      return min;
   }
   
   //Return the maximum value in this range
   public int getMax(){
      return max;
   }
}