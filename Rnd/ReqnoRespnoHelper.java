/**
 * Copyright (c) 2004-2005 Neustar Software, Inc.  All rights reserved.
 *
 * $Header$
 */
//package com.nightfire.manager.wnp.state.utils;

import java.util.*;

import com.nightfire.framework.util.*;
import com.nightfire.framework.db.*;
//import com.nightfire.common.ProcessingException;


public class ReqnoRespnoHelper
{

    public static void main(String args)
    {
    String str=getReqno("nnsp")
        System.out.println();
    }
    /**
     * Name of the intermodal wpr message sequence
     */
    private static final String WPR_REQNO_SEQUENCE = "AutoResponseNumberSeq";
    private static final String WPRR_REQNO_SEQUENCE = "AutoRequestNumberSeq";

    /**
     * Generates the REQNO based on the NNSPIYYJJJXXXXXX format
     *
     * @param  nnsp
     *
     * @exception  ProcessingException  Thrown on errors.
     */
    public static String getReqno (String nnsp ,String seq)  //throws ProcessingException
    {
        try
        {
              // Reqno format is the following NNSPIYYJJJXXXXXX

              // adding the NNSP
              String reqno = nnsp;

              // adding the 'I', we are using 1
              reqno = reqno + "1";

              // adding year
              Calendar currentCalendar = Calendar.getInstance();
              reqno = reqno + String.valueOf(currentCalendar.get(Calendar.YEAR)).substring(2,4);

              // adding day of year, JJJ
              String dayOfYear = String.valueOf(currentCalendar.get(Calendar.DAY_OF_YEAR));
              reqno = reqno + StringUtils.padString(dayOfYear, 3, true, '0');

              // add reqno sequence from DB
              String sequence = String.valueOf(PersistentSequence.getNextSequenceValue(seq));
              sequence = StringUtils.padString(sequence, 6, true, '0');
              reqno = reqno + sequence;

              return reqno;

          }
          catch (Exception e)
          {
              Debug.logStackTrace(e);
          //    throw new ProcessingException("ERROR: An error has occured while generating the REQNO :" + e.getMessage());
                    return "error";
          }
      }


    public static String getReqno (String onsp ) //   throws ProcessingException
  {
      return getReqno (onsp,WPR_REQNO_SEQUENCE );
  }
  /**
   * Generates the RESPNO based on the ONSPIYYJJJXXXXXX format
   *
   * @param  onsp
   *
   * @exception  ProcessingException  Thrown on errors.
   */
  public static String getRespno (String onsp )  // throws ProcessingException
  {
     return getReqno (onsp,WPRR_REQNO_SEQUENCE );
  }

}