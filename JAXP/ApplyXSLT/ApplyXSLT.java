/*
 * Apply XSLT stylesheets
 * Input parameters are names of local XML and XSLT files
 * Output is sent to the console  
 * XSLT Parameters are not supported.
 */

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import java.io.*;
public class ApplyXSLT {

	public static void main(String[] args) {
		int argsCount=0;
		try
		{
			argsCount = args.length;
			if(argsCount != 2)
			{
				System.err.println("Usage java ApplyXSLT <localXMLFile> <localXSLTFile>\nExamples");
				System.err.println("\tjava ApplyXSLT BestBooks.xml BestBooks.xsl ");
				System.err.println("\tjava ApplyXSLT lowercase.xml ToUpper.xsl ");
				System.exit(1);
			}
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
			System.exit(1);
		}
		
		try
		{

			//	Source XML File
			StreamSource xmlFile = new StreamSource(new File(args[0]));
			
			//	Source XSLT Stylesheet
			StreamSource xsltFile = new StreamSource(new File(args[1]));
			TransformerFactory xsltFactory = TransformerFactory.newInstance();
			Transformer transformer = xsltFactory.newTransformer(xsltFile);

			//	Send transformed output to the console
			StreamResult resultStream = new StreamResult(System.out);

			//	Apply the transformation
			transformer.transform(xmlFile, resultStream);
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
	}
}
