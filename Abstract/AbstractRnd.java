abstract class BaseClass12
{
    abstract void display();
    private int j=0;
    void show()
    {
        System.out.println("This is show method");
    }
}
class SubClass12 extends BaseClass12
{
    void display()
    {
        System.out.println("This is subclass display method");
    }

}
public class AbstractRnd
{
    public static void main(String[] args)
    {
        SubClass12 subClass = new SubClass12();
        subClass.display();
    }
}