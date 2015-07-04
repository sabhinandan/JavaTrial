import java.net.*;
public class NetTest
{
    public static void main(String[] args)
    {
        try
        {
            InetAddress ia = InetAddress.getByName(null);
            System.out.println("Address is "+ia);
            ia = InetAddress.getByName("jkhatwani");
            System.out.println("IP address "+ia);
            ia = InetAddress.getLocalHost();
            System.out.println("Local IP address "+ia);
            System.out.println("Local Name "+ia.getHostName());
            System.out.println("Local Name "+ia.getHostAddress());
            InetAddress iaAll[]=ia.getAllByName("jkhatwani");
            System.out.println("All address:");
            for(int i=0;i<iaAll.length;i++)
                 System.out.println("Host address:"+iaAll[i].getHostAddress());
         }
         catch(UnknownHostException e)
         {
         e.printStackTrace();
         }
    }
}