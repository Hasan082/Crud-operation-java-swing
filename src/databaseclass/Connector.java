
package databaseclass;
import java.sql.*;


public class Connector {
    static Connection connectDB(){
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/swigninfo", "root", "");
            System.out.println("Data Connected Succesfully");
            return conn;
        } catch (SQLException e) {
            return null;
        }
    }

}
