public class StarRectangle {
   public static void main(String[] args) {
   
      int stars = 5; //Change for how many stars printed
      int rows = 3; //Change for how many rows of stars wanted
      printStars(stars, rows);
      }
      public static void printStars(int stars, int rows){
        for(int r = 0; r < rows; r++) {
          for(int s = 0; s < stars; s++) {
            System.out.print("*");// Change "*" to "* " to print a square
            }
            System.out.println();
          }
      }
}