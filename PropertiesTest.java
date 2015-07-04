import java.io.FileInputStream;
import java.util.Properties;
import org.apache.log4j.SimpleLayout;
class PropertiesTest {
    public static void main(String args[])  throws Exception
    {
	// set up new properties object from file "myProperties.txt"
	    FileInputStream propFile = new FileInputStream("C:\\ant\\Debug.properties");
	    //Properties p = new Properties(System.getProperties());
	    Properties p = new Properties();
	    p.load(propFile);
        SimpleLayout simpleLayout = new SimpleLayout();
		// set the system properties
        System.setProperties(p);
        System.out.println(System.getProperty("DEBUG_LOG_LEVELS"));

//            System.getProperties().list(System.out);
    }
}