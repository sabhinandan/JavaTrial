import org.jdom.*;
import org.jdom.output.XMLOutputter;
import java.util.*;
public class ReadXML
{
    public static void main(String[] args)
    {
        Element backupContainer = new Element("BackupContainer");
        Element backup = new Element("Backup");
        Element backupFile = new Element("BackupFile");
        Element pathContainer = new Element("PathContainer");
        Element path1 = new Element("Path");
        Element path2 = new Element("Path");

        path1.setAttribute("value","C:\\abc");
        path2.setAttribute("value","C:\\def");

        backupFile.setAttribute("value","0");

        pathContainer.addContent("\n");
        pathContainer.addContent(path1);
        pathContainer.addContent("\n");
        pathContainer.addContent(path2);
        pathContainer.addContent("\n");
        backup.addContent("\n");
        backup.addContent(backupFile);
        backup.addContent("\n");
        backup.addContent(pathContainer);
        backupContainer.addContent("\n");
        backupContainer.addContent(backup);

        XMLOutputter outputter = new XMLOutputter();

        String hello = outputter.outputString(backupContainer);
        System.out.println(hello);
        ReadXML(backup);
    }
    public static void ReadXML(Element eleParent)
    {
        XMLOutputter outputter = new XMLOutputter();
        Element elePathContainer = eleParent.getChild("PathContainer");
        Element eleBackupFile = eleParent.getChild("BackupFile");

        List lstPath = elePathContainer.getChildren("Path");
        Iterator lstIterator = lstPath.iterator();
        while(lstIterator.hasNext())
        {
            String hello = outputter.outputString((Element)lstIterator.next());
            System.out.println(hello);
        }
    }
}