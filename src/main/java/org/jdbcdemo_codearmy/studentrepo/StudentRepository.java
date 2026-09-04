package org.jdbcdemo_codearmy.studentrepo;

import org.jdbcdemo_codearmy.model.Student;

import java.sql.*;


public class StudentRepository {
    String url="jdbc:mysql://localhost:3306/jdbc_demo";
    String username = "root";
    String password = "${DB_PASSWORD}";
     public void createuser() {
         try {
             Connection connectionobject = DriverManager.getConnection(url, username, password);
             System.out.println("Database connected successfully");

             Statement statement = connectionobject.createStatement();
             String sql1 = "INSERT INTO students(name,email,age)" +
                     "VALUES('Deepak','ds@gmail.com',21)";
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

           public void updateuser() {
               try {
                   Connection connectionobject = DriverManager.getConnection(url, username, password);
                   System.out.println("Database connected successfully");

                   Statement statement = connectionobject.createStatement();
                   String sql1 = "UPDATE students SET age =35 " +
                           "WHERE id = 1";
                   int result = statement.executeUpdate(sql1);
                   if (result == 1) {
                       System.out.println("updation successful");

                   } else {
                       System.out.println("update failed");
                   }
                   connectionobject.close();
               } catch (SQLException e) {
                   System.out.println("Database failed to connect");
                   e.printStackTrace();
               }
           }
    public void deleteuser() {
        try {
            Connection connectionobject = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected successfully");

            Statement statement = connectionobject.createStatement();
            String sql1 = "DELETE FROM students "+
                    "WHERE id = 3";
            int result = statement.executeUpdate(sql1);
            if (result == 1) {
                System.out.println("deletion successful");

            } else {
                System.out.println("deletion failed");
            }
            connectionobject.close();
        } catch (SQLException e) {
            System.out.println("Database failed to connect");
            e.printStackTrace();
        }
    }

    public void readuser() {
        try {
            Connection connectionobject = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected successfully");

            Statement statement = connectionobject.createStatement();
            String sql1 = "SELECT id , name , email , age " +
                    "FROM students ";

            ResultSet resultset = statement.executeQuery(sql1);



            while(resultset.next()) {

                Student student = mapRow(resultset);
                System.out.println(student);
            }


            connectionobject.close();
        } catch (SQLException e) {
            System.out.println("Database failed to connect");
            e.printStackTrace();
        }
    }
    //-----------------------------------------------------
    public void completeCRUD(){

            try {
                Connection connectionobject = DriverManager.getConnection(url, username, password);
                System.out.println("Database connected successfully");

                Statement statement = connectionobject.createStatement();

                String sql1 = "SELECT id , name , email , age FROM students "+
                        "WHERE id = 5";

                boolean result = statement.execute(sql1);
                if(result){
                    ResultSet resultset = statement.getResultSet();
                }else{
                    int rowaffected = statement.getUpdateCount();
                }


                connectionobject.close();
            } catch (SQLException e) {
                System.out.println("Database failed to connect");
                e.printStackTrace();
            }



    }
        private Student mapRow(ResultSet resultset) throws SQLException {

            Student student = new Student();
            
            student.setId(resultset.getLong("id"));
            student.setName(resultset.getString("name"));
            student.setEmail(resultset.getString("email"));
            student.setAge(resultset.getInt("age"));

             return student;
        }








}

