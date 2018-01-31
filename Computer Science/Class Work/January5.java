import java.util.*;

public class January5 {
   public static void main(String[] args) {
      ArrayList<Integer> list = new ArrayList<Integer>();
      System.out.println(list + " (" + list.size() + ")");
      
      list.add(5);
      System.out.println(list + " (" + list.size() + ")");
      
      list.add(12);
      list.add(-18);
      System.out.println(list + " (" + list.size() + ")");
      
      list.add(1, 56);  //tells what index to put in what new number
      System.out.println(list + " (" + list.size() + ")");
      
      list.remove(2);
      System.out.println(list + " (" + list.size() + ")");
      
      list.set(0, 99); // change an element
      System.out.println(list + " (" + list.size() + ")");
      
      System.out.println(list.get(2));
      
      for (int num : list) {
         System.out.print(num + " ");
      }
      
      ArrayList<int[]> listOfArr = new ArrayList<int[]>();
      listOfArr.add(new int [5]);
      System.out.println(listOfArr);
   }
}