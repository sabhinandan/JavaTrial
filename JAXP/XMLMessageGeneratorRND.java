
import com.nightfire.framework.util.FrameworkException;
import com.nightfire.framework.util.StringUtils;
import com.nightfire.framework.message.generator.xml.XMLMessageGenerator;
import com.nightfire.framework.util.*;
import com.nightfire.framework.message.*;
import com.nightfire.framework.message.parser.xml.*;
import com.nightfire.framework.message.common.xml.XMLLibraryPortabilityLayer;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;

class XMLMessageGeneratorRND
{
public static void main(String[] args)
  {
   try{
//   String s  = createHeader();
   if(args.length == 1)
   {
    giveCount(args[0]);
   } // end of if
   else
   {
       System.out.println("Syntax is java XMLMessageGeneratorRND < Name of the xml file > ");
   }

   }
   catch(Exception e)
      {
       e.printStackTrace();
      }

  }
  private static Document createDOM(String xml) {
        Document config = null;
        try {

            Debug.log(Debug.NORMAL_STATUS, "Creating DOM...");
            // Using NF Common Parser to create DOM
            String fileDetail = FileUtils.readFile(xml);
            config = XMLLibraryPortabilityLayer.convertStringToDom(fileDetail);
        } catch (Exception e) {
            Debug.error("[ServerConfig:createDOM]Unable to parse the server configuration XML.");
            Debug.error(e.getMessage());
        }

        // Return the complete config document
        return config;
    }

public static void giveCount(String xml)
{
    try{
//        FileUtils file = new FileUtils();
          String fileDetail = FileUtils.readFile(xml);
//        XMLMessageParser xmlMsgParser = new XMLMessageParser(fileDetail);
          Document config = createDOM(xml);
        // Check if failed to create config DOM
        if (config == null) {
            Debug.error("Could not create DOM for server configuration file...");
            return;
        }

        try {
           // Element ruleFile = (Element) config.getElementsByTagName("ruleContainer").item(0);
          //  LOGFILE = ((Element) config.getElementsByTagName(AutomationConstants.LOGFILE).item(0)).getAttribute("value");
            NodeList templates = config.getElementsByTagName("ruleContainer");
           for(int i=0;i<templates.getLength();i++)
           {
             Element ruleContainer = (Element) templates.item(i);
             NodeList description =   ruleContainer.getElementsByTagName("description");
             System.out.println("Description is "+description.item(0));
           }
            }
        catch(Exception e)
        {
                        e.printStackTrace();
        }
       }
    catch(Exception e)
    {
       e.printStackTrace();
    }
}
/*private static String createHeader() throws MessageException
	{
		XMLMessageGenerator gen = new XMLMessageGenerator ("HEADER");
		gen.setValue("SUPPLIER", "ZTel");

		XMLMessageParser xmlMsgParser = new XMLMessageParser(xml);
		//to check if its preorder or order
               xmlMsgParser.getChildCount("<description");
			gen.setValue( "REQUEST", "PREORDER");
			gen.setValue( "SERVER", "Nightfire.spi.lsr_preorder");
        	return gen.getMessage();
	}
 */
}