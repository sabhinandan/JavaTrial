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
        try
        {
           ChangeBatchFile();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return;
        }
    }
    public static void ChangeBatchFile() throws FileNotFoundException, IOException
    {
        String fileName="";
        String os = "";
        char charSetEnv;
        File fSetEnv;
        int intCounter=0;
        os = System.getProperty("os.name");
        if(os.startsWith("Win"))
        {
            // ChangeBatchFile(installRoot+"/"+"setenv.bat");
            fileName = "temp.sh";
        }
        else
        {
            fileName = "temp.sh";
            //ChangeShFile(installRoot+"/"+"setenv.sh");
        }
        char[] chArray  = null;
        try
        {
            System.out.println(fileName);
            FileInputStream fisSetEnv=  new FileInputStream(fileName);
            chArray = new char[fisSetEnv.available()];
            while(fisSetEnv.available() > 0)
            {
                //charSetEnv = (char)fisSetEnv.read();
                //chArray[intCounter]= charSetEnv;
                chArray[intCounter]= (char)fisSetEnv.read();
                intCounter++;
		    }
        } // end of try block
        catch(Exception e)
        {
            e.printStackTrace();
            return;
        }
        String strSetenv = new String(chArray);
        String lineSeperator=System.getProperty("line.separator");
        String[] setenvTokens = strSetenv.split(lineSeperator);

        for(int breakPoint=0;breakPoint<setenvTokens.length;breakPoint++)
        {
            if((setenvTokens[breakPoint].indexOf("CLASSPATH") >= 0) && (setenvTokens[breakPoint].indexOf(".jar") > 0 ) && (setenvTokens[breakPoint].indexOf("NFICLASSPATH") < 0 ) )
            {
                  if(fileName.endsWith(".txt"))
                  {
                    setenvTokens[breakPoint] =  "set CLASSPATH=<CLASSPATH>;";
                  }
                  else
                  {
                    setenvTokens[breakPoint] =  "CLASSPATH=<CLASSPATH>:";
                  }
            }
        }
    // The below code is to delete the file and create new file with existing name
        fSetEnv = new File(fileName);
        fSetEnv.delete();
        //f = new File(fileName);
        //f.createNewFile();
    // The below code is to write the data back in to the file
        FileOutputStream fosSetEnv = new FileOutputStream(fileName);
        for(int intI=0; intI<setenvTokens.length;intI++)
        {
            if(setenvTokens[intI] != null)
            {
                byte[] byteArray  =  setenvTokens[intI].getBytes();
                fosSetEnv.write(byteArray);
                if(fileName.endsWith(".txt"))
                {
                    fosSetEnv.write('\r');
                    fosSetEnv.write('\n');
                }
                else
                {
                    fosSetEnv.write('\n');
                }
             }
        }
        fosSetEnv.close();
    }
}