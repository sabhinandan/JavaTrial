class AbstractClass
{
    public static void main(String args[])
    {
     B b = new B();
     b.m3();
    }
}
abstract class A
{
    abstract void m1();
    void m2()
    {
        System.out.println("A.m2()");
    }
}
class B extends A
{
     void m1()
     {
      System.out.println("Overrided method");
     }
     void m3()
      {
      System.out.println("This is B Class");
      }
}