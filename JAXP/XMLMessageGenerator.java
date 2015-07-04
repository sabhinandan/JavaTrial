package org.objectweb.cow.util;


/**
 * @author Thomas Vantroys
 */
public class XMLMessageGenerator
{
  public org.w3c.dom.Element createErrorMessage(String type, String msg)
  {
    org.w3c.dom.Document doc = new org.apache.xerces.dom.DocumentImpl();
    org.w3c.dom.Element root = doc.createElement("Error");

    org.w3c.dom.Element subroot = doc.createElement("Type");
    subroot.appendChild(doc.createTextNode(type));
    root.appendChild(subroot);

    subroot = doc.createElement("Msg");
    subroot.appendChild(doc.createTextNode(msg));
    root.appendChild(subroot);

    doc.appendChild(root);

    return doc.getDocumentElement();
  }

  public org.w3c.dom.Element createOneBaliseMessage(String balise, String msg)
  {
    org.w3c.dom.Document doc = new org.apache.xerces.dom.DocumentImpl();
    org.w3c.dom.Element root = doc.createElement(balise);
    root.appendChild(doc.createTextNode(msg));

    doc.appendChild(root);

    return doc.getDocumentElement();
  }
}
