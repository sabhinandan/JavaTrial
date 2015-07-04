import java.io.*;
class FileRND
{
    public static void main(String[] args) throws IOException
    {
//        String fileSeperator= File.separator;//System.getProperty("file.separator");
  //      String pathSeperator= File.pathSeparator;//.getProperty("path.separator");
    //    System.out.println("File Seperator is "+fileSeperator);
      //  System.out.println("Path Seperator is "+pathSeperator);
        File f = new File("d:/NFI.MANIFEST");
        System.out.println(f.exists());
        System.out.println("getParent methodd "+f.getParent());
//        System.out.println("getParentFile method "+ f.getParentFile().getParent().concat(File.separator));

     //   f.mkdirs();
    }
}