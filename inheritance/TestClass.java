
public class TestClass
{
    public static void main(String[] args)
    {
        BaseInterface subClass1 = new SubClass1();
        SubClass1 subClassTest = (SubClass1)subClass1;
        subClass1.getQuery();
        subClassTest.getHi();
    }
}