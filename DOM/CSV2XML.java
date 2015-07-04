import java.io.*;
import java.util.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class CSV2XML
    {
       protected DocumentBuilderFactory domFactory = null;
       protected DocumentBuilder domBuilder = null;

       public CSV2XML()
       {
           try
           {
              domFactory = DocumentBuilderFactory.newInstance();
              domBuilder = domFactory.newDocumentBuilder();
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

           public int convertFile(String csvFileName, String xmlFileName)
              {
                  int rowsCount = -1;
                  try
                  {
                      Document newDoc = domBuilder.newDocument();
                      // Root Element
                      Element rootElement = newDoc.createElement("CSV2XML");
                      newDoc.appendChild(rootElement);

                      //Read comma seperated values
                      BufferedReader csvReader;
                      csvReader = new BufferedReader(new FileReader(csvFileName));

                      int fieldCount=0;
                      String[] csvFields = null;
                      StringTokenizer stringTokenizer = null;

                      //Assumption First line in CSV file is column/field name
                      //As the columns names are used to name the column names in xml file,
                      //avoid using spaces/any other characters not suitable for XMl element naming

                      String curLine = csvReader.readLine();

                      if(curLine != null)
                      {
                          stringTokenizer = new StringTokenizer(curLine,",");
                          fieldCount = stringTokenizer.countTokens();
                          if(fieldCount >0)
                          {
                              csvFields = new String[fieldCount];
                              int i=0;
                              while(stringTokenizer.hasMoreElements())
                              {
                                  csvFields[i++]=String.valueOf(stringTokenizer.nextElement());
                              } // end of while
                          } // end of if fieldCount > 0
                      } // end of if CurLine != null

                      while((curLine = csvReader.readLine()) != null)
                      {
                          stringTokenizer = new StringTokenizer(curLine,",");
                          fieldCount = stringTokenizer.countTokens();
                          if (fieldCount > 0)
                          {
                              Element rowElement = newDoc.createElement("row");
                              int i=0;
                              while(stringTokenizer.hasMoreElements())
                              {
                                  try
                                  {
                                      String curValue=String.valueOf(stringTokenizer.nextElement());
                                      Element curElement=newDoc.createElement(csvFields[i++]);
                                      curElement.appendChild(newDoc.createTextNode(curValue));
                                      rowElement.appendChild(curElement);
                                  }
                                   catch(Exception exp)
                                   {
                                   exp.printStackTrace();
                                   }

                              } //end of while(stringTokenizer.hasMoreElements())
                              rootElement.appendChild(rowElement);
                             rowsCount++;
                          } // end of if (fieldCount > 0)
                      } // end of while((curLine = csvReader.readLine()) ! = null)
                       csvReader.close();
                       // save the document to the disk file

                       TransformerFactory tranFactory = TransformerFactory.newInstance();
                       Transformer aTransformer = tranFactory.newTransformer();

                       Source src = new DOMSource(newDoc);
                       Result dest = new StreamResult(new File(xmlFileName));
                       aTransformer.transform(src,dest);
                       rowsCount++;
                  }
                  catch(IOException exp)
                  {
                    System.err.println("Error is here"+exp.toString());
                  }
                  catch(Exception exp)
                  {
                     System.err.println("Error is"+exp.toString());
                  }

                  return rowsCount;
            } // end of function public int convertFile(String csvFileName, String xmlFileName)

            public static void main(String[] args)
            {
                try
                {
                    if(args.length != 2)
                    {
                        System.err.println("Usage: java CSV2XML <inputCSVfile> <outputXMLfile>");
                        return;
                    }
                }
                catch(Exception exp)
                {
                    exp.printStackTrace();
                }
                try
                {
                    CSV2XML csvConverter = new CSV2XML();
                    int rowsCount = csvConverter.convertFile(args[0], args[1]);
                    if(rowsCount >= 0)
                    {
                        System.out.println("CSV File " + args[0] + "'Succesfully converted to xml file ' "+ args[1] +
                        " '\n " + "(" + String.valueOf(rowsCount) + " rows)");
                    }
                    else
                    {
                        System.out.println("Error while converting input CSV File '" + args[0] +
                        "' to output XML File '"+ args[1] + "'");
                    }
                } // end of try
                catch(Exception exp)
                {
                    exp.printStackTrace();
                }
            }    // end of main function
    } // of class