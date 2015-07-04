/*
 * InitHash.java
 *
 * Created on January 11, 2006, 1:20 PM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

//package com.impetus.neustar.asr.db;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author rhgupta
 */
public class InitHash {

    /** Creates a new instance of InitHash */
    public InitHash() {
    }

    public Vector getCustomerId() {
        ResultSet rst = null;
        Statement stmt = null;
        Connection con = null;
        String SQLQuery = "";
        Vector vector = new Vector();

        try {
            //get connection
            con = DBConnection.getConnection();

            //create statement
            stmt = con.createStatement();

            SQLQuery = "SELECT DISTINCT CUSTOMERID " +
                    "FROM persistentproperty";

            //execute the query and return resultset
            rst = stmt.executeQuery( SQLQuery );

            while( rst.next() ) {
                vector.add(rst.getString(1));   //add the customer id to the vector
            }

            return vector;  //on success return vector
        } catch( SQLException sqlex ) {
            System.err.println("Error in fetching distinct Customer ID " + sqlex );
        } finally {
            try {
                if( stmt != null ) {
                    stmt.close();
                    stmt = null;
                }
                if( rst != null ) {
                    rst.close();
                    rst = null;
                }
            }catch( SQLException sqlex ) {
                System.err.println( sqlex );
            }
        }
        return null;
    }

}