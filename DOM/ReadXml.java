import org.w3c.dom.*;
class ReadXml
{
    public static void main(String args[])
    {
        DOMImplementationLS impl = new XMLDOMImplementation();
        LSParser parser = impl.createLSParser(DOMImplementationLS.MODE_SYNCHRONOUS, null);
    }
}
