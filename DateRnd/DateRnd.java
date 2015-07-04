import java.util.*;
import java.sql.Date;
public class DateRnd
{
    public static void main(String[] args)
    {
        java.util.Date dt = new java.util.Date();
        //java.sql.Date sqlDate = new java.sql.Date(dt.getYear(),dt.getMonth(),dt.getDay());
        System.out.println("Current date is "+ dt.getTime());

    }
}