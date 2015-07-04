import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import java.io.*;

public class ApplyXSLT
{
    public static void main(String[] args)
    {
        int argsCount = 0;
        try
        {
            argsCount =  args.length;
            if(argsCount != 2)
               {
                   System.err.println("Usage java ApplyXSLT <localXMLFile> " +
                    "<localXSLTFile>\nExamples");

            System.err.println("\tjava ApplyXSLT BestBooks.xml BestBooks.xsl ");
            System.err.println("\tjava ApplyXSLT lowercase.xml ToUpper.xsl ");
            System.exit(1);
               } // end of if argsCount != 2
        } // end of try
        catch(Exception exp)
        {
         exp.printStackTrace();
         System.exit(1);
        }
        try
        {
            // Source XML File
            StreamSource xmlFile = new StreamSource(new File(args[0]));

            // Source XSLT StyleSheet
            StreamSource xsltFile = new StreamSource(new File(args[1]));
            TransformerFactory xsltFactory = TransformerFactory.newInstance();
            Transformer transformer = xsltFactory.newTransformer(xsltFile);

            // Send transformed output to console
            StreamResult resultStream =  new StreamResult(System.out);

            // Apply the transformation
            transformer.transform(xmlFile, resultStream);
        } // end of try
        catch(Exception exp)
        {
            exp.printStackTrace();
        } // end of catch
    } // end of main function
} // end of class ApplyXSLT