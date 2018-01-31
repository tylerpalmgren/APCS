public class TestingFraction {
   public static void main(String[] args) {
      
      int a = 9;
      int x = 20;
      
     // print(method1(a));
      System.out.println("Your answer is " + method1(a));
      System.out.println(methodX(a, x));
   }
      //public static void 
      
   public static int method1(int a) {
      int b = a / 3;
      //method2(b);
      return method2(b, a);
   }
      
   public static int method2(int b, int a) {
      int c = b * 10;
     // method3(c);
      return method3(c, a);
   }
      
   public static int method3(int c, int a) {
      int d = (c + 5) * a;
      return d;
   }
      
   public static String methodX(int a, int x) {
      int Whole = Math.floor(numC / denC); 
      int WholeC = (int) Whole;
      int Part = nemC % denC;
      String print = (WholeC + "_" + Part + "/" + denC);
      return print;
   }
}
