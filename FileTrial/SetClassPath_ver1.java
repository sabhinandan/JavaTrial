/*
package com.neustar.customtask;
import java.io.*;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.apache.tools.ant.Project;
import com.neustar.log.Debug;
*/
import java.io.*;
public class SetClassPath
{
    Debug debug;
    public static void main(String[] args)
    {
        //String installRoot = getProject().getProperty("INSTALL_ROOT");
        String os = "";
        try
        {
            os = System.getProperty("os.name");
            if(os.startsWith("Win"))
            {
               // ChangeBatchFile(installRoot+"/"+"setenv.bat");
               ChangeBatchFile("temp.txt");
            }
            else
            {
                //ChangeShFile(installRoot+"/"+"setenv.sh");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void ChangeBatchFile(String fileName) throws FileNotFoundException, IOException
    {

        char ch;
        File f;
        int i=0;
        f = new File(fileName);
        char[] chArray  = null;
        try
        {
            FileInputStream fis=  new FileInputStream(fileName);
            System.out.print(fis.available());
            chArray = new char[fis.available()];
            while(fis.available() > 0)
            {
                ch = (char)fis.read();
                chArray[i]= ch;
                i++;
		    }
        } // end of try block
        catch(Exception e)
        {
            e.printStackTrace();
        }
        String strSetenv = new String(chArray);
	   //System.out.println("String is "+str);
        int breakPoint=0;
        String lineSeperator=(String)System.getProperty("line.separator");
        String[] setenvTokens = strSetenv.split(lineSeperator);
        String[] finalTokens = new String[setenvTokens.length];

        for(breakPoint=0;breakPoint<setenvTokens.length;breakPoint++)
        {
            System.out.println(" Token "+ breakPoint + " " +setenvTokens[breakPoint]);
            if((setenvTokens[breakPoint].indexOf("CLASSPATH") > 0) && (setenvTokens[breakPoint].indexOf(".jar") > 0 ) && (setenvTokens[breakPoint].indexOf("NFICLASSPATH") < 0 ) )
            {
                  setenvTokens[breakPoint] =  "set CLASSPATH=<CLASSPATH>;";
            }
            finalTokens[breakPoint] = setenvTokens[breakPoint];
        }
        for(int intI=0; intI<finalTokens.length;intI++)
        {
            System.out.println(finalTokens[intI]);
        }
    // The below code is to delete the file and create new file with existing name
        f.delete();
        f = new File(fileName);
        f.createNewFile();
    // The below code is to write the data back in to the file
        FileOutputStream fos = new FileOutputStream(fileName);
        for(int intI=0; intI<finalTokens.length;intI++)
        {
            if(finalTokens[intI] != null)
            {
                byte[] b  =  finalTokens[intI].getBytes();
                fos.write(b);
                fos.write('\r');
                fos.write('\n');
            }
        }
        fos.close();
    }
    public static void ChangeShFile(String fileName) throws FileNotFoundException, IOException
    {
	   char[] chArray = new char[5000];
        char ch;
        File f;
        int i=0;
        try
        {
            FileInputStream fis=  new FileInputStream(fileName);
            while(fis.available() > 0)
            {
                ch = (char)fis.read();
                chArray[i]= ch;
                i++;
            }
        } // end of try block
        catch(Exception e)
        {
            System.out.println("Error is "+ e);
        }
        String strSetenv = new String(chArray);
	    int breakPoint=0;
        String lineSeperator=(String)System.getProperty("line.separator");

        String[] setenvTokens = strSetenv.split(lineSeperator);
        String[] finalTokens = new String[setenvTokens.length+2];
        for(breakPoint=0;breakPoint<setenvTokens.length;breakPoint++)
        {
            System.out.println(" Token "+ breakPoint + " " +setenvTokens[breakPoint]);
            if(setenvTokens[breakPoint].startsWith("CLASSPATH"))
            {
                break;
            }
            finalTokens[breakPoint] = setenvTokens[breakPoint];
        }
        finalTokens[breakPoint]="CLASSPATH=<CLASSPATH>:"+lineSeperator;
        finalTokens[++breakPoint]="CLASSPATH=$NFICLASSPATH:$CLASSPATH:$NMICLASSPATH";
        finalTokens[++breakPoint]="export CLASSPATH";
        for(int intI=0; intI<finalTokens.length;intI++)
        {
            System.out.println(finalTokens[intI]);
        }
    // The below code is to delete the file and create new file with existing name
        f = new File(fileName);
        f.delete();
        f = new File(fileName);
        f.createNewFile();
    // The below code is to write the data back in to the file
        FileOutputStream fos = new FileOutputStream(fileName);
        for(int intI=0; intI<finalTokens.length;intI++)
        {
            if(finalTokens[intI] != null)
            {
                byte[] b  =  finalTokens[intI].getBytes();
                fos.write(b);
                fos.write('\n');
            }
        }
        fos.close();
    }
}