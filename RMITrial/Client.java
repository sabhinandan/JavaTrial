import java.rmi.*;
public class Client
{
    public static void main(String args[])
    {
     try
     {
     Remote r = Naming.lookup("rmi://192.168.97.83/s");
     I s=(I)r;
     int i = s.add(4,5);
     System.out.println("After calling remote method the result is "+i);
     }
     catch(Exception e)
     {
      e.printStackTrace();
     }
     }

}