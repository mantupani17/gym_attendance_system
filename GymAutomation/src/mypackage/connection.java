
package mypackage;

/**
 *
 * @author mantu
 */
import java.sql.*;

public class connection {
    Connection con;
    //Statement stm;
    public connection() throws ClassNotFoundException
    {
        try{
            con=DriverManager.getConnection("jdbc:odbc:BDB", "mantu", "DEEPS");
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        }
        catch(SQLException e)
        {
            
        }
    }
}
