import java.io.*;
class SystemCommandFile
{

    public static void main(String args[])
    {

          try
        {

             String commandString = "perl D:/JavaTrial/temp/splitMechSpecFile-ch.pl D:/JavaTrial/temp/batch D:/JavaTrial/temp/batch/inbox 2485745BAN.txt";
            //Execute the given command
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(commandString);
//            Process p = Runtime.getRuntime().exec( commandString );

            //Wait until the process is successful
           // p.waitFor();

            //Check the status of the the process
//            int exitCode = p.exitValue();

            InputStream stdin = p.getInputStream();
            InputStreamReader isr = new InputStreamReader(stdin);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            System.out.println("<OUTPUT>");
            while ( (line = br.readLine()) != null)
                System.out.println(line);
            System.out.println("</OUTPUT>");
            int exitCode = p.waitFor();
            System.out.println("Process exitValue: " + exitCode);


       //     int exitCode = p.waitFor();

            //Complain on a failed process call
            if ( exitCode != 0 )
            {
               System.out.println("Exit code is not 0");
            }
            else
            {
                System.out.println("Exit code is 0");

            }
        }
        catch(Exception e)
        {
         e.printStackTrace();
        }

     }
}