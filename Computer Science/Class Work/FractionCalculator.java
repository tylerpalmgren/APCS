import java.util.*;

public class FractionCalculator {

   public static void main(String[] args) {
      Scanner kb = new Scanner(System.in);
      Boolean start = true;
      System.out.println("    Welcome to Tyler Palmgren's Fraction Calculator of Whimsicalness!!");
   
      while (start) {  
         System.out.println("-------------------------------------------------------------------------");
         System.out.println("Enter an expression to calculate, or type in \"quit\" at anytime to stop.");
         String user = kb.nextLine();
         if (user.equalsIgnoreCase("quit")) {
            System.out.println("Okay, this has been fun, goodbye!");
            System.exit(0);
         } 
         else {
            System.out.println(user + " = " + produceAnswer(user));
         }
      }
   }
   
   public static String produceAnswer(String user) {
   
      String [] strs = user.split(" ");
      
      String a = strs[0];
      String op = strs[1];
      String b = strs[2];
      
      Convert(a, op, b);  //for final checkpoint (maybe...still working on it)
      
      String Answer = (Convert(a, op, b));
      return Answer;
   }

   public static String Convert(String a, String op, String b) {
      
   
      if (a.contains("_") && b.contains("_")) {
         String [] fractA = a.split("_");  //separating whole number from fraction
          
         String a1 = fractA[0]; //whole number
         String a2 = fractA[1];  //fraction of input
         int wholeA = Integer.parseInt(a1);
          
         String [] fractA2 = a2.split("/");  // splitting fraction
         
         String a2A = fractA2[0];
         String a2B = fractA2[1];
         
         int numA = Integer.parseInt(a2A); //numerator
         int denA = Integer.parseInt(a2B); //denominator
         
         
         String [] fractB = b.split("_"); //separating whole number from fraction
         
         String b1 = fractB[0]; // whole number
         String b2 = fractB[1]; //fraction
         int wholeB = Integer.parseInt(b1);
         
         String [] fractB2 = b2.split("/");  // splitting fraction
         
         String b2A = fractB2[0];
         String b2B = fractB2[1];
         
         int numB = Integer.parseInt(b2A); //numerator
         int denB = Integer.parseInt(b2B); //denominator
          
         if ((wholeA < 0) && (wholeB < 0)) {
            numA *= -1;
            numB *= -1;
            numA += (denA * wholeA); //moving whole into fraction A
            numB += (denB * wholeB);
            return Calculate(op, numA, denA, numB, denB);
         } 
         else if ((wholeA < 0) && (wholeB > 0)) {
            numA *= -1;
            numA += (denA * wholeA); //moving whole into fraction A
            numB += (denB * wholeB);
            return Calculate(op, numA, denA, numB, denB);
         } 
         else if ((wholeA > 0) && (wholeB < 0)){
            numB *= -1;
            numA += (denA * wholeA); //moving whole into fraction A
            numB += (denB * wholeB);
            return Calculate(op, numA, denA, numB, denB);         }
         else {
            numA += (denA * wholeA); //moving whole into fraction A
            numB += (denB * wholeB);
            return Calculate(op, numA, denA, numB, denB);
         }    
      } 
      else if (a.contains("_") && b.contains("/")) {
         String [] fractA = a.split("_");  //separating whole number from fraction
          
         String a1 = fractA[0]; //whole number
         String a2 = fractA[1];  //fraction of input
         int wholeA = Integer.parseInt(a1);
          
         String [] fractA2 = a2.split("/");  // splitting fraction
         
         String a2A = fractA2[0];
         String a2B = fractA2[1];
         
         int numA = Integer.parseInt(a2A); //numerator
         int denA = Integer.parseInt(a2B); //denominator
                  
         numA += (wholeA * denA);
                 
         String [] fractB2 = b.split("/");  // splitting fraction
         
         String b2A = fractB2[0];
         String b2B = fractB2[1];
         
         int numB = Integer.parseInt(b2A); //numerator
         int denB = Integer.parseInt(b2B); //denominator
          
         if (wholeA < 0) {
            numA *= -1;
            numA += (denA * wholeA); //moving whole into fraction A
            return Calculate(op, numA, denA, numB, denB);
         } 
         else { 
            return Calculate( op, numA, denA, numB, denB);
         }
      } 
      else if (a.contains("_") && (!(b.contains("_")) || (b.contains("/")))) {
         String [] fractA = a.split("_");  //separating whole number from fraction
          
         String a1 = fractA[0]; //whole number
         String a2 = fractA[1];  //fraction of input
         int wholeA = Integer.parseInt(a1);
          
         String [] fractA2 = a2.split("/");  // splitting fraction
         
         String a2A = fractA2[0];
         String a2B = fractA2[1];
         
         int numA = Integer.parseInt(a2A); //numerator
         int denA = Integer.parseInt(a2B); //denominator
         
         numA += (denA * wholeA); //moving whole into fraction A
               
         int wholeB = Integer.parseInt(b);
         int numB = 0;
         int denB = 1;
         numB += (denB * wholeB);
         
         return Calculate( op, numA, denA, numB, denB);
      } 
      else if (a.contains("/") && (b.contains("_"))) {
         String [] fractA2 = a.split("/");  // splitting fraction
         
         String a2A = fractA2[0];
         String a2B = fractA2[1];
         
         int numA = Integer.parseInt(a2A); //numerator
         int denA = Integer.parseInt(a2B); //denominator
         
         String [] fractB = b.split("_"); //separating whole number from fraction
         
         String b1 = fractB[0]; // whole number
         String b2 = fractB[1]; //fraction
         int wholeB = Integer.parseInt(b1);
           
         String [] fractB2 = b2.split("/");  // splitting fraction
         
         String b2A = fractB2[0];
         String b2B = fractB2[1];
         
         int numB = Integer.parseInt(b2A); //numerator
         int denB = Integer.parseInt(b2B); //denominator
         
         numB += (denB * wholeB);
      
         
         if (wholeB < 0) {
            numB *= -1; 
            numB += (denB * wholeB);
            return Calculate( op, numA, denA, numB, denB);
         } 
         else {
            return Calculate( op, numA, denA, numB, denB);
         }
      } 
      else if (a.contains("/") && b.contains("/")) {
         String [] fractA2 = a.split("/");  // splitting fraction
         
         String a2A = fractA2[0];
         String a2B = fractA2[1];
         
         int numA = Integer.parseInt(a2A); //numerator
         int denA = Integer.parseInt(a2B); //denominator
      
         String [] fractB2 = b.split("/");  // splitting fraction
         
         String b2A = fractB2[0];
         String b2B = fractB2[1];
         
         int numB = Integer.parseInt(b2A); //numerator
         int denB = Integer.parseInt(b2B); //denominator
      
         
         return Calculate(op, numA, denA, numB, denB);
      } 
      else if (a.contains("/") && (!(b.contains("_")) || (b.contains("/")))) {
         String [] fractA2 = a.split("/");  // splitting fraction
         
         String a2A = fractA2[0];
         String a2B = fractA2[1];
         
         int numA = Integer.parseInt(a2A); //numerator
         int denA = Integer.parseInt(a2B); //denominator
      
         int wholeB = Integer.parseInt(b);
         int numB = 0;
         int denB = 1;
         numB += (denB * wholeB);
         
         return Calculate(op, numA, denA, numB, denB);
      } 
      else if (((!(a.contains("_")) || (a.contains("/")))) && b.contains("_")) {
      
         int wholeA = Integer.parseInt(a);
         int numA = 0;
         int denA = 1;
         numA += (denA * wholeA);
         
         String [] fractB = b.split("_"); //separating whole number from fraction
         
         String b1 = fractB[0]; // whole number
         String b2 = fractB[1]; //fraction
         int wholeB = Integer.parseInt(b1);
         
         String [] fractB2 = b2.split("/");  // splitting fraction
         
         String b2A = fractB2[0];
         String b2B = fractB2[1];
         
         int numB = Integer.parseInt(b2A); //numerator
         int denB = Integer.parseInt(b2B); //denominator
          
         numB += (denB * wholeB); 
          
         return Calculate( op, numA, denA, numB, denB);
      } 
      else if (((!(a.contains("_")) || (a.contains("/")))) && b.contains("/")) {
                  
         int wholeA = Integer.parseInt(a);
         int numA = 0;
         int denA = 1;
         numA += (denA * wholeA);
         
         String [] fractB2 = b.split("/");  // splitting fraction
         
         String b2A = fractB2[0];
         String b2B = fractB2[1];
         
         int numB = Integer.parseInt(b2A); //numerator
         int denB = Integer.parseInt(b2B); //denominator
          
         return Calculate( op, numA, denA, numB, denB);
      } 
      else {
         int wholeA = Integer.parseInt(a);
         int numA = 0;
         int denA = 1;
         numA += (denA * wholeA);
      
         int wholeB = Integer.parseInt(b);
         int numB = 0;
         int denB = 1;
         numB += (denB * wholeB);
         
         return Calculate(op, numA, denA, numB, denB);
      }
   }
   
