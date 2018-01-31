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
         
            System.out.println(produceAnswer(user));
         }
      }
   }
   
   public static String produceAnswer(String user) {
   
      String [] strs = user.split(" ");
      
      String a = strs[0];
      String op = strs[1];
      String b = strs[2];
      
      //return b;     //for first checkpoint
      
      VariableA(a);
      return VariableB(b);  // for second checkpoint
             
      //Calculate(VariableA(a), op, VariableB(b));  //for final checkpoint (maybe...still working on it)
      //String Answer = Double.toString(Calculate(VariableA(a), op, VariableB(b)));
      //return Answer;
   }
   
   public static double VariableA(String a) {
     
      if (a.contains("_")) {
         String [] fractA = a.split("_");  //separating whole number from fraction
         
         String a1 = fractA[0]; //whole number
         String a2 = fractA[1];  //fraction of input
         double A1 = Double.parseDouble(a1);
         
         String [] fractA2 = a2.split("/");  // splitting fraction
      
         String a2A = fractA2[0];
         String a2B = fractA2[1];
        
         double A2 = Double.parseDouble(a2A); //numerator
         double A3 = Double.parseDouble(a2B); //denominator
        
         A2 += (A3 * A1); 
         double A = A2 / A3;
         return A;
      } 
      else if (a.contains("/")) {
         String [] fractA = a.split("/");
      
         String a1 = fractA[0];
         String a2 = fractA[1];
         
         double A1 = Double.parseDouble(a1); //numerator
         double A2 = Double.parseDouble(a2); //denominator
         
         double A = A1 / A2;
         return A;
      } 
      else {
         double A = Double.parseDouble(a);
         return A;
      }
   }
   
   public static String VariableB(String b) {  //change to String for second checkpoint
   
      if (b.contains("_")) {
         String [] fractB = b.split("_");   //separating whole number from fraction
         
         String b1 = fractB[0]; //whole number (String)
         String b2 = fractB[1];  //fraction of input
         double B1 = Double.parseDouble(b1);
         
         String [] fractB2 = b2.split("/");  // splitting fraction
      
         String b2A = fractB2[0];
         String b2B = fractB2[1];
        
         double B2 = Double.parseDouble(b2A); //numerator
         double B3 = Double.parseDouble(b2B); //denominator
        
        // B2 += (B3 * B1); // use for final
         //double B = B2 / B3;  // use for final
         //return B;  //use for final
         
         return ("whole: " + b1 + " numerator: " + b2A + " denominator: " + b2B);  //second checkpoint
      } 
      else if (b.contains("/")) {
         String [] fractB = b.split("");
      
         String b2 = fractB[0];
         String b3 = fractB[2];
      
         double B2 = Double.parseDouble(b2); //numerator
         double B3 = Double.parseDouble(b3); //denominator
         
       // double B = B2 / B3; // use for final
        //return B; // use for final
        
         return ("whole: none numerator: " + b2 + " denominator: " + b3);  // second checkpoint
      } 
      else {
         double B = Double.parseDouble(b);
         //return B; // use for final checkpont
         return ("whole: " + b + " numerator: none denominator: none"); //second checkpoint
      }
   }
   
   public static double Calculate(double A, String op, double B) {
    
      if (op.contains("/")) {
         double C = A / B;
         return C;
      } 
      else if (op.contains("*")) {
         double C = A * B;
         return C;
      } 
      else if (op.contains("+")) {
         double  C = A + B;
         return C;
      } 
      else {
         double C = A - B;
         return C;
        
        //Convert(C);
      }
   }
   
//    public static void Convert(double C) {
//    
//    if (a.contains("/") || b.contains("/")) {
//       if(A3 == B3) {
//         double C2 = C * B3
//          if (C2 > B3) {
//             if () {
// //    
}