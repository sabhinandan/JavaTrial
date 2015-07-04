/*
 *	Console application that loads a remote XML document
 *	The URL provided is actually GET call to a .NET Web service
 *	The command line parameters:
 *		Zip code (ex: 60195, 98007, etc.)
 *		Instrument (Optional) (ex: Piano, Guitar, Drums, etc.)  
 *
 *	Applies XSLT stylesheet on the loaded document and  saves the
 *	HTML output to a file named output.html.
 */
import java.io.*;
import java.net.URL;
import javax.xml.transform.*;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.*;
import org.xml.sax.*;

public class SAX_CallDotNetWebSvc {

	public static void main(String[] args) {
		try
		{
			if(args.length < 1)
			{
				System.err.println("Usage: java SAX_CallDotNetWebSvc <zipCode> [Instrument]\nExamples:");
				System.err.println("\tjava SAX_CallDotNetWebSvc 60195");
				System.err.println("\tjava SAX_CallDotNetWebSvc 60195 Piano");
				System.exit(1);
			}
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
		try
		{
			String instrument = "";
			if(args.length > 1 && args[1] != null)
				instrument = args[1];
			
			URL webSvcGetURL = new URL("http://www.PerfectXML.net/Webservices" + 
				"/MusicTeachers/MusicTeachers.asmx/FindMusicTeachers?ZipCode=" + 
				args[0] + "&Instrument=" + instrument + "&SkillLevel=&Style=&Radius=" +  
				"20&RestrictResultsCount=20");
			
			System.out.println("Loading " + webSvcGetURL + "\nPlease wait...\n");
			BufferedReader bufferedReader = new BufferedReader
				(new InputStreamReader(webSvcGetURL.openStream()));
			
			//	XML 
			SAXSource saxSource = new SAXSource(new InputSource(bufferedReader));
			
			String curDir = new File(".").getCanonicalPath();
			String xslFileName = curDir + File.separator + "MusicTeachers.xsl";
			String outputFileName = curDir + File.separator + "output.html";
			
			//	XSLT
			StreamSource xlstStreamSource = new StreamSource(new File(xslFileName));
			
			//	Output file
			File resultHTMLFile = new File(outputFileName);
			if(resultHTMLFile.exists())
				resultHTMLFile.delete();
			StreamResult streamResult = new StreamResult(resultHTMLFile);
			
			//	Get XML, apply Transformation, save results
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer(xlstStreamSource);
			transformer.transform((Source)saxSource, streamResult);  
			
			System.out.println("Results saved into " + outputFileName + ".");
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
	}
}
