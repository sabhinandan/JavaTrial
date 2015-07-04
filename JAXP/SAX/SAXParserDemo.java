import java.io.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;

public class SAXParserDemo extends DefaultHandler
{
    public static void main (String[] args)
    {
           if (args.length !=1)
           {
               System.err.println("Usage: cmd filename");
               System.exit(1);
           }

           DefaultHandler handler = new SAXParserDemo();
           SAXParserFactory factory = SAXParserFactory.newInstance();

           try
           {
               out = new OutputStreamWriter(System.out,"UTF8");
               SAXParser saxParser = factory.newSAXParser();
               saxParser.parse(new File(args[0]),handler);
           }
           catch(Throwable t)
           {
               t.printStackTrace();
           }
           System.exit(0);
    }
    static private Writer out;
    private void emit(String s) throws SAXException
    {
     try
     {
      out.write(s);
      out.flush();
     }
     catch (IOException e)
     {
     throw new SAXException("I/O error", e);
     }
    }
    public void startDocument() throws SAXException
    {
     emit("<?xml version='1.0' encoding='UTF-8'?>");
     n1();
     }
     public void endDocument() throws SAXException
     {
      try
      {
       n1();
       out.flush();
      }
      catch (IOException e)
      {
       throw new SAXException("I/O error", e);
      }
}
public void startElement(String namespaceURI,
String sName, // simple name
String qName, // qualified name
Attributes attrs)
throws SAXException
{
echoText();
String eName = sName; // element name
if ("".equals(eName)) eName = qName; // not namespace-aware
emit("<"+eName);
if (attrs != null) {
for (int i = 0; i < attrs.getLength(); i++) {
String aName = attrs.getLocalName(i); // Attr name
if ("".equals(aName)) aName = attrs.getQName(i);
emit(" ");
emit(aName+"=\""+attrs.getValue(i)+"\"");
}
}
emit(">");
}
public void endElement(String namespaceURI,
String sName, // simple name
String qName // qualified name
)
throws SAXException
{
echoText();
String eName = sName; // element name
if ("".equals(eName)) eName = qName; // not namespace-aware
emit("</"+eName+">");
}

StringBuffer textBuffer;
private void n1() throws SAXException
    {

            String lineEnd = System.getProperty("line.seperator");
                System.out.println(lineEnd);
                //out.write(lineEnd);
    }
public void characters(char buf[], int offset, int len)
throws SAXException
{
String s = new String(buf, offset, len);
if (textBuffer == null) {
textBuffer = new StringBuffer(s);
} else {
textBuffer.append(s);
}
}
private void echoText()
throws SAXException
{
if (textBuffer == null) return;
String s = ""+textBuffer;
emit(s);
textBuffer = null;
}

}