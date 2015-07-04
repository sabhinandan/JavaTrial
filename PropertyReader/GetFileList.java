import java.io.File;
import java.io.*;
import java.util.*;
public class GetFileList
{
    public static void main(String[] args)
    {
        Vector vec = new Vector();
        Vector outputVector = new Vector();
        outputVector = showProperties("D:/deleteMe",vec);
        Iterator iterator = vec.iterator();
        while(iterator.hasNext())
        {
            System.out.println((String)iterator.next());
        }
    }
//    static  Vector vecPropertiesFile = null;
    public static Vector showProperties(String strFile, Vector vecPropertiesFile)
    {
       File f = new File(strFile);
       if(vecPropertiesFile == null)
       {
           vecPropertiesFile = new Vector();
       }
       if(f.isDirectory())
       {
           File[] fileList = f.listFiles();
           for(int i=0;i<fileList.length;i++)
           {
                if(fileList[i].isDirectory())
                {
                    showProperties(fileList[i].toString(),vecPropertiesFile);
                }
                else
                {
//                    System.out.println("file list is "+fileList[i].toString());
                    vecPropertiesFile.add(fileList[i].toString());
                }
           }
       }

        return vecPropertiesFile;
    }

}
/*
  class OnlyProperties implements FilenameFilter
  {
  public boolean accept(File dir, String s)
  {
    if(dir.isDirectory())
    {
        File[] file = dir.li
    }
    if (s.endsWith(".properties"))
      return true;
    return false;
  }
*/