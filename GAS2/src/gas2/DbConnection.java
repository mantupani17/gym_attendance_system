/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gas2;

/**
 *
 * @author Handshakeyou
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class DbConnection {
 
    public static void main(String[] args) throws ClassNotFoundException {
 
        // variables
        Connection connection = null;
        
            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                connection = DriverManager.getConnection("jdbc:ucanaccess://E:\\java\\GAS2\\src\\Mydatabase.accdb;jackcessOpener=CryptCodecOpener", "mantu", "deepi");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
    
    }
}