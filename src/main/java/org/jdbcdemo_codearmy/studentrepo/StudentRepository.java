package org.jdbcdemo_codearmy.studentrepo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentRepository {
    String url="jdbc:mysql://localhost:3306/jdbc_demo";
    String username = "root";
    String password = "Kiet@123";
     public void createuser() {
         try {
             Connection connectionobject = DriverManager.getConnection(url, username, password);
             System.out.println("Database connected successfully");

             Statement statement = connectionobject.createStatement();
             String sql1 = "INSERT INTO students(name,email,age)" +
                     "VALUES('Raja','raja@gmail.com',28)";
             int result = statement.executeUpdate(sql1);
             if (result == 1) {
                 System.out.println("creation successful");

             } else {
                 System.out.println("create failed");
             }
             connectionobject.close();
         } catch (SQLException e) {
             System.out.println("Database failed to connect");
             e.printStackTrace();
         }
     }

         /*   public void updateuser()
     {
             try
             {
                 Connection connectionobject  = DriverManager.getConnection(url, username, password);
                 System.out.println("Database connected successfully");

                 Statement statement = connectionobject.createStatement();
                 String sql1 = "UPDATE students SET age =30 "+
                         "WHERE id = 1";
                 int result = statement.executeUpdate(sql1);
                 if(result==1){
                     System.out.println("updation successful");

                 }else{
                     System.out.println("update failed");
                 }
                 connectionobject.close();
             }catch(SQLException e) {
                 System.out.println("Database failed to connect");
                 e.printStackTrace();
             }
             */





     }

