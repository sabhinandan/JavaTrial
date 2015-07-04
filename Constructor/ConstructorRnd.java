class BaseClass1
{
    BaseClass1()
    {
        System.out.println("This is base class1 constructor");
    }
    void display()
    {
         System.out.println("Inside base class1 display");
    }
}
class SubClass1 extends BaseClass1
{
    SubClass1()
     {
        System.out.println("This is sub class1 constructor");
     }
     void display()
     {
         System.out.println("Inside sub class1 display");
     }
}
public class ConstructorRnd
{
    public static void main(String[] args)
    {
        SubClass1 subClass1 = new SubClass1();
        subClass1.display();
        System.out.println("Inside main class");
    }

}