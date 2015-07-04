import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.sql.PreparedStatement;
public class DBTrial
{
    public static void main(String[] args) throws SQLException
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String GET_USER_DETAIL = "select * from USER_DETAIL where user_name = ?";
        String DEPLOY_DETAIL = "select * from DEPLOY_DETAIL";
        String empDetail = "select * from empl";
        try
        {
            //DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver ());
            //connection = DriverManager.getConnection ("jdbc:oracle:thin:@192.168.97.97:1521:nstar", "depdemotest", "depdemotest");
              System.out.println("111");
              Class.forName ("com.mysql.jdbc.Driver").newInstance ();
              System.out.println("222");
              connection = DriverManager.getConnection("jdbc:mysql://localhost/test","root","oracle");
            //connection = DriverManager.getConnection (strDBString, strDBUser, strDBPassword);
            System.out.println("333");
            if (connection == null)
            {
                System.out.println("Getting connection null");
                throw new SQLException ("Error getting database connection");
            }
        }
        catch (Exception se)
        {
            se.printStackTrace();
        }

        //preparedStatement = connection.prepareStatement(GET_USER_DETAIL,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        //preparedStatement.setString(1,"example");
         Statement st = connection.createStatement();


        resultSet = st.executeQuery(empDetail);
        //int rowCount = getRow(resultSet);
        //System.out.println(rowCount);
        //resultSet = preparedStatement.executeQuery();
        //resultSet.beforeFirst();
        while(resultSet.next())
        {
            System.out.println(resultSet.getString("ename"));
            System.out.println(resultSet.getString("job"));
        }

    }
    private static int getRow(ResultSet rs)
    {
        int rowCount=0;
        try
        {
            while(rs.next())
            {
                rowCount++;
            }
        }
        catch(SQLException se)
        {
            se.printStackTrace();
        }

        return rowCount;
    }

}