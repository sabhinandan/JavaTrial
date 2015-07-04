import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.IOException;
import junit.framework.TestCase;

public class XMLTest extends TestCase {

  DOMParser parser = null;

  Document document = null;

  static Integer minCount = new Integer(0);

  static Integer maxCount = new Integer(10);

  public XMLTest(String name) {

    super(name);

  }

  protected void setUp() {

    parser = new DOMParser();

    try {

      parser.parse("example.xml");

      document = parser.getDocument();

    } catch (SAXException e) {

      fail("SAXException: " + e);

    } catch (IOException e) {

     fail("IOException: " + e);

    } catch (Exception e) {

      fail("Exception: " + e);

    }

  }

  protected void tearDown() {

    parser = null;

    document = null;

  }

  public void testPersonCount() {

    Integer childCount = null;

    Element root = document.getDocumentElement();

    NodeList children = root.getChildNodes();

    childCount = new Integer(children.getLength());

    assertTrue(childCount.compareTo(minCount) > 0);

    assertTrue(childCount.compareTo(maxCount) < 0);

  }

  public void testContainsPerson() {

    boolean found = false;

    Element root = document.getDocumentElement();

    NodeList nodeList = root.getElementsByTagName("person");

    for (int i = 0; i < nodeList.getLength(); i++) {

      Node node = nodeList.item(i);

      if (node.getNodeType() == node.ELEMENT_NODE) {

        if (node.getNodeName().equals("person")) {

          String name = ((Element) node).getAttribute("name");

          if (name.equals("James Scheinblum")) {

            found = true;

          }

        }

     }

    }

    assertTrue(found);

  }

};