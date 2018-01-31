public class ReversingStrings{
   public static void main(String [] args) {
      System.out.println(palindrome(""));
   }

   public static String reverse(String a){
      if(a == null || a.length() <= 1){
         return a;
      }
      
      return "" + reverse(a.substring(1))+ a.charAt(0);
   }
   
   public static boolean palindrome(String b){
      if(b == null){
         return false;
      }
      else if(b.length() <= 1){
         return true;
      } 
      else if(b.charAt(0) == b.charAt(b.length() - 1)) {
         palindrome(b.substring(1, b.length() - 2));
      } 
      else {
         return false;
      }
      return true;
   }
}