import java.util.*;

public class March17 {
   public static void main(String[] args) {
      int[] nums = {9, 1, 4, 6, 8 ,0 ,3 ,5 ,2 ,7};
      System.out.println(Arrays.toString(nums));
      System.out.println(nums);
      
      
   }
   
   public static void selectionSort(int[] arr) {
      // for each slot
      for(int i = 0; i < arr.length; i++){
         // call element in that slot minimum
         int min = arr[i];
         // for each unsorted element
         for(int j = i + 1; j < arr.length; j++){
            //if less than minimum, make new minimum
            if (arr[j] < min) {
               min = j;
            }
         }
         // swap minimum into slot
         int temp = arr[i];
         arr[i] = arr[min];
         arr[min] = temp;
      }
   }
   
   public static void insertionSort(int [] arr) {
      //for each unsorted element
      for(int i = 0; i < arr.length; i++) {
         //grab it
         int curr = arr[i];
         
         //for each sorted element
         int j = i - 1;
         while(j >= 0 && arr[j] > curr){
            //if it's bigger than the current value
               // slide it over
            arr[j + 1] = arr[i];
            j--;
         }
      
       //drop the unsorted element in place
         arr[j + 1] = curr;
      }
   }
}
