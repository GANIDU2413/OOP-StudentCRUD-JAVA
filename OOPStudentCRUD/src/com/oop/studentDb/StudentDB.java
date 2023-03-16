/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oop.studentDb;


import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author ganidusahan
 */
public class StudentDB {
    
    static Connection con;
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:8889/studentinfo";
    static String uname = "root";
    static String pass = "root";
    
    
    public static Connection getConnection() throws Exception{
        if(con == null){
            Class.forName(driver);
            con = DriverManager.getConnection(url,uname,pass);
        }
        return con;
    }
    
}
