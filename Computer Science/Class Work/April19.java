public class April19 {
   public static void main(String[] args){
      int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      int target = 7;
      System.out.println("position " + binarySearch(arr, target));
   }
   
   public static int binarySearch(int[] arr, int target){
      return binarySearchRec(arr, target, 0 ,arr.length);
   }
   
   public static int binarySearchRec(int[] arr, int target, int start, int end){
      int middle = (end + start) / 2;
      if(start >= end){
         return -1;
      } 
      else if(arr[middle] == target){
         return middle;
      } 
      else if(arr[middle] < target){
         start = middle + 1; 
         return binarySearchRec(arr, target, start, end);
      } 
      else {
         end = middle - 1;
         return binarySearchRec(arr, target, start, end);
      }
   }
}