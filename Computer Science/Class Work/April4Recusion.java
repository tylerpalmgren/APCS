import java.util.Arrays;

public class April4Recusion{
   
   public int sum(int[] arr){
      
      if(arr.length == 0){
         return 0;
      }
      
      return arr[0] + sum(Arrays.copyOfRange(arr, 1, arr.length));
   }

   public int oddSum(int[] arr){
   
      if(arr.length <= 0){
         return 0;
      }
      
      return arr[1] + oddSum(Arrays.copyOfRange(arr, 2, arr.length));
   } 
}