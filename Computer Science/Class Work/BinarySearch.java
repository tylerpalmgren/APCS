import java.util.*;

public class BinarySearch {

   public static void main(String[] args) {
      
   }
   
   public static int exercise1(int[] arr, int target){
      int low, mid, high;
      low = 0;
      high = arr.length - 1;
      while(low <= high){
         mid = (high + low) / 2;
         if(target == arr[mid]){
            return mid;
         }
         else if(arr[mid] > target){
            low = mid + 1;
         }
         else { //  arr[mid] < target  //
            high = mid - 1;
         }
      }
      return -1;
   }
   
   public static String exercise2(List<String> list, String targetString){
      int low2, mid2, high2;
      low2 = 0;
      high2 = list.size() - 1;
      
      while(low2 <= high2){
         mid2 = (high2 + low2) / 2;
         int result = list.get(mid2).compareTo(targetString);
         if(result == 0){
            return list.get(mid2);
         }
         else if (result > 0){ //going to opposite due to lexicographic order
            high2 = mid2 - 1;
         }
         else{
            low2 = mid2 + 1;
         }
      }
      return null;
   }
   
   public static HighSchoolCourse exercise3(HighSchoolCourse[] courseName, String title){
      int low3, mid3, high3;
      low3 = 0;
      high3 = courseName.length - 1;
      while(low3 <= high3){
         mid3 = (low3 + high3) / 2;
         int result = HighSchoolCourse[mid3].compareTo(courseName);
         if(courseName[mid].getCourseName().equals(title)){
            return courseName[mid3];
         }
         else if(courseName[mid3].getCourseName().compareTo(title)) {
            high3 = mid3 - 1;
         }
         else {
            low3 = mid3 + 1;
         }
      }  
      return null;
   }
      
}