import java.rmi.*;
public class Reg
{
       public static void main(String argsp[])
       {
              try
              {
              ServerPrg s = new ServerPrg();
              System.out.println("Binding the data");
              Naming.rebind("S",s);
              }
              catch(Exception e)
              {
                System.out.println("Exception occured");
                e.printStackTrace();

              }


       }
}