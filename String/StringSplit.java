import java.util.*;
import java.io.*;

class StringSplit
{
    public static void main(String[] args)
    {
        String strFileName="C:/NFCommon.1csv";
        File f = new File (strFileName);
        if (!(f.canRead ()))
        {
            System.out.println ("No file found");
            return;
        }
        FileReader fileReader;
        BufferedReader bufferedReader;
        Vector csvDataVector;
        try
        {
            fileReader = new FileReader (f.getAbsolutePath ());
            bufferedReader = new BufferedReader (fileReader);
            csvDataVector = new Vector ();
            for (String strLine = bufferedReader.readLine (); strLine != null; strLine = bufferedReader.readLine ())
            {
                strLine = strLine.trim ();
                if (strLine.startsWith ("#") || (strLine.length () == 0)) continue;
              //  csvDataVector.add(getDataObject(strLine));
              getDataObject(strLine);

            }
            Iterator ie = csvDataVector.iterator();
            while(ie.hasNext())
                {
                    System.out.println("value is "+ie.next());
                }


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }


    private static void getDataObject (String strLine)
    {
        if (strLine == null || strLine.trim ().length () == 0)
        {
            return;
        }

        Vector csvData = new Vector ();
        SplitString(strLine);
	}
private static void SplitString(String strInput)
{
	String[] strOutput= new String[strInput.split(",").length];
	int len = strInput.length();
	char[] str= new char[len];
	strInput.getChars(0,len,str,0);
	System.out.println("inside method");
	int index=0;
	int outputIndex=0;
	int firstPosition=0;
	int lastPosition=0;
	boolean quoteFlag = true;
	for(int i=0;i<len;i++)
	{
		if(str[i] == '\"')
			quoteFlag = !quoteFlag;
		if((str[i] == ',') && quoteFlag)
		{
			if(lastPosition == 0)
				firstPosition = lastPosition;
			else
				firstPosition = ++lastPosition;
	
			lastPosition=index;
			strOutput[outputIndex]=strInput.substring(firstPosition,lastPosition);
			outputIndex++;
		}
		index++;
	}
	strOutput[outputIndex]=strInput.substring(++lastPosition,len);
	for(int i=0;i<strOutput.length;i++)
	{
		if(strOutput[i]!= null)
			System.out.println("output string array is("+strOutput[i]+")");
	}
}
}
