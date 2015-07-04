 import java.util.*;
 import java.net.*;
 import java.io.*;


public class SendMail
{
    public static void main(String[] args)
    {
        TestMail testMail = new TestMail();
        testMail.sendMail();
    }
}
class TestMail
{
        StringBuffer communication = new StringBuffer("C:");
   public void sendMail()
   {
        String from =" abhinandan.maheshwari@impetus.co.in";
        String to = "abhinandan.maheshwari@impetus.co.in";
        String message = "This is simple try message";

       try
        {
          Socket s = new Socket("imap.impetus.co.in", 9999);
          System.out.println("Sockeet is "+s.isConnected());
          out = new PrintWriter(s.getOutputStream());
          in = new BufferedReader(new
             InputStreamReader(s.getInputStream()));

          String hostName= InetAddress.getLocalHost().getHostName();

//          receive();
          send("HELO " + hostName);
//          receive();
          send("MAIL FROM: <" + from +">");
//          receive();
          send("RCPT TO: <" + to +">");
//          receive();
          send("DATA");
//          receive();
          StringTokenizer tokenizer = new StringTokenizer(
             message, "\n");
          while (tokenizer.hasMoreTokens())
             send(tokenizer.nextToken());
          send(".");
//          receive();
          s.close();
       }
       catch (IOException exception)
       {
          communication.append("Error: " + exception);
          System.out.println("Error is "+exception.getMessage());
       }
    }

    /**
       Sends a string to the socket and echoes it in the
       communication text area.
       @param s the string to send.
    */
    public void send(String s) throws IOException
    {
       communication.append(s);
       communication.append("\n");
       out.print(s);
       out.print("\r\n");
       out.flush();
    }

    /**
       Receives a string from the socket and displays it
       in the communication text area.
    */
    public void receive() throws IOException
    {
       String line = in.readLine();
       if (line != null)
       {
          communication.append(line);
          communication.append("\n");
       }
    }

    private BufferedReader in;
    private PrintWriter out;
}
