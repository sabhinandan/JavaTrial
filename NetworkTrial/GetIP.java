import java.io.*;
import java.net.*;
class GetIP
{
public static void main(String[] args)
    {

try {
     InetAddress address = InetAddress.getByName("192.168.97.83");
      System.out.println(address.toString());
    }
catch(Exception e)
{
    e.printStackTrace();
}

    }
}