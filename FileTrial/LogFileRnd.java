package com.neustar.log;

import javax.servlet.ServletContext;
import java.util.Date;
import java.util.Vector;
import java.io.*;
import java.text.SimpleDateFormat;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

import org.apache.tools.ant.Project;
import org.apache.log4j.Logger;
import org.apache.log4j.FileAppender;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.Level;
import com.neustar.customtask.PropertyConstants;

//import java.util.*;
import java.util.Properties;
/**
 * Created by
 * User: amaheshwari
 * Date: Aug 22, 2006
 * Time: 1:21:55 PM
 *
 *  * A class which is used for logging
 *
 */

public class Debug extends Task
{
    private static Logger logger = null;
    public static String logFileName;
    public static String Debug_Level;
    public static Debug debug;
    private static Properties p;
    private static FileInputStream propFile;

    static
    {
        try
        {
            propFile = new FileInputStream("build.properties");
            p = new Properties();
    	    p.load(propFile);
        }
        catch(FileNotFoundException fnfe)
        {
            fnfe.printStackTrace();
        }
        catch(IOException fnfe)
        {
            fnfe.printStackTrace();
        }
    }

    public void execute() throws BuildException
    {
        try
        {
            debug = Debug.getInstance();

        }
        catch(IOException ie)
        {
            ie.printStackTrace();
        }

    }
    private Debug()
    {

    }

    public static Debug getInstance() throws IOException
    {

        Debug_Level=(String)p.get("DEBUG_LOG_LEVELS");
        logFileName = (String)p.get("LOG_FILE");
        if(Debug_Level == null || Debug_Level.trim().length() == 0)
        {
            Debug_Level = "INF";
        }
        if(logFileName == null || logFileName.trim().length() == 0)
        {
            logFileName="DeployProperty.log";
        }

        if(debug != null)
            return debug;
        else
        {
            debug = new Debug();
            debug.initialize(true);
        }

        return debug;
    }
    public void initialize (boolean append)// throws IOException
    {
        try
        {
        System.out.println("Inside initialize with append value is "+ append);
        String s = "true";
        logger = Logger.getLogger(Debug.class);
        SimpleLayout layout = new SimpleLayout();
        FileAppender fileAppender = new FileAppender (layout, logFileName, append);
        debug.write(PropertyConstants.NORMAL, "log file created with "+append+" mode ");
        logger.addAppender(fileAppender);
        debug.write(PropertyConstants.NORMAL, "log file created with name [" + logFileName + "] on " + new Date() );
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    public void write ( String prefix, String message )
    {
        String dateTime = new SimpleDateFormat ("d-MMM-yy, k:m:s").format ( new Date() );
        StringBuffer sb = new StringBuffer ("[CustomTask]: [" + dateTime + "]: " + message );
        synchronized ( logger )
        {
            Level level = null;
            if(Debug_Level.equals(PropertyConstants.ALL))
            {
                level = DebugLevel.ALL;
            }
            else if(Debug_Level.equals(PropertyConstants.NORMAL))
            {
                if (prefix.equals ( PropertyConstants.NORMAL ))
                {
                    level = DebugLevel.NORMAL;
                }
                else if (prefix.equals ( PropertyConstants.ERROR ))
                {
                    level = DebugLevel.ERROR;
                }
            }
            else if(Debug_Level.equals(PropertyConstants.INFO))
            {
                if (prefix.equals ( PropertyConstants.NORMAL ))
                {
                    level = DebugLevel.NORMAL;
                }
                else if (prefix.equals (PropertyConstants.INFO ))
                {
                    level = DebugLevel.INFO;
                }
                else if (prefix.equals ( PropertyConstants.ERROR ))
                {
                    level = DebugLevel.ERROR;
                }
            }
            else if(Debug_Level.equals(PropertyConstants.ERROR))
            {
                level = DebugLevel.ERROR;
            }
            if(level != null)
            {
                logger.setLevel (level);
                logger.log (Debug.class.toString (), level, sb.toString (), null);
                System.out.println(sb.toString());
            }
        }
    }
}