   public static String Calculate(String op, int numA, int denA, int numB, int denB) {
   
      if (op.equals("*")) {  // *
         int numC = (numA * numB);
         int denC = (denA * denB); 
         int GCD = gcd(numC, denC);
         numC /= GCD;
         denC /= GCD; 
         if (numC == 0) {
            return "0";
         } 
         else if (numC == denC){
            return"1";
         }
         else if (denC == 1){
            return "" + numC;
         }
         else if (Math.abs(numC) > denC) {
            String Answer = Floor(numC, denC);
            return Answer;      
         } 
         else {
            String Answer = (numC + "/" + denC);
            return Answer;      
         }    
      }
      
      else if (op.equals("/")) { // /
         int numC = (numA * denB);
         int denC = (denA * numB);
         int GCD = gcd(numC, denC);
         numC /= GCD;
         denC /= GCD;
         if (numC == 0) {
            return "0";
         } 
         else if (numC == denC) {
            return "1";
         }
         else if (Math.abs(numC) > denC) {
            String Answer = Floor(numC, denC);
            return Answer;      
         } 
         else {
            String Answer = (numC + "/" + denC);
            return Answer;      
         }
      }
      
      else if (op.equals("-")) { // -
         int numC = (numA * denB) - (numB * denA);
         int denC = (denA * denB);
         int GCD = gcd(numC, denC);
         numC /= GCD;
         denC /= GCD;
         if (numC == 0) {
            return "0";
         } 
         else if ((Math.abs(numC)) > (Math.abs(denC))) {
            String Answer = Floor(numC, denC);
            return Answer;   
         } 
         else if (numC > denC) {
            String Answer = Floor(numC, denC);
            return Answer;      
         }          
         else {
            String Answer = (numC + "/" + denC);
            return Answer;      
         }
      } 
      else {   // +
         int numC = (numA * denB) + (numB * denA);
         int denC = (denA * denB);
         int GCD = gcd(numC, denC);
         numC /= GCD;
         denC /= GCD;
         if (numC == 0) {
            return "0";         
         } 
         else if (numC == denC) {
            return "1";
         }
         else if ((Math.abs(numC)) > (Math.abs(denC))) {
            String Answer = Floor(numC, denC);
            return Answer;
         }
         else if (numC > denC) {
            String Answer = Floor(numC, denC);
            return Answer;      
         }          
         else {
            String Answer = (numC + "/" + denC);
            return Answer;
         }
      }
   }
   
   
   public static String Floor(int numC, int denC) { //reparating whole from fraction
      double Whole = Math.floor(numC / denC); 
      int WholeC = (int) Whole;
      int Part = numC % denC;
      if (Part == 0) {
         return "" + WholeC;
      } 
      else if (WholeC < 0) {
         if (denC == 1){
            return "" + numC;
         } 
         else {
         
            Part = Math.abs(Part);
            denC = Math.abs(denC);
            return WholeC + "_" + Part + "/" + denC;
         }
      }
      else {
         String Answer = (WholeC + "_" + Part + "/" + denC);
         return Answer;
      }
   }

   public static int gcd(int numC, int denC) { //reducing fraction
      if (denC == 0) 
         return numC;
      else {
         return gcd(denC, numC % denC);
      }
   }
}