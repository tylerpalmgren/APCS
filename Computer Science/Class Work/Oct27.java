public class Oct27 {
   public static void main(String[] args) {
      int size = 5;
      printLine(size);
      size = 10;
      printLine(size);
      /* Can also be:
      printLine(5);
      printLine(10);
      */
  }
   
   public static void printLine(int size) { //and size can be changed to anything, as long as both are changed
       for(int i = 0; i < size; i++) {
         System.out.print("*");
       }
       System.out.println();  
   }
}