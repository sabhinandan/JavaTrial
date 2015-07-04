class StaticClass
{
    public static void main(String args[])
    {
     A a = new A();
     B b = new B();
     a=b;
     a.m2();
    }
}
class A
{
    static int x=10;
    void m1()
    {
        System.out.println("X ix "+x);
    }
    static void m2()
    {
        int a=10;
        System.out.println("This is A.X ix "+x);
    }
}
class B extends A
{
     static void m2()
      {
      System.out.println("This is B.m2()");
      }
}