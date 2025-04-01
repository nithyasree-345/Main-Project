package servelet;

import java.sql.DriverManager;
import java.sql.Connection;

public class UserConnect
{   
    public static Connection getConnection()
    {
        Connection con=null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/trekk","root","nithya");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return con;
    }
}