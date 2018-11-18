/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.*;
import net.ucanaccess.jdbc.JackcessOpenerInterface;
import com.healthmarketscience.jackcess.CryptCodecProvider;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;

/**
 *
 * @author Handshakeyou
 */
public class DbConnection {
    private static String url="jdbc:ucanaccess://Mydatabase.accdb";
    private static Connection conn ;
    public static void getDbConnection() throws SQLException, ClassNotFoundException
    {
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        conn = DriverManager.getConnection(url,"mantu","deepi");
        if(conn!=null)
        {
            System.out.println("connected");
        }
        else
        {
            System.out.println("Error");
        }
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        getDbConnection();
    }
    
}
