/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class for connecting to the database
 *
 * @author daan
 */
public class Database {

    protected Connection conn;
    private String password;
    private String host;
    private String databasename;
    private String username;
    /**
     * loads the properties from a file
     */
    public void loadProperties() {
try {
            Properties prop = new Properties();
            try (InputStream in = new FileInputStream("database.properties")) {
                prop.load(in);
                Enumeration<?> e = prop.propertyNames();
                String key = (String) e.nextElement();
                password = prop.getProperty(key);
                key = (String) e.nextElement();
                host = prop.getProperty(key);
                key = (String) e.nextElement();
                databasename = prop.getProperty(key);
                key = (String) e.nextElement();
                username = prop.getProperty(key);
            }
        } catch (IOException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Database() {
        loadProperties();
    }

    public void Insert(String table, Map<String, String> data) {
        try {
            initConnection();
            int columnCount = 0;
            String columns = "";
            String values = "";

            for (Map.Entry<String, String> entry : data.entrySet()) {
                columns += (entry.getKey() + ",");
                columnCount++;
            }
            for (int i = 0; i < columnCount; i++) {
                values += "?,";
            }

            values = values.substring(0, values.length() - 1);
            columns = columns.substring(0, columns.length() - 1);

            String statement = "INSERT INTO " + table + " (" + columns + ") VALUES (" + values + ")";
            PreparedStatement pst = conn.prepareStatement(statement);
            System.out.println(statement);

            int valuecount = 1;
            for (Map.Entry<String, String> entry : data.entrySet()) {
                pst.setString(valuecount, entry.getValue());
                valuecount++;
            }
            pst.executeUpdate();
            closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Update(String table, Map<String, String> data, String where, String val) {
        try {
            initConnection();
            String columns = "";
            for (Map.Entry<String, String> entry : data.entrySet()) {
                columns += (entry.getKey() + " = ?, ");
            }
            columns = columns.substring(0, columns.length() - 2);

            String statement = ("UPDATE " + table + " SET " + columns + " WHERE " + where + " = ?");
            PreparedStatement pst = conn.prepareStatement(statement);
            System.out.println(statement);

            int valuecount = 1;
            for (Map.Entry<String, String> entry : data.entrySet()) {
                pst.setString(valuecount, entry.getValue());
                valuecount++;
            }
            pst.setString(valuecount, val);
            pst.executeUpdate();
            closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String ReadStringWithCondition(String column, String table, String where, String value) {
        String result = "";
        try {
            initConnection();
            String sql = "SELECT " + column + " FROM " + table + " WHERE " + where + " = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, value);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = rs.getString(column);
            }
            closeConnection();

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println(result);
        return result;
    }

    public List<String> ReadStringWithCondition(List<String> columns, String table, String where, String value) {
        List<String> result = new ArrayList<String>();
        String column = "";
        try {
            initConnection();
            for (String c : columns) {
                column += (c + ", ");
            }
            column = column.substring(0, column.length() - 2);
            String sql = "SELECT " + column + " FROM " + table + " WHERE " + where + " = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, value);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            while(rs.next()){
                for (int i = 1; i <( rsmd.getColumnCount() + 1); i++) {
                    result.add(rs.getString(i));
                }
            }
            closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }
    
     public List<String> ReadWithInCondition(List<String> columns, String table, String where, List<String> value, int amount) {
        List<String> result = new ArrayList<String>();
        String column = "";
        String parameters = "";
        
         for (int i = 1; i <= amount; i++) {
             parameters += "?,";
         }
         parameters = parameters.substring(0, parameters.length() - 1);
         
        try {
            initConnection();
            for (String c : columns) {
                column += (c + ", ");
            }
            
            column = column.substring(0, column.length() - 2);
            String sql = "SELECT " + column + " FROM " + table + " WHERE " + where + " IN ("+parameters+")";
            PreparedStatement ps = conn.prepareStatement(sql);
             for (int i = 0; i < amount; i++) {
             ps.setString((i + 1), value.get(i));
         }
            
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            while(rs.next()){
                for (int i = 1; i <( rsmd.getColumnCount() + 1); i++) {
                    result.add(rs.getString(i));
                }
            }
            closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    public void initConnection() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://"+host+":3306/"+databasename, username, password);
            System.out.println("Connection ok.");

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void closeConnection() throws SQLException {
        conn.close();
        System.out.println("Connection closed.");
    }

}