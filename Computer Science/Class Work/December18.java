import java.util.*;

public class December18 {
   public static void main(String[] args) {
      String[][] twoDimArr = { { "a", "b", "c", "d" },
                               { "e", "f", "g", "h" },
                               { "i", "j", "k", "l" } };
                         
      for (int i = 1; i <twoDimArr.length - 1; i++) {     
         for(int j = 0; j < twoDimArr[i].length; j++) {                    
            System.out.print(twoDimArr[i - 1][j] + twoDimArr[i][j] + twoDimArr[i + 1][j] + " ");
            }
            System.out.println();
      }
   }
}