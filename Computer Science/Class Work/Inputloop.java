import java.util.*;

public class Inputloop{
   public static void main(String[] args){
   
    Scanner in = new Scanner(System.in);
    System.out.println("What do you want to say?");
    String t = in.NextLine();
    System.out.println("How many times do you want it said?");
    Scanner num = new Scanner(System.num);
    int y = in.NextNum();
     for (int i = 0; i < y; i++) {
        System.out.println(t);
        /*   System.out.println("How many times do you want me to say \"Hi\"?");  
      Scanner sc = new Scanner(System.in);
      int j = sc.nextInt();
      for (int i = 0; i < j; i++) {
        System.out.println("Hi");
        */
        
      }
   }
}

