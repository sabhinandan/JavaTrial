import java.io.*;
public class BufferedIOApp
{
    public static void main(String[] args) throws IOException
    {
        FileInputStream f1 = new FileInputStream("first.txt");
        FileInputStream f2 = new FileInputStream("second.txt");
        SequenceInputStream f3 = new SequenceInputStream(f1,f2);
        BufferedInputStream inStream = new BufferedInputStream(f3);
        BufferedOutputStream outStream  = new BufferedOutputStream(System.out);

        boolean eof = false;
        int byteCount=0;

        while(!eof)
        {
            int c = inStream.read();
            if(c == -1)
                eof=true;
            else
                {
                    outStream.write((char)c);
                    ++byteCount;
                }

        }

        String bytesRead = String.valueOf(byteCount);
        bytesRead += " bytes were read \n";
        outStream.write(bytesRead.getBytes(),0,bytesRead.length());
       	inStream.close();
		outStream.close();
		f1.close();
		f2.close();

    }
}