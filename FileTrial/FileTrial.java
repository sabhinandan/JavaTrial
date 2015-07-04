import java.io.*;
import java.util.regex.*;
class FileTrial
{
 public static void main(String[] args)
 {
//        Pattern p = Pattern.compile("\w*.java");

//        boolean b = m.matches();
  try{
	//		FileInputStream fis=  new FileInputStream("ReadMe1.txt");
	     File f = new File("D:/JavaTrial/String");
	     if (f.isDirectory())
	     {
	         File[] fileName = f.listFiles();
	         System.out.println(fileName.length);
             for(int i=0;i<fileName.length;i++)
             {
                      boolean b = Pattern.matches("[a-zA-Z_0-9]*.java",fileName[i].getName() );
                      if(b)
                      System.out.println("File name is "+fileName[i].getName());
             }
	     }
	     if(f.exists())
	     {
	         System.out.println("File exists");
	     }
	     else
	     {
	         System.out.println("File does not exists");
	     }


/*			while(fis.available() > 0)
				{
					System.out.print("(" + fis.available() + ")");
                    System.out.print((char)fis.read());
				}
*/
		} // end of try block
		catch(Exception e)
		{
		System.out.println("Error is "+ e);
		}
  System.out.println("Just do it");
 }

}