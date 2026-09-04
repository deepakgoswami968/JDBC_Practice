package org.jdbcdemo_codearmy;


import org.jdbcdemo_codearmy.studentrepo.StudentRepository;

import java.sql.*;

public class Main {
    public static void main(String[] args){
    String url="jdbc:mysql://localhost:3306/jdbc_demo";
    String username = "root";
    String password = "Kiet@123";
        StudentRepository sr = new StudentRepository();
        //sr.createuser();
        //sr.updateuser();
      //  sr.deleteuser();

        //executeupdate -- teeno k liye use hota hai (create matlb insert)delete update
        //execute --READ
        //executeQuery -- GeneralPurpose(CURD)
        sr.readuser();




    }

}
