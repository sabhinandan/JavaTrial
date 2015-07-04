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
import org.w3c.dom.Node;
class DOMRnd
{
    public static void main(String[] args)
    {
        try{
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
          String fileDetail = FileUtils.readFile(xml);
          Document config = createDOM(xml);
        if (config == null) {
            Debug.error("Could not create DOM for server configuration file...");
            return;
        }
        try {
           // Element ruleFile = (Element) config.getElementsByTagName("ruleContainer").item(0);
          //  LOGFILE = ((Element) config.getElementsByTagName(AutomationConstants.LOGFILE).item(0)).getAttribute("value");
//            NodeList templates = config.getElementsByTagName("ruleContainer");
            NodeList templates = config.getElementsByTagName("CCNA");
            Node node = templates.item(0);
            while(node.getParentNode() != null)
            {
               System.out.println("Node has child nodes "+node.getParentNode().getNodeName());
              node = node.getParentNode();
            }



/*              for(int i=0;i<nodeList.getLength();i++)
              {
                  System.out.println(nodeList.item(i));
              }
*/
/*           for(int i=0;i<templates.getLength();i++)
           {
             Element ruleContainer = (Element) templates.item(i);
             NodeList description =   ruleContainer.getElementsByTagName("description");

             NodeList description1 =   ruleContainer.getElementsByTagName("ID");
             System.out.println("ID is "+description1.item(0));
             System.out.println("Description is "+description.item(0));
           }
*/
          } // end of try block
        catch(Exception e)
        {
             e.printStackTrace();
        }
       } // end of try block
    catch(Exception e)
    {
       e.printStackTrace();
    }
} // end of function


}