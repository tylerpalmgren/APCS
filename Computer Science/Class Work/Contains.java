import java.util.*;

public class Contains {
   public static void main(String[] args) {
      double[] nums = {1.8, -3.7, 5.9, 2.2, 3.1415};                     
      System.out.println(exercise1 (nums, 1.8));                         
      System.out.println(exercise1 (nums, 2.2));                         
      System.out.println(exercise1 (nums, 99.7));                      
                                                                         
   }                                                                //------
                                                                         //|
   public static int exercise1(double [] arr, double value){             //|
      for(int i = 0; i < arr.length - 1; i++){                           //|
         if(arr[i] == value){                                            //|
            return i;                                                    //|
         }                                                               //|
      }                                                                  //|
      return -1;                                                         //|
   }                                                                     //|
                                                                         //|
   public static String exercise2(String[] arr2, char d2) {              //|
      String letter = d2 + "";                                           //|
      for(int c = arr2.length - 1; c > 0; c++) {                         //|
         if(arr2[c].contains(letter)) {                                  //|-----Sequential Searching algorithm
            return arr2[c];                                              //|
         }                                                               //|
      }                                                                  //|
      return null;                                                       //|
   }                                                                     //|
                                                                         //|
   public static boolean exercise3(ArrayList<Object> HSC, String teach){ //|
      Object teacher = teach;                                            //|
      for(int h = 0; h < HSC.size() - 1; h++){                           //|
         if(HSC.get(h).equals(teacher)){                                 //|
            return true;                                                 //|
         }                                                               //|
      }                                                                  //|
      return false;                                                      //|
   }                                                                //------
   
   public static int exerciseBinary(double[] values, double target) {
      int low, high, mid;
      low = 0;
      high = values.length - 1;
    //repeat until found or nothing left
      while(low <= high){
      //find the middle
         mid = (high + low) / 2;
      //if it's what we're looking for, we're done
         if(target == values[mid]) {
            return mid;
         }
         //if not, :
         else if (values[mid] < target){ //if sorted in decending, change "<" to ">"
         //if it's smaller than what we're looking for:
            //throw out the first half
            low = mid + 1;
         //otherwise, throw out second half
         } 
         else {
            high = mid - 1;
         }
      }
      return -1;
   }
}