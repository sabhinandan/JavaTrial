interface BaseInterface
{
    int interfaceVar1 = 0;
    void display();
}
class SubClass12 implements BaseInterface
{
    public void display()
    {
        System.out.println("This is sub class");
    }
}
public class InterfaceRnd
{

    public static void main(String[] args)
    {
        SubClass12 subClass1 = new SubClass12();
        subClass1.display();
    }


}