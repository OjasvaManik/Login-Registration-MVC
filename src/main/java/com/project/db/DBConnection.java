package com.project.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String dbUrl = "jdbc:mysql://localhost:3306/iist_login_register";
    private static final String dbUser = "root";
    private static final String dbPass = "root";

    private static Connection conn = null;

    static{

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static Connection getConnection(){
        return conn;
    }

}
