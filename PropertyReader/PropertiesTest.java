import java.util.*;
import java.io.*;
public class PropertiesTest
{
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        String fileName = "D:/deploy/deploytest.properties";

        Properties properties = new Properties();
        properties.load(new FileInputStream(fileName));

        HashMap hm = new HashMap();
        Set hs = new HashSet();

        hs = (Set)properties.keySet();
        Iterator iterator = hs.iterator();
        while(iterator.hasNext())
        {
            String key = (String)iterator.next();
            System.out.print("Key "+key);
            System.out.print("  "+properties.getProperty(key));
            System.out.println();
        }
        properties.setProperty("DEBUG_LEVEL","30");
        properties.store(new FileOutputStream(fileName),"");
    }
}