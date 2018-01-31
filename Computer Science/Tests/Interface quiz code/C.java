public class C extends B {
public C() {
System.out.println("C()");
}
public void method1() {
super.method1();
System.out.println("C.method1()");
}
public void method3() {
System.out.println("C.method3()");
}
}