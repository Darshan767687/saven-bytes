package com.saven.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {

    public static Connection getConnection() {

        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String rawUrl = System.getenv("MYSQL_URL");
            String user = System.getenv("MYSQLUSER");
            String pass = System.getenv("MYSQLPASSWORD");

            System.out.println("RAW MYSQL_URL: " + rawUrl);

            // convert Railway format → JDBC format
            String url = rawUrl.replace("mysql://", "jdbc:mysql://");

            con = DriverManager.getConnection(url, user, pass);

            System.out.println("DATABASE CONNECTED SUCCESSFULLY 🚀");

        } catch (Exception e) {
            System.out.println("DATABASE CONNECTION FAILED 💥");
            e.printStackTrace();
        }

        return con;
    }
}