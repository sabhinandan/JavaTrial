//package JCP;
class ThisRND
{
    public static void main(String args[])
    {
//        A a = new A();
        B b = new B();
        System.out.println(b.x);
        System.out.println(b.y);
        System.out.println("Hi");
    }
}

class A
{
    int x;
    A()
    {
        x=10;
    }
}
class B extends A
{
    int y=20;
    int z;
    B()
    {
    super();
     y=20;
    }
    B(int y1)
    {
      y=y1;
      z=11;
    }
}