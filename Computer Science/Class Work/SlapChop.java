public class SlapChop {

   public static void main(String [] args) {

   for(int i = 1; i <= 100; i++) {
    if (i % 4 == 0 && i % 5 == 0) {
         System.out.println("Slap Chop");
    } else if (i % 4 == 0) {
         System.out.println("Slap");
    } else if (i % 5 == 0) {
         System.out.println("Chop");
    } else {
         System.out.println(i);
    }
  }
}
}