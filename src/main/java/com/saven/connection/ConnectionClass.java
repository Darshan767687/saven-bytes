package com.saven.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = System.getenv("MYSQL_URL");
            String user = System.getenv("MYSQLUSER");
            String pass = System.getenv("MYSQLPASSWORD");

            // DEBUG (remove later)
            System.out.println("DB URL: " + url);
            System.out.println("DB USER: " + user);

            con = DriverManager.getConnection(url, user, pass);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
