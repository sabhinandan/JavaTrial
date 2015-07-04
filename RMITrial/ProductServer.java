import java.rmi.*;
import java.rmi.server.*;

 /**
    This server program instantiates two remote objects,
    registers them with the naming service, and waits for
    clients to invoke methods on the remote objects.
 */
 public class ProductServer
 {
    public static void main(String args[])
    {
       try
       {
          System.out.println
             ("Constructing server implementations...");

          ProductImpl p1
             = new ProductImpl("Blackwell Toaster");
          ProductImpl p2
             = new ProductImpl("ZapXpress Microwave Oven");

          System.out.println
             ("Binding server implementations to registry...");

          Naming.rebind("toaster", p1);
          Naming.rebind("microwave", p2);

          System.out.println
             ("Waiting for invocations from clients...");
       }
       catch(Exception e)
       {
          e.printStackTrace();
       }
    }
 }
