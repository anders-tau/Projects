/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import com.mysql.cj.xdevapi.Statement;
import java.io.*;
import java.nio.file.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Anders
 */
public class JavaApplication1 {
    /**
     * @param args the command line arguments
     */
    private static Statement stmt;
    private static ResultSet rs;
    
    public static void main(String[] args) throws IOException {
        try{
             //String url = "jdbc:mysql://localhost:3306/test?serverTimezone=Europe/Moscow";
             //String username = "root";
             //String password = "678hkj12";
             //try (Connection conn = DriverManager.getConnection(url, username, password)){
             try (Connection conn = getConnection()){
                System.out.println("Соединение с базой установлено!");
                //Работа с БД test
                
                String Query = "SELECT * FROM users";
                //String Update_str = "INSERT users(name, age) VALUES ('Andrey', 46), ('Svetlana', 43), ('Maria', 17), ('Grigory', 12)";
                
                java.sql.Statement stmt = conn.createStatement();
                //int rows = stmt.executeUpdate(Update_str);
                java.sql.ResultSet rs = stmt.executeQuery(Query);
                int columns = rs.getMetaData().getColumnCount();
                while(rs.next()){
                    for (int i = 1; i <= columns; i++){
                        System.out.print(rs.getString(i) + "\n");
                    }
                }
                if(rs != null)
                    rs.close();
                if(stmt != null)
                    stmt.close();
                if(conn != null)
                    conn.close();
             }
         }
         catch(SQLException ex){
             System.out.println("Соединение не установлено...");
             System.out.println(ex);
         }
    }

    public static Connection getConnection() throws IOException, SQLException {
         
        Properties props = new Properties();
        Path db_prop = Paths.get("C:/Projects/JavaApplication1/src/javaapplication1", "database.properties");
        try(InputStream in = Files.newInputStream(db_prop)){
            props.load(in);
        }
        String url = props.getProperty("url");
        String username = props.getProperty("username");
        String password = props.getProperty("password");
         
        return DriverManager.getConnection(url, username, password);
    }    
    
    private static class ResultSet {

        public ResultSet() {
        }
    }
    
}
