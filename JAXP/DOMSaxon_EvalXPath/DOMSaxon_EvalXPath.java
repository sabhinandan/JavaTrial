/*
	DOM XPath Example: Evaluate an XPath expression
	Uses SAXON alongwith JAXP DOM to evaluate an XPath expression
	Make sure SAXON jar is in the classpath
	Command line parameters are source XML URL and an XPath expression
	Example does not support XML Namespaces 
*/
import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.icl.saxon.expr.*;
import com.icl.saxon.Context;
import com.icl.saxon.om.*;

public class DOMSaxon_EvalXPath {
	public static void main(String[] args) {
		try
		{
			if(args.length != 2)
			{
				System.err.println("Usage java DOMSaxon_EvalXPath <xmlFileNameOrUrl> " + 
					"<XPathExpression>\nExamples:");

				System.err.println("java DOMSaxon_EvalXPath Options.xml " + 
					"/options/option[@key='newFeedsUrl']/@value");

				System.err.println("java DOMSaxon_EvalXPath Options.xml count(/options/option)");

				System.err.println("java DOMSaxon_EvalXPath Options.xml " + "" +					"\"concat(/options/option[position()=last()]/@key, '=', " + 
					"/options/option[position()=last()]/@value)\"");

				System.err.println("java DOMSaxon_EvalXPath http://www.PerfectXML.com/books.xml " + 
					"count(/catalog/book)");
												
				return;
			}
		}
		catch(Exception exp)
		{
			System.err.println(exp.toString());
		}
		
		//	Evaluate XPath expression now
		DOMSaxon_EvalXPath xpathEval = new DOMSaxon_EvalXPath();
		System.out.println(xpathEval.evalXPath(args[0], args[1]));
	}

	public String evalXPath(String xmlFileToLoad, String xpathExpr)
	{
		String result="";
		
		try
		{
			//	Setting a system property required by SAXON
			System.setProperty("javax.xml.parsers.DocumentBuilderFactory", 
				"com.icl.saxon.om.DocumentBuilderFactoryImpl");

			//	Create DocumentBuilderFactory  
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
			//	Load the specified XML document
			DocumentBuilder builder = factory.newDocumentBuilder();
			InputSource inputSrc = new InputSource
				(new FileInputStream(new File(xmlFileToLoad)));
			Node xmlDoc = builder.parse(inputSrc);

			//	Assign root node to SAXON NodeInfo, which is then used to 
			//	set the current context node for XPath searches  
			NodeInfo nodeInfo = (NodeInfo) xmlDoc;
			Context context = new Context();
			context.setContextNode(nodeInfo);

			//	If XML document defines namespaces, this would be the time to declare them
			//	Use StandaloneContext.declareNamespace for this purpose
			DocumentInfo docInfo = nodeInfo.getDocumentRoot();
			NamePool namePool = docInfo.getNamePool();
			StandaloneContext standaloneContext = new StandaloneContext(namePool); 
			
			//	Parse the input XPath expression
			Expression expr = Expression.make(xpathExpr, standaloneContext);

			try
			{
				//	First, try to get a node-set, if it fails then try to 
				//	evaluate XPath expression as a string result value
				NodeSetValue resultSet = expr.evaluateAsNodeSet(context);

				//	Loop over result node-set
				NodeEnumeration enumResult = resultSet.enumerate();
				int countNodes = 0;
				while(enumResult.hasMoreElements())
				{
					try
					{
						NodeInfo curResultNode = enumResult.nextElement();
						String curNodeValue = curResultNode.getStringValue();

						if(curNodeValue != null && curNodeValue.length() > 0) 
							result += curNodeValue + "\n"; 

						countNodes++;
					}
					catch(Exception exp)
					{
						exp.printStackTrace();
					}
				}

				if(countNodes > 0)
				{
					if(countNodes==1)
					{
						result += "\nOne matching node found!";
					}
					else
					{
						result += "\n" + String.valueOf(countNodes) +							" matching nodes found!";
					}
				}
				
			}
			catch(XPathException exp)
			{
				result = expr.evaluateAsString(context);
			}
		}
		catch(SAXException exp)
		{
			System.out.println("'" + xmlFileToLoad + "' is NOT well-formed.\n" + exp.toString());
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
			exp.printStackTrace();
		}
		
		return result;
	}
	
}
