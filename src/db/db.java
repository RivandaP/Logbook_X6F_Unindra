/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;
import java.sql.*;

/**
 *
 * @author keratampan
 */
public class db {
    private Connection conn;
    public Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connection Success");
        }
        catch(ClassNotFoundException ex) {
            System.out.println("Connection Fail"+ex);
        }
        String url = "jdbc:mysql://localhost/visualkkp";
        
       try{
           conn = DriverManager.getConnection(url,"root","");
           System.out.println("Connection to Databases Successfully");
       }
       catch(SQLException ex){
           System.out.println("Connection to Databases Failed"+ex);
       }
       return conn;
    }
    
}
