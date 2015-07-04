/*
    DOM Example: Check if provided URI is a well-formed XML document
    Illustrates: Loading XML document using DOM
*/
import javax.xml.parsers.*;
public class IsWellFormed {
    public static void main(String[] args)
    {
        if(args.length != 1)
        {
            System.err.println("Usage: java IsWellFormed <xmlFileNameOrUrl>\nExamples:");
            System.err.println("\n\tjava IsWellFormed c:\\1.xml");
            System.err.println("\n\tjava IsWellFormed http://www.PerfectXML.com/books.xml");
            return;
        }

        try
        {
            DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder domBuilder = domFactory.newDocumentBuilder();
            domBuilder.parse(args[0]);
            System.out.println("'" + args[0] + "' is well-formed.");
        }
        catch(org.xml.sax.SAXException exp)
        {
            System.out.println("'" + args[0] + "' is NOT well-formed.\n" + exp.toString());
        }
        catch(FactoryConfigurationError exp)
        {
            System.err.println(exp.toString());
        }
        catch(ParserConfigurationException exp)
        {
            System.err.println(exp.toString());
        }
        catch(Exception exp)
        {
            System.err.println(exp.toString());
        }
    }
}
