public class A {
   public A() {
      System.out.println("A()");
   }
   public void method1() {
      System.out.println("A.method1()");
      method2();
   }
   public void method2() {
      System.out.println("A.method2()");
   }
}