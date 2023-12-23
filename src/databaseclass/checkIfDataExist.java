
package databaseclass;

import java.sql.*;

/**
 *
 * @author hasan
 */
public class checkIfDataExist {
    
        private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Connector.class.getName());
        
        static boolean isExist(String selectedId){
        try(Connection conn = Connector.connectDB()){
            PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM datatable WHERE id=? ");
            ps.setString(1, selectedId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int count = rs.getInt(1);
                return count > 0;
            }else {
                return false;
            }
        }
        catch(SQLException e) {
           logger.log(java.util.logging.Level.SEVERE, "Error is:", e);
        }
        return false;
    }
    
}
