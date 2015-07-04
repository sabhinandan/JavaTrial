public class DynamicLoading
{
    public static void main(String[] args)  throws Exception
    {
        System.out.println("Inside main class");

    Class c = Class.forName("TestClass");
    TestClass tc;// = new TestClass();
    //tc.show();
    tc = (TestClass)c.newInstance();
    tc.show();
    }

}

class TestClass
{
    public void show()
    {
        System.out.println("this is test class show function");
    }
}
