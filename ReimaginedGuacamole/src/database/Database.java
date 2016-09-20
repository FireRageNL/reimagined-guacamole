/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *Class for connecting to the database
 * @author daan
 */

public class Database {
    private String connectionString;
    
    /**
     * loads the properties from a file
     */
    public void loadProperties(){
        
    }
    
    public void setConnectionString(String connectionString){
        this.connectionString = connectionString;
    }
    
}
