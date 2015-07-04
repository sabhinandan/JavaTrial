import java.io.*;
public class ChangeSlash
{
    public static void main(String[] args)
    {
        ChangeFile.ChangeSlash("first.txt");

    }
}
class ChangeFile
{
    public static void ChangeSlash(String strFile)
    {
        StringBuffer contents = new StringBuffer();
        BufferedReader input = null;
        String outString = "";
        try
        {
          input = new BufferedReader( new FileReader(strFile) );
          String line = null; //not declared within while loop
          while (( line = input.readLine()) != null)
          {
            contents.append(line);
            contents.append(System.getProperty("line.separator"));
          }
            String str = contents.toString();
            char[] charFile = new char[str.length()];
            charFile = str.toCharArray();
            for(int i=0;i<charFile.length;i++)
            {
                if(charFile[i] == '\\')
                {
                    charFile[i]='/';
                }
            }
            outString = new String(charFile);
            System.out.println(outString);
         setContents(new File(strFile),outString);
        }
		catch(Exception e)
		{
		  System.out.println("Error is "+ e);
		}

    }

    static public void setContents(File aFile, String aContents)
                                 throws FileNotFoundException, IOException {
    if (aFile == null) {
      throw new IllegalArgumentException("File should not be null.");
    }
    if (!aFile.exists()) {
      throw new FileNotFoundException ("File does not exist: " + aFile);
    }
    if (!aFile.isFile()) {
      throw new IllegalArgumentException("Should not be a directory: " + aFile);
    }
    if (!aFile.canWrite()) {
      throw new IllegalArgumentException("File cannot be written: " + aFile);
    }
    Writer output = null;
    try
    {
      output = new BufferedWriter( new FileWriter(aFile) );
      output.write( aContents );
    }
    finally
    {

      if (output != null) output.close();
    }
                                 }
}