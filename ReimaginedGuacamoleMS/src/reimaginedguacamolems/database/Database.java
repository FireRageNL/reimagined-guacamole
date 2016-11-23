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
     * Only thing that has to be done in the initialization of the class is to
     * read the properties file and load these properties.
     */
    public Database() {
        loadProperties();
    }

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

    /**
     * Insert row(s) into the database
     *
     * @param table is the table to insert the data into
     * @param data is the data to be inserted
     */
    public void insert(String table, Map<String, String> data) {
        try {
            // makes the connection with the database
            initConnection();
            // int for the amount of columns
            int columnCount = 0;
            // loops through the list and adds the column names to the string
            StringBuilder bld = new StringBuilder();
            for (Map.Entry<String, String> entry : data.entrySet()) {
                bld.append(entry.getKey()).append(",");
                columnCount++;
            }
            // string that contains the column names for the query
            String columns = bld.toString();
            // loops through the list and adds the values to the string
            StringBuilder bld2 = new StringBuilder();
            for (int i = 0; i < columnCount; i++) {
                bld2.append("?,");
            }
            // string that contains the values for the query
            String values = bld2.toString();

            // -1 to remove the last , from the string
            values = values.substring(0, values.length() - 1);
            columns = columns.substring(0, columns.length() - 1);

            //makes the query
            String statement = "INSERT INTO  ? (" + columns + ") VALUES (" + values + ")";
            PreparedStatement pst = conn.prepareStatement(statement);
            pst.setString(1, table);
            int valuecount = 1;
            //adds the values as parameters to the prepared statement
            for (Map.Entry<String, String> entry : data.entrySet()) {
                pst.setString(valuecount, entry.getValue());
                valuecount++;
            }
            //executes the query
            pst.executeUpdate();
            pst.close();
            //closes the connection
            closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * update row(s) in a database
     *
     * @param table the table to edit
     * @param data the columns and values to update
     * @param where the "X" part of the "WHERE X = Y" statement
     * @param val the "Y" part of the "WHERE X = Y" statement
     */
    public void update(String table, Map<String, String> data, String where, String val) {
        try {
            //makes the connection
            initConnection();
            //string that contains the column names
            StringBuilder bld = new StringBuilder();
            //loops through the list to add the column names to the string
            for (Map.Entry<String, String> entry : data.entrySet()) {
                bld.append(entry.getKey()).append(" =?, ");
            }
            String columns = bld.toString();
            // -2 to remove the ", " from the last name
            columns = columns.substring(0, columns.length() - 2);
            // makes the statement
            String statement = "UPDATE ? SET " + columns + " WHERE ? = ?";
            PreparedStatement pst = conn.prepareStatement(statement);
            //add statements
            pst.setString(1, table);
            pst.setString(2, where);
            int valuecount = 3;
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
            pst.close();
            closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Read a single column from the database.
     *
     * @param column field to be read
     * @param table from which table the data should be read
     * @param where the "X" part of "WHERE X = Y"
     * @param value the "Y" part of "WHERE X = Y"
     * @return The data read from the database
     */
    public String readStringWithCondition(String column, String table, String where, String value) {
        String result = "";
        try {
            //opens the connection
            initConnection();
            //makes the statement
            String sql = "SELECT ? FROM ? WHERE ? = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            //sets the parameters
            ps.setString(1, column);
            ps.setString(2, table);
            ps.setString(3, where);
            ps.setString(4, value);
            //resultset to store the values
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                //sets the result
                result = rs.getString(column);
            }
            //closes the connection
            ps.close();
            closeConnection();

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        //returns the result
        return result;
    }

    /**
     * Read multiple columns from a table
     *
     * @param columns the colums to be read
     * @param table the table to read the colunns from
     * @param where the "X" part of "WHERE X = Y"
     * @param value the "Y" part of "WHERE X = Y"
     * @return The data read from the database
     */
    public List<String> readStringWithCondition(List<String> columns, String table, String where, String value) {
        //list to store the results
        List<String> result = new ArrayList<>();
        //string for the columns
        try {
            //makes the connection to the database
            initConnection();
            //loops to the list to add the column names to the string
            StringBuilder bld = new StringBuilder();
            for (String c : columns) {
                bld.append(c).append(", ");
            }
            String column = bld.toString();
            //removes the last 2 characters of the string
            column = column.substring(0, column.length() - 2);
            //makes the statement
            String sql = "SELECT ? FROM ? WHERE ? = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            //sets the parameters
            ps.setString(1, column);
            ps.setString(2, table);
            ps.setString(3, where);
            ps.setString(4, value);
            //stores the result in the resultset
            ResultSet rs = ps.executeQuery();
            //metadata is needed to get the amount of columns returned
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                //loops through the results and adds them to the list
                for (int i = 1; i < (rsmd.getColumnCount() + 1); i++) {
                    result.add(rs.getString(i));
                }
            }
            //closes the connection
            ps.close();
            closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        //returns the list
        return result;
    }

    /**
     * Function to use a "IN" statement in a SQL select query
     *
     * @param columns the columns to get
     * @param table the table to get the columns from
     * @param where the X part of "Where X = Y"
     * @param value the Y part of "Where X = Y"
     * @param amount the amount of parameters
     * @return the data read from the database
     */
    public List<String> readWithInCondition(List<String> columns, String table, String where, List<String> value, int amount) {
        //list to store the results in
        List<String> result = new ArrayList<>();
        //sets a ?, for every parameter to the string parametes
        StringBuilder bld = new StringBuilder();
        for (int i = 1; i <= amount; i++) {
            bld.append("?,");
        }
        //string for the parameters
        String parameters = bld.toString();
        //remove the last , from the string
        parameters = parameters.substring(0, parameters.length() - 1);

        try {
            // opens the connection
            initConnection();
            //loops through te list to add the column names
            StringBuilder bld2 = new StringBuilder();
            for (String c : columns) {
                bld2.append(c).append(", ");
            }
            //string for the column names
            String column = bld2.toString();
            //removes the last 2 characters from the string
            column = column.substring(0, column.length() - 2);
            //sets the statament
            String sql = "SELECT ? FROM ? WHERE ? IN ( ? )";
            PreparedStatement ps = conn.prepareStatement(sql);
            //sets the parameter
            ps.setString(1, column);
            ps.setString(2, table);
            ps.setString(3, where);
            ps.setString(4, parameters);
            //gets the value for every parameter
            for (int i = 0; i < amount; i++) {
                ps.setString(i + 1, value.get(i));
            }
            //executes the query
            ResultSet rs = ps.executeQuery();
            //gets the metadata to get the amount of results
            ResultSetMetaData rsmd = rs.getMetaData();
            //loops through the results and adds them to the list
            while (rs.next()) {
                for (int i = 1; i < (rsmd.getColumnCount() + 1); i++) {
                    result.add(rs.getString(i));
                }
            }
            closeConnection();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        //returns the result
        return result;
    }

    /**
     * Creating the database connection
     */
    public void initConnection() {
        try {
            //connectionstring
            conn = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + databasename, username, password);

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Closing the database connection
     *
     * @throws SQLException if something went wrong closing it.
     */
    public void closeConnection() throws SQLException {
        conn.close();
    }

}
