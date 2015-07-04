/*
 * NewMain.java
 *
 * Created on February 10, 2004, 6:27 PM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

//package com.impetus.neustar.asr.db;

/**
 *
 * @author rhgupta
 */
public class NewMain {

    /** Creates a new instance of NewMain */
    public NewMain() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        if( DBConnection.isConnected() )
            System.out.println("Connection successful");
        else
            System.out.println("Connection failed");
    }

}