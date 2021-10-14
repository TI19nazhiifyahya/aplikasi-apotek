/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.sql.*;

/**
 *
 * @author Nazhiif Yahya
 */
public class DbConn {
    private Connection myConnection;
    String user = "root";
    String pass = "";
    
    /** Creates a new instance of MyDBConnection */
    public DbConn() {
        init();
    }

    private void init(){
    
       try{
        
        myConnection=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/aplikasi_apotek?serverTimezone=UTC", user, pass
                );
        }
        catch(SQLException e){
            System.out.println("Failed to get connection");
        }
    }
    
    
    public Connection getMyConnection(){
        return myConnection;
    }
    
    
    public void close(ResultSet rs){
        
        if(rs !=null){
            try{
               rs.close();
            }
            catch(SQLException e){}
        
        }
    }
    
    public void close(java.sql.Statement stmt){
        
        if(stmt !=null){
            try{
               stmt.close();
            }
            catch(SQLException e){}
        
        }
    }
     
    public void destroy(){

        if(myConnection !=null){

            try{
                myConnection.close();
            }
            catch(SQLException e){}

        }
    }

}
