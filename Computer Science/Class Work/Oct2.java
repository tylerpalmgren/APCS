import java.util.*;

public class Oct2 {
   public static void main(String[] args) {
   String name;
   
      //Name
      Scanner in = new Scanner(System.in);
      System.out.println("hello, what's your name? ");
      name = in.nextLine();
      System.out.println("Nice to meet you, " + name + "!"); 
          
      //Worst. Calculator. Ever!    
      System.out.println("");
      System.out.println("Enter first number");
      int num1 = in.nextInt();    
      System.out.println("Enter second number");
      int num2 = in.nextInt();
      System.out.println("It's " + (num1 + num2));

      //F -> C
      System.out.println("");
      System.out.println("Enter the temp. (F) ");
      int temp = in.nextInt();
      System.out.println("It's " + ((temp - 32) / 1.8));

   }
}