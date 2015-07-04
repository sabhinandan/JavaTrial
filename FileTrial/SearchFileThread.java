import java.io.*;
public class SearchFileThread
{
    public static void main(String[] args) throws Exception
    {
        SearchFile searchFile = new SearchFile("ReadMe.txt");
        searchFile.start();
        InputStreamReader isr = new InputStreamReader( System.in );
        BufferedReader stdin = new BufferedReader( isr );
        System.out.println("Please enter the line to stop");
        stdin.readLine();
        searchFile.stopMe();

    }
}
class SearchFile extends Thread
{
    String strFileName;
    long filePointer = 0;
    RandomAccessFile randomFile;
    boolean flag;
    SearchFile(String fileName)
    {
        this.strFileName = fileName;
        try
        {
            randomFile = new RandomAccessFile(strFileName,"r");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
    public void run()
    {
        flag = true;
        while(flag)
        {
            try
            {
                randomFile.seek(filePointer);

                String line="";

                while((line = randomFile.readLine()) != null)
                {
                    System.out.println(line);

                }
                filePointer = randomFile.getFilePointer();
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
        try
        {
            Thread.sleep(1000);
        }
        catch(Exception e)
        {

        }


    }
    public void stopMe()
    {
        flag=false;
    }

}