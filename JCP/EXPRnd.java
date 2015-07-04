import java.io.*;
class EXPRnd
{
    public static void main(String s[])
        {
  //       B b = new B();
  //       b.showAE();
  //       b.showIO();
   Byte b1 = new Byte("127");
   B b = new B();

       System.out.println(b1.toString());
     if(b.toString()==b.toString())
        System.out.println("True");
     else
        System.out.println("False");

        }
}
class B
{
     public String toString()
      {
           return "Hi";
      }
    void showAE() throws ArithmeticException
    {
        System.out.println("Throws ArithmeticException");
    }
    void showIO() throws FileNotFoundException
    {
        System.out.println("Throws IOException");
    }

}