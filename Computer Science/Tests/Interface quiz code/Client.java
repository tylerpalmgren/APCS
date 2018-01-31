public class Client {
   public static void main(String[] args) {
      A a = new A(); // Line 1
      B b = new C(); // Line 2
      C c = new B(); // Line 3
      D d = new D(); // Line 4
      b.method2(); // Line 5
      ((A)b).method3(); // Line 6    //why doesn't it compile?    //Can't jump more than one class
      System.out.println();
      d.method3(); // Line 7
      d.method1(); // Line 8
      B b2 = (B)d; // Line 9
      System.out.println();
      A a2 = new B(); // Line 10
      a2.method1(); // Line 11
      C c2 = (C)a2; // Line 12
      System.out.println();
      A[] aArr = { new A(), new B(),
         new C(), new D() }; // Line 13
      ((B)aArr[0]).method3(); // Line 14
      aArr[1].method2(); // Line 15
      aArr[2].method3(); // Line 16   //Why doesn't compile?  //Can't jump more than one class
      aArr[3].method1(); // Line 17
   }
}