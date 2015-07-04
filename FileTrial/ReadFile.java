import java.io.*;
class ReadFile
{
public static void main(String[] args)
	{
	char ch;
    	try{
			FileInputStream fis=  new FileInputStream("ReadMe.txt");
            while((ch=(char)fis.read()) null)
//			while(fis.available() > 0)
				{
                    System.out.print(ch);

				//	System.out.print((char)fis.read());
				}
		} // end of try block
		catch(Exception e)
		{
		System.out.println("Error is "+ e);
		}
	}
}