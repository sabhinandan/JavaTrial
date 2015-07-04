import java.util.Date;
public class GetPath
{
    public static void main(String[] args)
    {
     try{
           //System.out.println(System.getProperty("java.library.path"));
           // System.out.println(System.getProperties());
           System.out.println((Date)((long)System.currentTimeMillis()));
        }
     catch(SecurityException exp)
     {
         System.out.println("Security exception is "+exp.getMessage());
     }
     catch(NullPointerException exp)
     {
         System.out.println("Null Pointer exception is "+exp.getMessage());
     }

    }

}