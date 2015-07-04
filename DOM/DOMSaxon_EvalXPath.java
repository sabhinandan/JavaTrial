import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.icl.saxon.expr.*;
import com.icl.saxon.Context;
import com.icl.saxon.om.*;
import com.icl.saxon.expr.StaticContext;
import com.icl.saxon.expr.XPathException;

public class DOMSaxon_EvalXPath
{
       public static void main(String[] args)
       {
           try
           {
               if (args.length != 2)
               {
                   System.err.println("Usage java DOMSaxon_EvalXPath <xmlFileNameOrUrl> " +
               "<XPathExpression>\nExamples:");

            System.err.println("java DOMSaxon_EvalXPath Options.xml " +
               "/options/option[@key='newFeedsUrl']/@value");

            System.err.println("java DOMSaxon_EvalXPath Options.xml count(/options/option)");

            System.err.println("java DOMSaxon_EvalXPath Options.xml " + "" +
               "\"concat(/options/option[position()=last()]/@key, '=', " +
               "/options/option[position()=last()]/@value)\"");

            System.err.println("java DOMSaxon_EvalXPath http://www.PerfectXML.com/books.xml " +
               "count(/catalog/book)");

            return;

               }  // end of if
           }   // end of try
         catch(Exception exp)
         {
            System.err.println(exp.toString());
         }
         DOMSaxon_EvalXPath xpathEval = new DOMSaxon_EvalXPath();
         System.out.println(xpathEval.evalXPath(args[0],args[1]));

       }  // end of main function

       public String evalXPath(String xmlFileToLoad, String xpathExpr)
       {
           String result="";
           try
           {
               // Setting a system Property required by SAXON
               System.setProperty("javax.xml.parsers.DocumentBuilderFactory","com.icl.saxon.om.DocumentBuilderFactoryImpl");


               // Create DocumentBuilderFactory
               DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

               // Load the specify xml document
               DocumentBuilder builder =  factory.newDocumentBuilder();
               InputSource inputSrc = new InputSource(new FileInputStream(new File(xmlFileToLoad)));
               Node xmlDoc = builder.parse(inputSrc);
               NodeInfo nodeInfo = (NodeInfo) xmlDoc;

               Context context = new Context();
               context.setContextNode(nodeInfo);

               // If xml defines the namespaces, this would  be the time to declare them
               // Use StandaloneContext.declareNamespace for this purpose

               DocumentInfo docInfo = nodeInfo.getDocumentRoot();
               NamePool namePool = docInfo.getNamePool();
               StandaloneContext standaloneContext = new StandaloneContext(namePool);

               // Parse the input XPath expression
               Expression expr= Expression.make(xpathExpr, standaloneContext);
               try
               {
                 // First try to get a node-set , if it fails then try to
                 // evaluate XPath expression as a string result value
                 NodeSetValue resultSet = expr.evaluateAsNodeSet(context);

                 // Loop over result node-set
                 NodeEnumeration enumResult =  resultSet.enumerate();
                 int countNodes = 0;
                 while(enumResult.hasMoreElements())
                 {
                     try
                     {
                         NodeInfo curResultNode = enumResult.nextElement();
                         String curNodeValue =  curResultNode.getStringValue();

                         if(curNodeValue != null && curNodeValue.length() > 0)
                            result += curNodeValue + "\n";

                            countNodes++;

                     }      // end of try
                     catch(Exception exp)
                     {
                         exp.printStackTrace();
                     } // end of catch
                 } // end of while
                 if(countNodes > 0)
            {
               if(countNodes==1)
               {
                  result += "\nOne matching node found!";
               }
               else
               {
                  result += "\n" + String.valueOf(countNodes) +
                     " matching nodes found!";
               }
            } //  end of if(countNodes > 0)

            } // end of try
//            catch(Exception exp)
            catch(XPathException exp)
         {
            result = expr.evaluateAsString(context);
         }


           }   // end of try
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


       } // end of function evalXPath

} // of class DOMSaxon_EvalXPath