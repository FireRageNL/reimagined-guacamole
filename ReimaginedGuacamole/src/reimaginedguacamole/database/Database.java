/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Class for connecting to the database
 * @author daan
 */

public class  Database {
    private Connection conn;
    
    /**
     * loads the properties from a file
     */
    public void loadProperties(){
        
    }

    public Database() {
        initConnection();
    }
    
    public void Insert(String table, Map<String, String> data){
        try {
            int columnCount = 0;
            String columns = "";
            String values = "";
            
            for (Map.Entry<String, String> entry : data.entrySet()) {
            columns += (entry.getKey()+",");
            columnCount++;
            }
            for (int i = 0; i < columnCount; i++) {
                values += "?,";
            }
            
            values = values.substring(0,values.length()-1);
            columns = columns.substring(0,columns.length()-1);

            String statement = "INSERT INTO "+table+" ("+ columns +") VALUES ("+values+")";
            PreparedStatement pst = conn.prepareStatement(statement);
            System.out.println(statement);
            
            int valuecount = 1;
            for (Map.Entry<String, String> entry : data.entrySet()) {
                pst.setString(valuecount, entry.getValue());
                valuecount++;
            }
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Update(String table, Map<String, String> data, String where, String val){
        try {
            String columns = "";
            for (Map.Entry<String, String> entry : data.entrySet()) {
            columns += (entry.getKey()+" = ?, ");
            }
            columns = columns.substring(0,columns.length()-2);

            String statement = ("UPDATE " +table +" SET " + columns + " WHERE " + where + " = ?");
            PreparedStatement pst = conn.prepareStatement(statement);
            System.out.println(statement);
            
            int valuecount = 1;
            for (Map.Entry<String, String> entry : data.entrySet()) {
                pst.setString(valuecount, entry.getValue());
                valuecount++;
            }
            pst.setString(valuecount,val);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String ReadStringWithCondition()
    {
        return "";
    }
    
    public void initConnection(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://daantuller.nl:3306/mydb","Guacamole","Guacamole01");
            System.out.println("Connection ok.");
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void closeConnection() throws SQLException{
        conn.close();
    }
    
}
