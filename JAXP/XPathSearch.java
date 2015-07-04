package org.objectweb.cow.util;

public class XPathSearch implements java.io.Serializable
{
  /** search the target with the xpath  */
  public org.w3c.dom.traversal.NodeIterator search(String xpath,
    org.w3c.dom.Node target)
  {
    org.w3c.dom.traversal.NodeIterator nl;

    if ((xpath != null) && (xpath.length() > 0))
    {
      try
      {
        nl = org.apache.xpath.XPathAPI.selectNodeIterator(target, xpath);
      }
      catch (javax.xml.transform.TransformerException ex)
      {
        System.err.println("Erreur XPathSearch.search: TransformerException");
        ex.printStackTrace();

        return null;
      }

      return nl;
    }
    else
    {
      return null;
    }
  }
}
