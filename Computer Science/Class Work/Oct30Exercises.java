import java.util.*;

public class Oct30Exercises {
   public static void main(String [] args) {
      
      rectangle();
      trueorfalse();
      newstring();
      
      }
      
      public static void rectangle() {  //Code broken, cannot be fixed. DO NOT USE FOR FUTURE ASSIGNMENTS
         Scanner kb = new Scanner(System.in);
         
         System.out.println("Enter a value for length: ");
         int l = kb.nextInt();
         
         
         System.out.println("Enter a value for width: ");
         int w = kb.nextInt();
         
         int result = area(1, w);
         System.out.println("The area is " + result);
         
      }
         
         public static int area(int l, int w) {
         int area = l * w;
         return area;
         }
         
         public static void trueorfalse() {
            Scanner it = new Scanner(System.in);
            
            System.out.println("Enter an integer: ");
            int n = it.nextInt();
            double e = n / 2;
            int o = (n / 2);
            if (e >= o) {
            System.out.println("Your number is even");
            }
            else {
            System.out.println("Your number is odd");
}
}

         public static void newstring() {
         
             Scanner ns = new Scanner(System.in);
             System.out.println("Enter a string: ");
             String phrase = ns.next();
             
             interLeave(phrase);
             }
             
             public static void interLeave(String phrase) {
             int length = phrase.length();
             for(int i = 0; i < length; i+= 2) {
             System.out.print(phrase.charAt(i));
             }
             }



}