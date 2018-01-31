import java.util.*;

public class april20{
   public static void main(String[] args){
      double[] arr1 = {-3.4, 0.7, 1.8, 4.5};
      double[] arr2 = {-9.8, -3.7, 0.0, 2.2, 4.5, 6.9, 12.0};
      double[] output = merge(arr1, arr2);
      double [] output2 = mergeSort(output);
      System.out.print("{ ");
      for(int i = 0; i < output.length; i++){
         System.out.print(output2[i] + " ");
      }
      System.out.println("}");
   }
   
   public static double[] merge(double[] arr1, double[] arr2){
      ArrayList<Double> temp = new ArrayList<Double>();
      for(int i = 0; i < arr1.length; i++){
         temp.add(arr1[i]);
      }
      for(int j = 0; j < arr2.length; j++){
         temp.add(arr2[j]);
      }
      for(int k = 0; k < temp.size(); k++){
         for(int t = k + 1; t < temp.size(); t++){
            if(temp.get(t) < temp.get(k)){
               double Temp = temp.get(t);
               temp.set(t, temp.get(k));
               temp.set(k, Temp);
            }
         }
      }
      double[] returnArray = new double[temp.size()];
      for(int q = 0; q < returnArray.length; q++){
         returnArray[q] = temp.get(q);
      }
      return returnArray;
   }
   
   
   public static double[] mergeSort(double[] arr){
      //base case
      if(arr.length <= 1){
         return arr;
      }
   
      //split the array in the half
      double[] part1 = new double[arr.length /2];
      double[] part2 = new double[arr.length - part1.length];
      
      int j = 0, k = 0;
      for(int i = 0; i < arr.length; i++){
         if(i < arr.length / 2){
            part1[j] = arr[i];
            j++;
         } 
         else {
            part2[k] = arr[i];
            k++;
         }
      }
      
      //sort each half
      part1 = mergeSort(part1);
      part2 = mergeSort(part2);
      
      //merge the halves together
      return merge(part1, part2);
   }
}