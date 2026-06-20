package com.saven.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {

    public static Connection getConnection() {

        Connection con = null;

        try {

            // Load MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            String host = System.getenv("MYSQLHOST");
            String port = System.getenv("MYSQLPORT");
            String database = System.getenv("MYSQLDATABASE");
            String user = System.getenv("MYSQLUSER");
            String pass = System.getenv("MYSQLPASSWORD");

            String url = "jdbc:mysql://" + host + ":" + port + "/" + database;

            System.out.println("DB URL: " + url);
            System.out.println("DB USER: " + user);

            con = DriverManager.getConnection(url, user, pass);

            System.out.println("DATABASE CONNECTED SUCCESSFULLY");

        } catch (Exception e) {
            System.out.println("DATABASE CONNECTION FAILED");
            e.printStackTrace();
        }

        return con;
    }
}