import java.io.*;
class BAOSDemo
{
    public static void main(String[] args)
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        String s ="This should end up in array";

        byte buf[] = s.getBytes();
        baos.write(buf);
        System.out.println("Buffer as a string");
        System.out.println(buf.toString());

        System.out.println("Into array");
        byte b[] = baos.toByteArray();
        for(int i=0;i<b.length;i++0
        {
            System.out.println(char(b[i]));
        }
        System.out.println("\nTo an output stream");
        OutputStream outputstream = new FileOutputStream("test.txt");
        baos.writeTo(outputstream);
        outputstream.close();
    }
}