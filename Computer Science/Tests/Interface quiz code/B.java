public class B extends A {
public B() {
System.out.println("B()");
}
public void method2() {
System.out.println("B.method2()");
method3();
}
public void method3() {
System.out.println("B.method3()");
super.method2();
}
}