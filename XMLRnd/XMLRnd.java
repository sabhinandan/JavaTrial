import java.io.*;
import org.jdom.*;
import org.jdom.output.XMLOutputter;


public class XMLRnd
{
    public static void main(String args[])
    {
        Element element = new Element("sequence");
        Element firstNumber = new Element("number");
        Element secondNumber = new Element("number");
        firstNumber.setText("3");
        secondNumber.setText("5");
        element.addContent("\n  ");
        element.addContent(firstNumber);
        element.addContent("\n  ");
        element.addContent(secondNumber);
        element.addContent("\n");
        //Document doc = new Document();
        //doc.setRootElement(element);
        System.out.println("The xml is "+element);
        XMLOutputter outputter = new XMLOutputter();
//        try
//        {
            String hello = outputter.outputString(element);
            System.out.println(hello);
            //outputter.output(element, System.out);
//        }
/*        catch (IOException e)
        {
            System.err.println(e);
        }
*/
    }
}