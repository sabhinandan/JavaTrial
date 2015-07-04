import java.io.*;
class OnlyExt implements FilenameFilter
{
      String ext;
      public OnlyExt(String ext)
      {
          this.ext=ext;
      }
      public boolean accept(File dir, String name)
      {
       System.out.println("dir is "+dir);
       System.out.println("name is "+name);
       return name.endsWith(ext);
      }

}
public class DirListOnly
{
    public static void main(String[] args)
    {
        String dirName="D:/javatrial/FileTrial";
        File f1 = new File(dirName);
        FilenameFilter only = new OnlyExt("class");
        String[] s = f1.list(only);
        for(int i=0;i<s.length;i++)
        {
            System.out.println(s[i]);
        }
    }
}