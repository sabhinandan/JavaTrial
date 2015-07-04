import java.util.*;
abstract class A
{
    private String str="A";
    public void display()
    {
        System.out.println("This is class A method");
    }
}
class B extends A
{
    public void display()
    {
        System.out.println("This is class B method");
    }
}
class C extends B
{
    public void display()
    {
        System.out.println("This is class C method");
    }
}
class TestRnd
{

    public static void main(String[] args)
    {
        //C c = new C();
        //System.out.println(c);
        Properties sysProp =  System.getProperties();
        Enumeration enum = sysProp.propertyNames();
        while(enum.hasMoreElements())
        {
            String propName = (String)enum.nextElement();
            System.out.println(propName +"   -->"+sysProp.getProperty(propName));

        }
    }
}