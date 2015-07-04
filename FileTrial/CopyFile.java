import java.io.*;

class CopyFile
{
    public static void main(String[] args) throws IOException
    {
        InputStream in;
        OutputStream out;
        in = new FileInputStream(args[0]);
        out = new FileOutputStream(args[1]);
        byte[] bytes = new byte[10];
        int count=0;
        while((count=in.read(bytes))!=-1)
        {
            System.out.println("Bytes read "+count);
            out.write(bytes,0,count);

        }

/*        while(in.available() > 0)
        {
            //ch = in.read();
            out.write(in.read());
        }

*/
        in.close();
        out.close();
    }
}