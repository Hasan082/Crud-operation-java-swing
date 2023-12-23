
package databaseclass;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connector {
    
    private static final Logger logger = Logger.getLogger(Connector.class.getName());

    static Connection connectDB(){
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/swigninfo", "root", "");
            logger.info("Database Connected Succesfully");
            return conn;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error is:", e);
            return null;
        }
    }
}
