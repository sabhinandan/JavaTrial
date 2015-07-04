/*
 * DBConnection.java
 *
 * Created on January 10, 2006, 5:51 PM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

//package com.impetus.neustar.asr.db;

import java.sql.*;

public final class DBConnection {
    private static DBConnection dbConnection = new DBConnection( DBInterface.DRIVER, DBInterface.URL, DBInterface.USERNAME, DBInterface.PWD);
    private static Connection con;
    private static boolean isConnected;
    /** Creates a new instance of DBConnection */
    private DBConnection( String driver, String url, String un, String pwd) {
        con = null;
        isConnected = false;
        makeConnection(driver, url, un, pwd);
    }

    /**
     * To establish connection with the specified database
     * @author Rohit Gupta
     */
    private void makeConnection(String driver, String url, String un, String pwd) {
        try {
          /*  DriverManager.registerDriver( (Driver)Class.forName( "oracle.jdbc.driver.OracleDriver" ).newInstance() );
            con=DriverManager.getConnection("jdbcracle:thin:@192.168.101.30:1521:IMP244","chitra34","chitra34");
            */
            System.out.println("Driver value is "+driver);
//            Class.forName(driver);
            DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
            System.out.println( "Driver loaded");

            con = DriverManager.getConnection(url, un, pwd );
            isConnected = true;
        } catch( SQLException sqlex ) {
            System.err.println("Cannot establish connection with database\n" + sqlex);
            sqlex.printStackTrace();
        }
          catch(Exception e) {
          }

    }

    /**
     * Return true if connection with the database is established otherwise false
     * @return isConnected return true if true/false depending upon connection status
     */
    public static boolean isConnected() {
        return isConnected;
    }

    /**
     * Return the Singleton Connection reference
     * @return con return the Singleton Connection reference
     */
    public static Connection getConnection() {
        return con;
    }
}