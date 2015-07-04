import java.io.*;

class WriteFile
{
public static void main(String[] args)
{
char ch=' ';
 try{
 FileOutputStream fos=new FileOutputStream("Demo.txt",true);
         while(ch !='*')
         {
         ch=(char)System.in.read();
         if(ch !='*')
         fos.write(ch);
         }
  }
    catch(Exception e)
    {
    System.out.println("Error is "+e.getMessage());
    }

}
}