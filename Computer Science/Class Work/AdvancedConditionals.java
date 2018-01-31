import java.util.*;

public class AdvancedConditionals {
   public static void main(String[] args) { 
   
   Factors(465);
   Letter(101);
  // Vowels2(Racecar);
   System.out.println(StringLength("ASDF", 8));
   
   }
   public static void Factors(int num) {
   
   for (int h = num; h > 0; h--) {
      if(num % h == 0) {
      System.out.println(h);
   }   
  }
  System.out.println();
}
   
   public static void Letter(double grade) {
   System.out.print("Your grade is a");
   if(grade < 60) {
      System.out.println("n F");
   } else if(grade >= 60 && grade < 63) {
      System.out.println(" D-");
   }else if(grade >= 63 && grade < 67) {
      System.out.println(" D");
   }else if(grade >= 67 && grade < 70) {
      System.out.println(" D+");
   }else if(grade >= 70 && grade < 73) {
      System.out.println(" C-");
   }else if(grade >= 73 && grade < 77) {
      System.out.println(" C");
   }else if(grade >= 77 && grade < 80) {
      System.out.println(" C+");
   } else if(grade >= 80 && grade < 83) {
      System.out.println(" B-");
   } else if(grade >= 83 && grade < 87) {
      System.out.println(" B");
   } else if(grade >= 87 && grade < 90) {
      System.out.println(" B+");
   } else if(grade >= 90 && grade < 95) {
      System.out.println("n A-");
   } else if(grade >= 95 && grade <= 100) {
      System.out.println("n A!");
   }else {
      System.out.println("n A+. Show off.");
      }
      System.out.println();
   }
   
 //   public static String Letter(double grade) {
//    System.out.print("Your grade is a");
//    if(grade < 60) {
//       System.out.println("n F");
//    } else if(grade >= 60 && grade < 63) {
//       return " D-";
//    }else if(grade >= 63 && grade < 67) {
//       return " D";
//    }else if(grade >= 67 && grade < 70) {
//       return " D+";
//    }else if(grade >= 70 && grade < 73) {
//       return " C-";
//    }else if(grade >= 73 && grade < 77) {
//       return " C";
//    }else if(grade >= 77 && grade < 80) {
//       return " C+";
//    } else if(grade >= 80 && grade < 83) {
//       return " B-";
//    } else if(grade >= 83 && grade < 87) {
//       return " B";
//    } else if(grade >= 87 && grade < 90) {
//       return" B+";
//    } else if(grade >= 90 && grade < 95) {
//       return"n A-";
//    } else if(grade >= 95 && grade <= 100) {
//       return "n A!";
//    }else {
//       return "n A+. Show off.";
//       }
//       System.out.println();
//    }
 
  
// // //    public static void Vowels2(String string) {  //Does not work
// // //       if (string.indexOf('A') != -1 || sting.indexOf('a') {
// // //          System.out.println("Has A")
// // //          } else {
// // //             System.out.println("Does not have A");
// // //       }
// // //       if (string.indexOf('E') != -1 || sting.indexOf('e')
// // //          System.out.println("Has E")
// // //          } else {
// // //             System.out.println("Does not have E");
// // //       }
// // //       if (string.indexOf('i') != -1 || sting.indexOf('I')
// // //          System.out.println("Has I")
// // //          } else {
// // //             System.out.println("Does not have I");
// // //       }if (string.indexOf('O') != -1 || sting.indexOf('o')
// // //          System.out.println("Has O")
// // //          } else {
// // //             System.out.println("Does not have O");
// // //       }
// // //       if (string.indexOf('U') != -1 || sting.indexOf('u')
// // //          System.out.println("Has U")
// // //          } else {
// // //             System.out.println("Does not have U");
// // //       }
// // //       }





   public static String StringLength(String word, int integer) {
   
   int length = word.length();
   if (length < integer) {
      return "The String length is less than the integer";
    } else if (length == integer) {
      return "The String length is equal to the integer";
    } else {
      return "The String length is greater than the integer";
    }
    
  }
}
   
   
   