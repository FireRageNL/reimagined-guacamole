/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamolems.database;

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
            //properties for the connection
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
            // makes the connection with the database
            initConnection();
            // int for the amount of columns
            int columnCount = 0;
            // string that contains the column names for the query
            String columns = "";
            // string that contains the values for the query
            String values = "";
            
            // loops through the list and adds the column names to the string
            for (Map.Entry<String, String> entry : data.entrySet()) {
                columns += (entry.getKey() + ",");
                columnCount++;
            }
            // loops through the list and adds the values to the string
            for (int i = 0; i < columnCount; i++) {
                values += "?,";
            }
            
            // -1 to remove the last , from the string
            values = values.substring(0, values.length() - 1);
            columns = columns.substring(0, columns.length() - 1);
            
            //makes the query
            String statement = "INSERT INTO " + table + " (" + columns + ") VALUES (" + values + ")";
            PreparedStatement pst = conn.prepareStatement(statement);
            System.out.println(statement);

            int valuecount = 1;
            //adds the values as parameters to the prepared statement
            for (Map.Entry<String, String> entry : data.entrySet()) {
                pst.setString(valuecount, entry.getValue());
                valuecount++;
            }
            //executes the query
            pst.executeUpdate();
            //closes the connection
            closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Update(String table, Map<String, String> data, String where, String val) {
        try {
            //makes the connection
            initConnection();
            //string that contains the column names
            String columns = "";
            //loops through the list to add the column names to the string
            for (Map.Entry<String, String> entry : data.entrySet()) {
                columns += (entry.getKey() + " = ?, ");
            }
            // -2 to remove the ", " from the last name
            columns = columns.substring(0, columns.length() - 2);
            // makes the statement
            String statement = ("UPDATE " + table + " SET " + columns + " WHERE " + where + " = ?");
            PreparedStatement pst = conn.prepareStatement(statement);
            System.out.println(statement);
            
            int valuecount = 1;
            //loops through the list to add the values for the prepared statement
            for (Map.Entry<String, String> entry : data.entrySet()) {
                pst.setString(valuecount, entry.getValue());
                valuecount++;
            }
            //sets the parameters
            pst.setString(valuecount, val);
            //executes the query
            pst.executeUpdate();
            //closes the connection
            closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String ReadStringWithCondition(String column, String table, String where, String value) {
        String result = "";
        try {
            //opens the connection
            initConnection();
            //makes the statement
            String sql = "SELECT " + column + " FROM " + table + " WHERE " + where + " = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            //sets the parameter
            ps.setString(1, value);
            //resultset to store the values
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                //sets the result
                result = rs.getString(column);
            }
            //closes the connection
            closeConnection();

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println(result);
        //returns the result
        return result;
    }

    public List<String> ReadStringWithCondition(List<String> columns, String table, String where, String value) {
        //list to store the results
        List<String> result = new ArrayList<String>();
        //string for the columns
        String column = "";
        try {
            //makes the connection to the database
            initConnection();
            //loops to the list to add the column names to the string
            for (String c : columns) {
                column += (c + ", ");
            }
            //removes the last 2 characters of the string
            column = column.substring(0, column.length() - 2);
            //makes the statement
            String sql = "SELECT " + column + " FROM " + table + " WHERE " + where + " = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            //sets the parameter
            ps.setString(1, value);
            //stores the result in the resultset
            ResultSet rs = ps.executeQuery();
            //metadata is needed to get the amount of columns returned
            ResultSetMetaData rsmd = rs.getMetaData();
            while(rs.next()){
                //loops through the results and adds them to the list
                for (int i = 1; i <( rsmd.getColumnCount() + 1); i++) {
                    result.add(rs.getString(i));
                }
            }
            //closes the connection
            closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        //returns the list
        return result;
    }
    
     public List<String> ReadWithInCondition(List<String> columns, String table, String where, List<String> value, int amount) {
        //list to store the results in
        List<String> result = new ArrayList<String>();
        //string for the column names
        String column = "";
        //string for the parameters
        String parameters = "";
        //sets a ?, for every parameter to the string parametes
         for (int i = 1; i <= amount; i++) {
             parameters += "?,";
         }
         //remove the last , from the string
         parameters = parameters.substring(0, parameters.length() - 1);
         
        try {
            // opens the connection
            initConnection();
            //loops through te list to add the column names
            for (String c : columns) {
                column += (c + ", ");
            }
            //removes the last 2 characters from the string
            column = column.substring(0, column.length() - 2);
            //sets the statament
            String sql = "SELECT " + column + " FROM " + table + " WHERE " + where + " IN ("+parameters+")";
            PreparedStatement ps = conn.prepareStatement(sql);
            //gets the value for every parameter
             for (int i = 0; i < amount; i++) {
             ps.setString((i + 1), value.get(i));
         }
            //executes the query
            ResultSet rs = ps.executeQuery();
            //gets the metadata to get the amount of results
            ResultSetMetaData rsmd = rs.getMetaData();
            //loops through the results and adds them to the list
            while(rs.next()){
                for (int i = 1; i <( rsmd.getColumnCount() + 1); i++) {
                    result.add(rs.getString(i));
                }
            }
            closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        //returns the result
        return result;
    }

    public void initConnection() {
        try {
            //connectionstring
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