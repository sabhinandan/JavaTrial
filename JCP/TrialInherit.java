//package JCP;
class TrialInherit
{
    public static void main(String args[])
    {
          A a = new A();
          B b = new B();
          System.out.println(a.x);
          a.x=20;
          System.out.println(a.x);
          b.x=200;
          a=b;
          System.out.println(a.x);
    }
}
class A
{
    int x=100;
}

class B extends A
{
    int x=100;
    int y=20;
}