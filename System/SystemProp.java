import java.util.*;
import java.io.*;
public class SystemProp 
{
	public static void main(String[] args) 
	{
		Properties props = System.getProperties();
    
	  // Enumerate all system properties
		 Enumeration enum = props.propertyNames();
			for (; enum.hasMoreElements(); ) {
			  // Get property name
			  String propName = (String)enum.nextElement();
			
        // Get property value
				 String propValue = (String)props.get(propName);
				 System.out.println(propName+" = "+propValue+"\n");
    }

		
	}
}
