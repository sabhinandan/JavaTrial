class PrivateConstructor
{
    public static void main(String args[])
    {
     A.m1();
     A a1 = A.getA();
     System.out.println(a1.x);
     a1.x=20;
     System.out.println(a1.x);
     A b1 = A.getA();
     System.out.println(b1.x);
    }
}
class A
{
 int x;
 static A a = new A();
 private A()
 {
     x=10;
 }
static A getA()
{
    return a;
}
static void m1()
{
    System.out.println("this is static function");
}
}
