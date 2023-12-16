/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databaseclass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hasan
 */
public class checkIfDataExist {
    static Boolean isExist(String selectedId){

        try(Connection conn = Connector.connectDB()){
            PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM datatable WHERE id=?");
            ps.setString(1, selectedId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int count = rs.getInt(1);
                return count > 0;
            }else {
                return false;
            }
        }catch(SQLException e){
            Logger.getLogger(ShowDataTable.class.getName()).log(Level.SEVERE, "Error is: ", e);
        }
        return false;
        
    }    
}
