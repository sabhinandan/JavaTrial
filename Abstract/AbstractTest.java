// can there be an abstract class without an abstract method
class BaseAbstract
{
    public void show()
    {
        System.out.println("This is show method of base class");
    }
}
class MiddleAbstract extends BaseAbstract
{

}
public class AbstractTest
{
    public static void main(String[] args)
    {
        MiddleAbstract ma = new MiddleAbstract();
        ma.show();
    }
}