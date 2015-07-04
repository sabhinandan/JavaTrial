class InterfaceRND
{
    public static void main(String args[])
    {
        System.out.println("Just Hi");
        A a = new A();
        a.m3();
    }
}
interface ifFirst
{
 void m1();
 void m2();
}
interface ifFirst1
{
 void m11();
 void m22();
}

interface ifSecond extends ifFirst,ifFirst1
{
  void m3();
  void m4();
}
class A implements ifSecond
{
  public  void m3(){System.out.println("hi");}
  public void m4(){ }
}