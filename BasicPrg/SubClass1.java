public abstract class SubClass1 extends BaseClass1
{
    int intSubInt1;
    String strSubStr1 = "SubClass1 String";
    public void display()
    {
        System.out.println("This is sub display");
    }
    abstract void sayHello();
}